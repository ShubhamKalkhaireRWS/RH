package pages;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;

public class MORETTIMARBLEROUNDVASE {
    WebDriver driver;

    By product_Name = By.xpath("//h1[contains(text(),'17th C. Round Sunburst Mirror')]");
    By long_description = By.cssSelector("#long_description");
    By details = By.xpath("//body/div[@id='spa-root']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]/div[1]/section[1]/ul[1]");
    By detailsPlusBtn = By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root'])[2]");
    By dimensions = By.xpath("//body/div[@id='spa-root']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[3]/div[2]/div[1]/div[1]/section[1]/ul[1]");
    By dimensionsPlusBtn = By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root'])[3]");
    By finishes = By.xpath("//*[@id=\"component-swatch-groups\"]/div/div");
    public MORETTIMARBLEROUNDVASE(WebDriver driver) {
        this.driver = driver;
    }
 // Expected texts
    String expectedLongDescription = "Unobstructed geometry and the organic purity of fine white marble merge to create an understated accent.";
    String expectedDetails = "Made of solid, white marble polished to a satin finish\n"
            + "Natural veining is unique to each piece\n"
            + "For decorative use only; not food safe";
    String expectedDimensions = "10\" diam., 11\"H\nWeight: 38 lbs.";

    public void get_Text() {
        // Find the elements using their respective XPaths
    	//  WebElement productNameElement = driver.findElement(product_Name);
        WebElement longDescriptionElement = driver.findElement(long_description);
        WebElement detailsPlusBtnElement = driver.findElement(detailsPlusBtn);
        WebElement dimensionsPlusBtnElement = driver.findElement(dimensionsPlusBtn);
       

        // Click on the buttons to expand details and dimensions
        detailsPlusBtnElement.click();
        dimensionsPlusBtnElement.click();

        // Wait for some time to ensure that the content gets loaded
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find the elements after clicking the buttons
        WebElement detailsElement = driver.findElement(details);
        WebElement dimensionsElement = driver.findElement(dimensions);

        // Get text from the elements
//        String productNameText = productNameElement.getText();
        String longDescriptionText = longDescriptionElement.getText();
        String detailsText = detailsElement.getText();
        String dimensionsText = dimensionsElement.getText();

        // Print or use the obtained text as needed
//        System.out.println("Product Name: " + productNameText);
        System.out.println("Long Description: " + longDescriptionText);
        System.out.println("Details: " + detailsText);
        System.out.println("Dimensions: " + dimensionsText);
        
     // Compare the texts with expected values
        if (longDescriptionText.equals(expectedLongDescription)) {
            System.out.println("Long Description matches the expected value.");
        } else {
            System.out.println("Long Description does not match the expected value.");
        }

        if (detailsText.equals(expectedDetails)) {
            System.out.println("Details match the expected value.");
        } else {
            System.out.println("Details do not match the expected value.");
        }

        if (dimensionsText.equals(expectedDimensions)) {
            System.out.println("Dimensions match the expected value.");
        } else {
            System.out.println("Dimensions do not match the expected value.");
        }
        
        get_AllText();
        
    }
    public void get_AllText() {
        // Find the root element that contains all the text you want to retrieve
        WebElement rootElement = driver.findElement(By.tagName("body"));

        // Get all text from the root element and its descendants
        String allText = rootElement.getText();

        // Exclude specific text
        allText = allText.replace("HideCreated with Sketch.", "");

        // Print or use the obtained text as needed
        System.out.println("All Text on the Webpage: " + allText);
     // Save the obtained text to a file
        saveTextToFile("target/text.txt", allText);
    }
    
    private void saveTextToFile(String filePath, String text) {
        try {
            // Create a FileWriter with the specified file path
            FileWriter fileWriter = new FileWriter(new File(filePath));

            // Write the text to the file
            fileWriter.write(text);

            // Close the FileWriter to release resources
            fileWriter.close();

            System.out.println("Text saved to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}


