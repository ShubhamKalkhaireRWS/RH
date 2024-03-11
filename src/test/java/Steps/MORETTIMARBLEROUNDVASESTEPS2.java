package Steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.MORETTIMARBLEROUNDVASE;

public class MORETTIMARBLEROUNDVASESTEPS2 {
	WebDriver driver=null;

	@Given("Open Browser in Chrome")
	public void open_Browser() {

		String projectPath=System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver","./src/test/resources/Drivers/chromedriver.exe");	
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();



	}

	@When("Open {string}")
	public void Open_Link(String link) {
		driver.navigate().to(link);
	}

	@When("Pull the text from locators2")
	public void pull_the_text_from_locators() {
		MORETTIMARBLEROUNDVASE sunburstMirror = new MORETTIMARBLEROUNDVASE(driver); 		
		sunburstMirror.get_Text();


		driver.quit();
	}


}
