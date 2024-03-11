package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.ScreenUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class HardwareFeatureSteps {

	WebDriver driver = new ChromeDriver();
	DataPojo detailsData = new DataPojo();
	DataPojo dimentionData = new DataPojo();

	@Given("user is on product page using {string}")
	public void user_is_on_product_page(String link) throws Exception {
		System.out.println("###### Launching product page");
		try {
			System.out.println("Launching : " + link);
			driver.get(link);

			// First it opens the English Page so launching this again
			driver.get(link);
			driver.manage().window().maximize();
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}
	
	@When("expand all details")
	public void expand_all_details() throws Exception {
		Thread.sleep(1000);
		WebElement details = driver.findElement(
				By.xpath("//*[@id=\"main\"]/div/div[1]/div[1]/div/div[2]/div/div/div[4]/div[2]/div[1]/div"));
		details.click();
		WebElement dimentions = driver
				.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[1]/div/div[2]/div/div/div[4]/div[3]/div[1]"));
		dimentions.click();
		System.out.println("#### Expanding details");
		Thread.sleep(3000);
	}

	@Then("gather information from product page")
	public void gather_information_from_product_page() throws Exception {
		WebElement detailsText = driver
				.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[1]/div/div[2]/div/div/div[4]/div[2]/div[2]"));

		String[] details = detailsText.getText().split("\n");
		for (String s : details) {
			detailsData.addData(s);
		}
		System.out.println("Details data from Website : " + detailsData.getDataList());
		WebElement dimentionsText = driver
				.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[1]/div/div[2]/div/div/div[4]/div[3]/div[2]"));
		String[] dimentions = dimentionsText.getText().split("\n");
		for (String s : dimentions) {
			dimentionData.addData(s);
		}
		System.out.println("Dimentions data from Website : " + dimentionData.getDataList());
	}

	@Then("comapare {string} and {string}")
	public void comapare_data(String detailsInput, String dimentionInput) throws Exception {
		Thread.sleep(1000);
		String[] detailsInputArray = detailsInput.split("~");
		String[] dimentionInputArray = dimentionInput.split("~");
		try {
			if (detailsInputArray.length == detailsData.getDataList().size()) {
				for (int i = 0; i < detailsInputArray.length; i++) {
					if (!detailsInputArray[i].trim().equals(detailsData.getDataList().get(i))) {
						String error = "@@ Test case failed : Details not matching, Required : "
								+ detailsInputArray[i].trim() + "; Found : " + detailsData.getDataList().get(i);
						System.out.println("Error in Details : " + error);
						throw new Exception(error);
					}
				}
			} else {
				String error = "@@ Test case failed : Details SIZE not matching, Required : " + detailsInputArray.length
						+ "; Found : " + detailsData.getDataList().size();
				System.out.println(error);
				throw new Exception(error);
			}

			if (dimentionInputArray.length == dimentionData.getDataList().size()) {
				for (int i = 0; i < dimentionInputArray.length; i++) {
					if (!dimentionInputArray[i].trim().equals(dimentionData.getDataList().get(i))) {
						String error = "@@ Test case failed : Dimentions not matching, Required : "
								+ dimentionInputArray[i].trim() + "; Found : " + dimentionData.getDataList().get(i);
						System.out.println("Error in Dimentions : " + error);
						throw new Exception(error);
					}
				}
			} else {
				String error = "@@ Test case failed : Details SIZE not matching, Required : "
						+ dimentionInputArray.length + "; Found : " + dimentionData.getDataList().size();
				System.out.println(error);
				throw new Exception(error);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			driver.quit();
		}
	}
}
