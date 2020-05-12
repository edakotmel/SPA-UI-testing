package SPA;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;


public class ExistingUser {

    @Test
    public void UserLogin() {

        open("https://profiles-single-page-application.mwwnxtpreprod.monster-next.com/");

        //go to login page
        $(By.id("account-dropdown")).click();
        $(By.cssSelector("#account-dropdown > ul > li:nth-child(1) > a > span > div > div")).click();

        //login
        sleep(2000);
        $(By.xpath("//input[contains(@id,'email')]")).sendKeys("eduard.kotmel@monster.com");
        $(By.xpath("//input[contains(@id,'password')]")).sendKeys("HovnocuC12345");
        $(By.xpath("//span[@class='btn-content'][contains(.,'Continue with Email')]")).click();

        //go to profile page
        $(By.xpath("//span[@class='label'][contains(.,'eda eda')]")).click();
        $(By.xpath("(//div[contains(.,'My Profile')])[9]")).click();
    }

    @Test
    public void UserEditContactInfo() {
        //setting a new contact info
        $(By.xpath("//a[@id='profile-contact-info-section-edit']")).click();
        $(By.xpath("//input[@id='userInfo.firstName']")).clear();
        $(By.xpath("//input[@id='userInfo.firstName']")).setValue("Eduard");
        $(By.xpath("//input[@id='userInfo.lastName']")).clear();
        $(By.xpath("//input[@id='userInfo.lastName']")).setValue("Kotmel");
        $(By.xpath("//input[@id='contactInfo.primaryPhoneNumber.phoneNumber']")).clear();
        $(By.xpath("//input[@id='contactInfo.primaryPhoneNumber.phoneNumber']")).setValue("777444555");
        $(By.xpath("//select[@id='contactInfo.primaryPhoneNumber.phoneTypeId']")).selectOptionContainingText("Work");
        $(By.xpath("(//div[contains(.,'SAVE')])[22]")).click();
        sleep(1000);
        //enterig the original contact info
        $(By.xpath("//a[@id='profile-contact-info-section-edit']")).click();
        $(By.xpath("//input[@id='userInfo.firstName']")).clear();
        $(By.xpath("//input[@id='userInfo.firstName']")).setValue("eda");
        $(By.xpath("//input[@id='userInfo.lastName']")).clear();
        $(By.xpath("//input[@id='userInfo.lastName']")).setValue("eda");
        $(By.xpath("//input[@id='contactInfo.primaryPhoneNumber.phoneNumber']")).clear();
        //sleep(2000);
        $(By.xpath("//input[@id='contactInfo.primaryPhoneNumber.phoneNumber']")).setValue("888444222");
        //sleep(2000);
        $(By.xpath("//select[@id='contactInfo.primaryPhoneNumber.phoneTypeId']")).selectOptionContainingText("Mobile");
        //sleep(2000);
        $(By.xpath("(//div[contains(.,'SAVE')])[23]")).click();
        //sleep(2000);

    }
    @Test
    public void UserEditLocationInfo() {
        //edit existing info
        $(By.xpath("//a[@id='profile-address-section-edit']")).click();
        $(By.xpath("//input[@id='addressLine1']")).clear();
        $(By.xpath("//input[@id='addressLine1']")).setValue("500 E 96th");
        $(By.xpath("//input[@id='addressLine2']")).clear();
        $(By.xpath("//input[@id='addressLine2']")).setValue("St # 200");
        $(By.xpath("//select[@id='countryCode']")).selectOption("US");
        $(By.xpath("//input[@placeholder='State/province']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        $(By.xpath("//input[@placeholder='State/province']")).sendKeys("michigan");
        //sleep(2000);
        $(By.xpath("//div[@title='Michigan']")).click();
        //sleep(2000);
        $(By.xpath("//input[@name='city']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        $(By.xpath("//input[@name='city']")).setValue("Michigan");
        $(By.xpath("//div[@title='Michigan Center (Jackson County)']")).click();
        //sleep(2000);
        //$(By.xpath("//input[@name='city']")).selectOptionContainingText("Michigan Center (Jackson County)");
        //sleep(200);
        $(By.xpath("//input[@id='postalCode']")).setValue("10000");
        $(By.xpath("(//div[contains(.,'SAVE')])[23]")).click();

    }
}
