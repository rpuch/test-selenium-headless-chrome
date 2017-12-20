package com.rpuch.test.headless;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author rpuch
 */
public class Main {
    public static void main(String[] args) throws Exception {
        RemoteWebDriver driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
        try {
            driver.navigate().to("https://example.com/");
            File file = driver.getScreenshotAs(OutputType.FILE);
            Files.copy(file.toPath(), Paths.get("/tmp/screenshot.png"), StandardCopyOption.REPLACE_EXISTING);

            // adding a delay to visually check whether there is a browser window
            Thread.sleep(1000);
        } finally {
            driver.close();
        }
    }
}
