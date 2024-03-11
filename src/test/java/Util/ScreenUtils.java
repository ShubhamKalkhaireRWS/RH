package Util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenUtils {

	public static void captureScreenshot(WebDriver driver, String filePath) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(filePath);
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public static void captureScreenshotOfDevice(WebDriver driver, WebElement element, String filePath)
			throws Exception {

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullScreen = ImageIO.read(screenshot);

		Point location = element.getLocation();
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		System.out.println("Height : " + height + "; Width : " + width);

		BufferedImage logoImage = fullScreen.getSubimage(location.getX(), location.getY(), width, height);
		ImageIO.write(logoImage, "png", screenshot);

		FileUtils.copyFile(screenshot, new File(filePath));
	}

}
