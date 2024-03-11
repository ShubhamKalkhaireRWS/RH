package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ANTIQUEDGLASSMOLDEDFLOORMIRROR {
    WebDriver driver;

    By product_Name = By.xpath("//h1[contains(text(),'17th C. Round Sunburst Mirror')]");
    By long_description = By.cssSelector("#long_description");
    By details = By.xpath("//body/div[@id='spa-root']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[2]/div[2]/div[1]/div[1]/section[1]/ul[1]");
    By detailsPlusBtn = By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root'])[2]");
    By dimensions = By.xpath("//body/div[@id='spa-root']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[3]/div[2]/div[1]/div[1]/section[1]/ul[1]");
    By dimensionsPlusBtn = By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root'])[3]");
    By finishes = By.xpath("//*[@id=\"component-swatch-groups\"]/div/div");
    public ANTIQUEDGLASSMOLDEDFLOORMIRROR(WebDriver driver) {
        this.driver = driver;
    }
 // Expected texts
    String expectedLongDescription = "With its profile of undulating curves, the bolection-molded frame is associated with Baroque art of 18th century Europe. Ours is set with antiqued mirror, accentuating the sculptural form. Joint lines between mirror elements create rhythm and pattern in the frame, bordering a central plate mirror.";
    String expectedDetails = "Frame is crafted of antiqued mirror and glass\n" +
            "Designed to lean against a wall; 107cm x 198cm and 61cm x 203cm mirrors may be mounted to wall vertically or horizontally with included hanging hardware\n" +
            "If using as a floor mirror, we encourage installation of the included tip restraint, which securely anchors the product to the wall. Items not properly anchored pose a potential safety risk.\n" +
            "Professional installation required for mirrors weighing more than 22.7 kg, and when mounting on a tile or stone surface. RH delivery service does not include installation.\n" +
            "Wipe with a soft, dry cloth; avoid the use of abrasive cleaning products";



    String expectedDimensions = "107cm W x 51mm D x 198cm H (mirror: 81cm W x 173cm H); 39 kg\n" +
            "61cm W x 51mm D x 203cm H (mirror: 36cm W x 178cm H); 23.1 kg\n" +
            "137cm W x 51mm D x 244cm H (mirror: 112cm W x 218cm H); 62.1 kg";



    public void get_Text() {
        // Find the elements using their respective XPaths
//        WebElement productNameElement = driver.findElement(product_Name);
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

//        // Print or use the obtained text as needed
////        System.out.println("Product Name: " + productNameText);
//        System.out.println("Long Description: " + longDescriptionText);
//        System.out.println("Details: " + detailsText);
//        System.out.println("Dimensions: " + dimensionsText);
//        
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
    }
}


