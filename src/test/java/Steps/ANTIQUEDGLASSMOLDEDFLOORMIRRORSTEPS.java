package Steps;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.ANTIQUEDGLASSMOLDEDFLOORMIRROR;
import ru.yandex.qatools.ashot.*;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class ANTIQUEDGLASSMOLDEDFLOORMIRRORSTEPS {
	WebDriver driver=null;

	@Given("Open Browser1")
	public void open_Browser() {

		String projectPath=System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver","./src/test/resources/Drivers/chromedriver.exe");	
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();



	}

	@When("Open Link1")
	public void Open_Link() {
		driver.navigate().to("https://rh.com/de/de/catalog/product/product.jsp?productId=prod13100134&clientrender=true");
	}

	@When("Pull the text from locators1")
	public void pull_the_text_from_locators() {
		ANTIQUEDGLASSMOLDEDFLOORMIRROR sunburstMirror = new ANTIQUEDGLASSMOLDEDFLOORMIRROR(driver); 		
		sunburstMirror.get_Text();
		
		zoomOut(driver, 100);
		 // Execute JavaScript to scroll to the bottom and right edges of the page
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        jsExecutor.executeScript("window.scrollTo(document.body.scrollWidth, 0);");

        // Capture the full-page screenshot using AShot
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);

        // Save the screenshot to a file
        try {
            File screenshotFile = new File("target/screenshot.png");
            ImageIO.write(screenshot.getImage(), "PNG", screenshotFile);
            System.out.println("Screenshot saved to: " + screenshotFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		driver.quit();
	}

	 private static void zoomOut(WebDriver driver, int percentage) {
	        // Execute JavaScript to zoom out the webpage
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("document.body.style.zoom='" + percentage + "%'");
	    }
	
}
