package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Contrast {
    WebDriver driver;

    public Contrast(WebDriver driver) {
        this.driver = driver;
    }

    public void captureColorContrast(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Execute JavaScript to find all visible elements on the page
            List<WebElement> visibleElements = (List<WebElement>) ((JavascriptExecutor) driver)
                    .executeScript("return Array.from(document.querySelectorAll(':not([hidden])'))");

            // Iterate through visible elements and capture color and contrast information
            for (WebElement element : visibleElements) {
                String tagName = element.getTagName();
                String textContent = element.getText().trim();
                String color = getComputedStyle(element, "color");
                String backgroundColor = getComputedStyle(element, "background-color");

                writer.println("Element: " + tagName);
                writer.println("   Text Content: " + textContent);
                writer.println("   Color: " + color);
                writer.println("   Background Color: " + backgroundColor);
                writer.println("----------------------------------------------");
            }

            System.out.println("Color and contrast information for visible elements saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getComputedStyle(WebElement element, String property) {
        return (String) ((JavascriptExecutor) driver)
                .executeScript("return window.getComputedStyle(arguments[0]).getPropertyValue(arguments[1]);", element, property);
    }
}
