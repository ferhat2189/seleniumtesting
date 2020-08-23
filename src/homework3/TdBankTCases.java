package homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TdBankTCases {
    public WebDriver driver;
    public String chromeDriver = "webdriver.chrome.driver";
    public String chromeDriverPath = "/Users/ferhatbellache/Desktop/Driver//chromedriver";
    public String url = "https://www.td.com/us/en/personal-banking/";

    public String searchXpath = "/html/body/div[3]/div[2]/header[1]/div[3]/div/div[2]/div/ul/li[3]/a/span[1]";

    @BeforeMethod
    public void launchBrowser() {
        // System.setProperty("webdriver.chrome.driver","/Users/ferhatbellache/Desktop/Driver//chromedriver");
        System.setProperty(chromeDriver, chromeDriverPath);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void closeBrowser() {
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
        driver.close();
        driver.quit();
    }

    //checking if we are getting the right Url
    @Test
    public void RightCurrentleUrl() {
        String CurrentUrl = driver.getCurrentUrl();
        String rightUrl = "https://www.td.com/us/en/personal-banking/";
        Assert.assertEquals(rightUrl, CurrentUrl);
    }

    public String smallBisinessXpath="/html/body/div[2]/div[2]/header[1]/div[2]/div/div[1]/div/ul/li[2]/a";
    public String hereToHelpSBCName ="td-banner-headline";

    // verification of Small business link
    @Test
    public void smallBusinessLink() {
        driver.findElement(By.xpath(smallBisinessXpath)).click();
      String actualText = driver.findElement(By.className(hereToHelpSBCName)).getText();
      String ExpectedText= "Business Customers";
      Assert.assertEquals(actualText,ExpectedText);
    }
    public String personalLinkXpath="/html/body/div[2]/div[2]/header[1]/div[2]/div/div[1]/div/ul/li[1]/a";

    //page source length
    @Test
    public void personalLink(){
        driver.findElement(By.xpath(personalLinkXpath)).click();
       long pageLength= (long)(driver.getPageSource().length());
       boolean actualLength = false;
       if ( pageLength > 109108){
           actualLength=true;
       }
       boolean expectedLength = true;
        Assert.assertEquals(expectedLength,actualLength);
    }

}
