package com.automated.tests.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    public static void captureScreenshot(WebDriver driver, String testName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        DateFormat dfor = new SimpleDateFormat("yy/MM/dd_HH:mm:ss");
        Date obj = new Date();
        System.out.println(dfor.format(obj));
        
//        try {
//            // Save the screenshot with a unique name
//            org.apache.commons.io.FileUtils.copyFile(screenshotFile, new File("screenshots/" + obj + ".jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


}
