package homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {
    public WebDriver driver;
    public String chromeDriver = "webdriver.chrome.driver";
    public String chromeDriverPath = "/Users/ferhatbellache/Desktop/Driver//chromedriver";
    public String url = "https://www.amazon.com/";

    @BeforeMethod
    public void launchBrowser() throws InterruptedException {
        // System.setProperty("webdriver.chrome.driver","/Users/ferhatbellache/Desktop/Driver//chromedriver");
        System.setProperty(chromeDriver, chromeDriverPath);
        driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(2000);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
        driver.quit();
    }
    //TC-1 checking if we are getting the right Url
    @Test
    public void tc1_RightCurrentleUrl(){
        String CurrentUrl = driver.getCurrentUrl();
        String rightUrl = "https://www.amazon.com/";
        Assert.assertEquals(rightUrl,CurrentUrl);
    }

    //TC-2 SearchBox Button
    public void tc2_SearchBox() throws InterruptedException {

        WebElement searchBox=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchBox.sendKeys("Cofee cups");
        Thread.sleep(2000);
        WebElement clickSerach = driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
        clickSerach.click();
        Thread.sleep(2000);

    }

    // TC-2 language Button
    public void tc3_LanguageButton() {
        WebElement language =driver.findElement(By.cssSelector("#icp-nav-flyout > span > span.nav-line-2 > span"));
        language.click();
    }
    // TC-3 language Button
    public void tc4_signInButton() throws InterruptedException {
        WebElement signInButton =driver.findElement(By.cssSelector("#nav-link-accountList > div > span"));
        signInButton.click();
        Thread.sleep(1000);
        WebElement emailField = driver.findElement(By.cssSelector("#ap_email"));
        emailField.sendKeys("bellache@gmail.com");
        Thread.sleep(1000);
        WebElement continueButon = driver.findElement(By.className("a-button-input"));
        continueButon.click();
    }

// TC-4 get homepage Title
    public void tc5_getTitle() {
        // get the amazon homepage title
        String title = driver.getTitle();
    }

// TC-5 career link
    public void tc6_careerLink() {
    JavascriptExecutor js = (JavascriptExecutor)driver;
    //import java script executor and scroll down
    // scrollBy(x-axis, Y-axis) pixels.
    js.executeScript("scrollBy(0,9000)");
    driver.findElement(By.linkText("Careers")).click();
    }


}
