package homework3;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestingCases extends TestCases {
    //TC-1 Testing SearchBox Button
    @Test
    public void testSearchBox() throws InterruptedException {
        tc2_SearchBox();
        String expectedText= "\"coffee cups\"";
        String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(actualText, expectedText);

    }
    //TC-2 Testing language Button
    @Test
    public void testLanguageButton(){
        tc3_LanguageButton();
        String expectedText= "Language Settings";
        String actualText = driver.findElement(By.cssSelector("#lop-heading")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    //TC-3 Testing sing in Button
    @Test
    public void testSignInButton() throws InterruptedException {
        tc4_signInButton();
        String expectedText= "There was a problem";
        String actualText = driver.findElement(By.className("a-alert-heading")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    //TC-4 Testing homepage Title
    @Test
    public void testGetTitle(){
       tc5_getTitle();
        String homePageTitle= "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String title= driver.getTitle();
        Assert.assertEquals(homePageTitle,title);
    }

    //TC-5 Testing career Link
    @Test
    public void testCareerLink() {
        tc6_careerLink();
        String careerTitle= "Amazon.jobs: Help us build Earth’s most customer-centric company.";
        String jobsTitle= driver.getTitle();
        Assert.assertEquals(careerTitle,jobsTitle);

    }

}
