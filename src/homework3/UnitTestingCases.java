package homework3;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UnitTestingCases extends TestCases {
    //TC-2 Testing SearchBox Button
    @Test
    public void testSearchBox()  {
        tc2_SearchBox();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String expectedText= "\"coffee cups\"";
        String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(actualText, expectedText);

    }
    //TC-3 Testing language Button
    @Test
    public void testLanguageButton(){
        tc3_LanguageButton();
        String expectedText= "Language Settings";
        String actualText = driver.findElement(By.cssSelector("#lop-heading")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    //TC-4 Testing sing in Button for unregistered user in database
    @Test
    public void testSignInButton()  {
        tc4_signInButton();
        String expectedText= "There was a problem";
        String actualText = driver.findElement(By.className("a-alert-heading")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    //TC-5 Testing homepage Title
    @Test
    public void testGetTitle(){
       tc5_getTitle();
        String homePageTitle= "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String title= driver.getTitle();
        Assert.assertEquals(homePageTitle,title);
    }

    //TC-6 Testing career Link
    @Test
    public void testCareerLink() {
        tc6_careerLink();
        String careerTitle= "Amazon.jobs: Help us build Earth’s most customer-centric company.";
        String jobsTitle= driver.getTitle();
        Assert.assertEquals(careerTitle,jobsTitle);

    }
    //TC-7 Testing for whole foods link
    @Test
    public void testWholeFoods(){
        tc7_wholeFoods();
        String actualText = driver.getTitle();
        String expectedText= "Amazon.com: Whole Foods Market";
        Assert.assertEquals(actualText, expectedText);
    }
    //TC-8 failed for deals inside whole foods
    @Test
    public void testTc8_DealsInsideWholeFoodsLink() {
        tc8_DealsInsideWholefoodsLink();
        String ExpectedText= driver.findElement(By.linkText("Terms and conditions")).getText();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String ActualText = "See all terms and conditions ";
        Assert.assertEquals(ActualText,ExpectedText);
    }
    // Tc-9 Selecting and changing address zip code to 75741
    @Test
    public void testTc9_SelectYourAddress(){
        tc9_SelectYourAddress ();
        String Expectedtext =driver.findElement(By.cssSelector("#glow-ingress-line2")).getText();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String actualText = "Select your address";
        Assert.assertEquals(Expectedtext,actualText);
    }
    // Tc-10 checking shoping cart if it is empty
    @Test
    public void testTc10_ShoppingCartButton() {
        tc10_ShoppingCartButton();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String actualText= driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div[2]/div[1]/h2")).getText();
        String expectedText = "Your Amazon Cart is empty";
        Assert.assertEquals(expectedText,actualText);
    }
    //TC-11 link for AWS services
    @Test
    public void testTc11_WebServicesLink(){
        tc11_WebServicesLink();
        String  expectedUrl= "https://aws.amazon.com/what-is-cloud-computing/?sc_channel=EL&sc_campaign=amazonfooter";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    //TC-12 sell on Amazon link
    @Test
    public void testTc12_SellOnAmazonLink(){
        tc12_SellOnAmazonLink();
        String  expectedUrl= "https://sell.amazon.com/?ld=AZUSSOA-footer-aff&ref_=footer_sell";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    // TC-13 checking the language button on the button of page if it comes up
    @Test
    public void testTc13_selectCountry() {
        tc13_selectCountry();
        String  expectedtext= "Website (Country/Region)";
        String actualText = driver.findElement(By.xpath("//*[@id=\"a-popover-header-1\"]/span")).getText();
        Assert.assertEquals(expectedtext,actualText);
    }

}
