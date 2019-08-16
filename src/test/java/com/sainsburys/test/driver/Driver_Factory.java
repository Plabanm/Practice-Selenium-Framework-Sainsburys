package com.sainsburys.test.driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver_Factory {

    private String browser = "chrome";
    public static WebDriver driver;

    public void runOnLocalHost(){
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

             default:
                 WebDriverManager.firefoxdriver().setup();
                 driver = new FirefoxDriver();
                 break;
        }

    }

    //Jenkins
    public void runOnRemoteHost() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.1.120:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public void goToUrl(String url){
        driver.get(url);
    }

    public void maxiBrowser(){
        driver.manage().window().maximize();

    }

    public void impWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void handleCookeis() {
        driver.findElement(By.cssSelector("#cookieContinue")).click();
    }

    public void closeBrowser(){
        driver.quit();

    }

    public Driver_Factory(){
        PageFactory.initElements(driver,this);
    }

    public void embedScreenShot(Scenario scenario){
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
        System.out.println("screen shot taken");

    }

    public WebElement waitUntilElementClickable(WebElement element) {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitUntilElementInvisible(By by) {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

}
