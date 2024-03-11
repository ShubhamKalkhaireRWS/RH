package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Accesibility {
	WebDriver driver;

	public Accesibility(WebDriver driver) {
		this.driver = driver;
	}

	public void getAllAltAttributes(String filePath) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
			// Find all img elements on the page
			List<WebElement> imgElements = driver.findElements(By.tagName("img"));

			// Iterate through img elements and capture alt attribute values
			for (WebElement imgElement : imgElements) {
				String altAttributeValue = imgElement.getAttribute("alt");
				writer.println("Img Element: " + imgElement);
				writer.println("   Alt Attribute Value: " + altAttributeValue);
				writer.println("----------------------------------------------");
			}

			// Find all map elements on the page
			List<WebElement> mapElements = driver.findElements(By.tagName("map"));

			// Iterate through map elements and capture alt attribute values
			for (WebElement mapElement : mapElements) {
				String altAttributeValue = mapElement.getAttribute("alt");
				writer.println("Map Element: " + mapElement);
				writer.println("   Alt Attribute Value: " + altAttributeValue);
				writer.println("----------------------------------------------");
			}

			// Find all logo elements on the page (you may need to adjust this based on the actual tag name)
			List<WebElement> logoElements = driver.findElements(By.tagName("logo"));

			// Iterate through logo elements and capture alt attribute values
			for (WebElement logoElement : logoElements) {
				String altAttributeValue = logoElement.getAttribute("alt");
				writer.println("Logo Element: " + logoElement);
				writer.println("   Alt Attribute Value: " + altAttributeValue);
				writer.println("----------------------------------------------");
			}

			System.out.println("Alt attribute values for img and map elements saved to: " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getAllIframeTitles(String filePath) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
			// Find all iframe elements on the page
			List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));

			// Iterate through iframe elements and capture title attribute values
			for (WebElement iframeElement : iframeElements) {
				String titleAttributeValue = iframeElement.getAttribute("title");
				writer.println("Iframe Element: " + iframeElement);
				writer.println("   Title Attribute Value: " + titleAttributeValue);
				writer.println("----------------------------------------------");
			}

			System.out.println("Title attribute values for iframe elements saved to: " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getAllButtonTexts(String filePath) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
			// Find all button elements on the page
			List<WebElement> buttonElements = driver.findElements(By.tagName("button"));

			// Iterate through button elements and capture visible text values
			for (WebElement buttonElement : buttonElements) {
				String buttonText = buttonElement.getText().trim();

				// Check if buttonText is not empty before printing
				if (!buttonText.isEmpty()) {
					writer.println("Button Element: " + buttonElement);
					writer.println("   Visible Text: " + buttonText);
					writer.println("----------------------------------------------");
				}
			}

			System.out.println("Visible text values for non-empty button elements saved to: " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void checkKeyboardFunctionality() throws InterruptedException {

		WebElement closeButton = driver.findElement(By.xpath("(//button[@class='close c-modal--promotion__close btn btn-dark'])[1]"));
		closeButton.click();
		// Initialize Actions


		Actions actions = new Actions(driver);

		// Perform a Tab key press
		actions.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000); // Adjust the sleep time based on your application's behavior


		int count = 0;

		while (true) {
			// Get the focused element
			WebElement focusedElement = driver.switchTo().activeElement();

			// Get the text attribute value
			String elementText = focusedElement.getAttribute("text");
			// Press Tab key
			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(1000); // Adjust the sleep time based on your application's behavior

			// Check if the text is "Blood Pressure Readings"
			if (" Blood Pressure Readings".equals(elementText)) {
				count++;

				// Break the loop on the second occurrence
				if (count == 2) {
					break;
				}
			}
		}
	}

	public void characterKey() throws InterruptedException {
		WebElement closeButton = driver.findElement(By.xpath("(//button[@class='close c-modal--promotion__close btn btn-dark'])[1]"));
		closeButton.click();
		// Locate a text field on the page
		WebElement searchBtn = driver.findElement(By.xpath("//img[@alt='site search']"));
		WebElement textField = driver.findElement(By.xpath("//input[@placeholder='ex: Heart Attack Symptoms']"));
		// Create Actions class instance
		Actions actions = new Actions(driver);
		searchBtn.click();
		Thread.sleep(2000);
		textField.click();       
		// Special characters with shifted keys
		String specialCharacters = "1234567890-=[];',./";

		// Type each special character
		for (char ch : specialCharacters.toCharArray()) {
			actions.keyDown(Keys.SHIFT).sendKeys(String.valueOf(ch)).keyUp(Keys.SHIFT);
			Thread.sleep(500);
		}
		// Perform the actions on the text field
		actions.build().perform();
		Thread.sleep(5000);
	}

	public void pageTitle() throws InterruptedException {

		String title= driver.getTitle();
		System.out.println("Title of Page is :"+title);

	}

	public void getPageLanguage() throws InterruptedException {

		// Sleep for a moment to allow the page to load (you might want to use WebDriverWait in a real scenario)
		Thread.sleep(2000);

		// Create a JavascriptExecutor instance
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Execute JavaScript to get the page language
		String pageLanguage = (String) jsExecutor.executeScript("return document.documentElement.lang");

		// Print the page language to the console
		System.out.println("Page Language: " + pageLanguage);


	}

	

}


