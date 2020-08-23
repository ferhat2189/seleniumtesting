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

import java.util.concurrent.TimeUnit;

public class TestCases {

    public WebDriver driver;
    public String chromeDriver = "webdriver.chrome.driver";
    public String chromeDriverPath = "/Users/ferhatbellache/Desktop/Driver//chromedriver";
    public String url = "https://www.amazon.com/";

    public String dealsInWholeFoordXpath = "//*[@id=\"nav-subnav\"]/a[3]/span";
    public String wholefoodsLinkXpth = "//*[@id=\"nav-xshop\"]/a[6]";
    public String selectAddressId = "glow-ingress-line2";
    public String zipCodeClassId = "GLUXZipUpdateInput";
    public String applyButton = "#GLUXZipUpdate > span > input";
    public String doneButtonCss = "#a-autoid-2-announce";

    public String shoppingCartXpath = "//*[@id=\"nav-cart\"]/span[3]";

    public String awsLinkXpath = "//*[@id=\"navFooter\"]/div[4]/table/tbody/tr[5]/td[1]/a";
    public String sellOnAmzLinkXpath = "//*[@id=\"navFooter\"]/div[4]/table/tbody/tr[3]/td[1]/a";

    public String selectContryLanguageXpath = "//*[@id=\"customer-preferences\"]/div/div/div/div[1]/div[2]/span/span/span/span/span";


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

    //TC-1 checking if we are getting the right Url
    @Test
    public void tc1_RightCurrentleUrl() {
        String CurrentUrl = driver.getCurrentUrl();
        String rightUrl = "https://www.amazon.com/";
        Assert.assertEquals(rightUrl, CurrentUrl);
    }

    //TC-2 SearchBox Button
    public void tc2_SearchBox() {

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchBox.sendKeys("Cofee cups");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement clickSerach = driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
        clickSerach.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }

    // TC-3 language Button
    public void tc3_LanguageButton() {
        WebElement language = driver.findElement(By.cssSelector("#icp-nav-flyout > span > span.nav-line-2 > span"));
        language.click();
    }

    // TC-4 the sign in button Button
    public void tc4_signInButton() {
        WebElement signInButton = driver.findElement(By.cssSelector("#nav-link-accountList > div > span"));
        signInButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement emailField = driver.findElement(By.cssSelector("#ap_email"));
        emailField.sendKeys("bellache@gmail.com");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement continueButon = driver.findElement(By.className("a-button-input"));
        continueButon.click();
    }

    // TC-5 get homepage Title
    public void tc5_getTitle() {
        // get the amazon homepage title
        String title = driver.getTitle();
    }

    // TC-6 career link
    public void tc6_careerLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // scrollBy(x-axis, Y-axis) pixels.
        js.executeScript("scrollBy(0,9000)");
        driver.findElement(By.linkText("Careers")).click();
    }

    // TC-7 cheching whole foods link
    public void tc7_wholeFoods() {
        driver.findElement(By.xpath(wholefoodsLinkXpth)).click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    //Test case failed testing for amazon deals inside whole foods link.
    public void tc8_DealsInsideWholefoodsLink() {
        driver.findElement(By.xpath(wholefoodsLinkXpth)).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath(dealsInWholeFoordXpath)).click();
    }

    // TC-9 Selecting and changing address zip code to 75741
    public void tc9_SelectYourAddress() {
        driver.findElement(By.id(selectAddressId)).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id(zipCodeClassId)).sendKeys("78741");
        driver.findElement(By.cssSelector(applyButton)).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(doneButtonCss)).click();
    }

    // Tc-10 checking shoping cart if it is empty
    public void tc10_ShoppingCartButton() {
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath(shoppingCartXpath)).click();
    }

    //TC-11 link for AWS services
    public void tc11_WebServicesLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,9000)");
        driver.findElement(By.xpath(awsLinkXpath)).click();
    }

    //TC-12 sell on Amazon link
    public void tc12_SellOnAmazonLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,9000)");
        driver.findElement(By.xpath(sellOnAmzLinkXpath)).click();
    }
// TC-13 checking the language button on the button of page if it comes up

    public void tc13_selectCountry() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"icp-touch-link-country\"]/span[2]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath(selectContryLanguageXpath)).click();
    }
    //TC_ continue with language and select Uk coutry and english;
@Test
    public void tc14_SelectUKOnLang() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,2000)");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"icp-touch-link-country\"]/span[2]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath(selectContryLanguageXpath)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"a-popover-header-1\"]/span")).click();
        Thread.sleep(4000);
    }
}