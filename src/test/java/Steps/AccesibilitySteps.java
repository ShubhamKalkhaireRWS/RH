package Steps;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.accessibility.Accessibility;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.cucumber.java.en.*;
import pages.Accesibility;
import pages.Contrast;
import pages.MORETTIMARBLEROUNDVASE;

public class AccesibilitySteps {
	WebDriver driver=null;

	@Given("Open Chrome Browser")
	public void open_Browser() {

		String projectPath=System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver","./src/test/resources/Drivers/chromedriver.exe");	
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	

	@When("Open Accessibility Link")
	public void open_accessibility_link() {
		driver.navigate().to("https://www.heart.org/");
	}

	@When("Get all accessibility data")
	public void get_all_accessibility_data() throws InterruptedException {
		Accesibility Accesibility = new Accesibility(driver); 		
		//Accesibility.getAllAltAttributes("target/alt");
		//		Accesibility.getAllIframeTitles("target/frames");
		//		Accesibility.getAllButtonTexts("target/btn");
		//	Accesibility.checkKeyboardFunctionality();
					Accesibility.characterKey();
		//		Accesibility.pageTitle();
		//	Accesibility.getPageLanguage();
		
	



		driver.quit();
	}


}
