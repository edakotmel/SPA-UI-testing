package SPA;

import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;


public class ExistingUser {


    @Before
    public void UserLogin() {

        open("https://profiles-single-page-application.mwwnxtpreprod.monster-next.com/");

        //go to login page
        $(By.id("account-dropdown")).click();
        $(By.cssSelector("#account-dropdown > ul > li:nth-child(1) > a > span > div > div")).click();

        //login
        sleep(2000);
        $(By.xpath("//input[contains(@id,'email')]")).sendKeys("eduard.kotmel@monster.com");
        $(By.xpath("//input[contains(@id,'password')]")).sendKeys("HovnocuC123");
        $(By.xpath("//span[@class='btn-content'][contains(.,'Continue with Email')]")).click();
        sleep(1000);
    }
       /* //go to profile page
        $(By.xpath("//span[@id='account-user']")).click();
        $(By.xpath("//div[contains(@id,'account-dropdown-my-profile')]")).click();
        sleep(1000);*/

       @After
       public void UserLogout() {

        $(By.xpath("//span[@id='account-user']")).click();
        $(By.xpath("//div[@id='account-dropdown-logout']")).click();
        closeWebDriver();

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
            $(By.xpath("//div[@title='Michigan']")).click();
            $(By.xpath("//input[@name='city']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
            $(By.xpath("//input[@name='city']")).setValue("Miami");
            $(By.xpath("//div[@title='Miami Beach (Cheboygan County)']")).click();
            $(By.xpath("//input[@id='postalCode']")).setValue("10000");
            $(By.xpath("(//div[contains(.,'SAVE')])[23]")).click();

        }

        @Test
        public void UserEditWorkAuthorization() {
            $(By.xpath("//a[@id='profile-work-authorization-section-edit']")).click();
            $(By.xpath("(//span[contains(.,'Add Another')])[3]")).click();
            $(By.xpath("//select[@id='workAuthorizations[0][countryCode]']")).selectOptionContainingText("Czech Republic");
            $(By.xpath("(//div[contains(.,'SAVE')])[23]")).click();
            sleep(3000);
            $(By.xpath("//a[@id='profile-work-authorization-section-edit']")).click();
            $(By.xpath("//button[@id='profile-work-authorization-delete-0']")).click();
            $(By.xpath("(//div[contains(.,'SAVE')])[23]")).click();

    }
    @Test
    public void UserEditSummary() {
        $(By.xpath("//a[@id='profile-description-section-edit']")).click();
        $(By.xpath("//textarea[@id='description']")).setValue("Eduard Kotmel Summary test");
        $(By.xpath("(//div[contains(.,'SAVE')])[22]")).click();
        $(By.xpath("//a[@id='profile-description-section-edit']")).click();
        $(By.xpath("//textarea[@id='description']")).clear();
        $(By.xpath("(//div[contains(.,'SAVE')])[22]")).click();
    }
    @Test
    public void UserCreateWorkExperience() {
        //Creating new experience entry
        $(By.xpath("(//span[@class='btn-content'][contains(.,'ADD')])[3]")).click();
        $(By.xpath("//input[@name='company.name']")).setValue("Monster");
        sleep(1000);
        $(By.xpath("//div[@title='Monster Worldwide']")).click();
        $(By.xpath("//input[@name='jobTitle']")).setValue("Tester");
        $(By.xpath("//div[@title='Game Tester']")).click();
        $(By.xpath("//select[@name='company.location.countryCode']")).selectOptionContainingText("US");
        $(By.xpath("//input[@placeholder='State/province']")).sendKeys("michigan");
        $(By.xpath("//div[@title='Michigan']")).click();
        //$(By.xpath("//input[@name='city']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        $(By.xpath("//input[@id='company.location.city']")).setValue("Miami");
        $(By.xpath("//div[@title='Miami Beach (Cheboygan County)']")).click();
        $(By.xpath("//select[contains(@placeholder,'Job type')]")).selectOptionContainingText("Full Time");
        $(By.xpath("//select[contains(@id,'startMonth')]")).selectOptionContainingText("May");
        $(By.xpath("//select[@name='startYear']")).selectOptionContainingText("2010");
        $(By.xpath("//select[@id='endMonth']")).selectOptionContainingText("June");
        $(By.xpath("//select[@id='endYear']")).selectOptionContainingText("2015");
        $(By.xpath("//textarea[@id='summary']")).setValue("Eda Kotmel summary test");
        $(By.xpath("//button[@id='profile-experience-achievement-add']")).click();
        $(By.xpath("//input[@id='achievements[0]']")).setValue("EK achievment");
        sleep(3000);
        $(By.xpath("(//div[contains(.,'SAVE')])[21]")).click();
        sleep(3000);

        //Verifying the values
        $("#profile-experience-section-collapse > div.IC67WZBhkFFkq0qTL6gpO.KPe8xLEsv76QjiLDbIfd0 > div._1usGyBb1c5TBVbCyEtox8a").shouldHave(Condition.text("Game Tester"));
        $("#profile-experience-section-collapse > div.IC67WZBhkFFkq0qTL6gpO.KPe8xLEsv76QjiLDbIfd0 > div.F_kvPueIDSY6m6G5h0uM1").shouldHave(Condition.text("Monster Worldwide"));
        $("#profile-experience-section-collapse > div.IC67WZBhkFFkq0qTL6gpO.KPe8xLEsv76QjiLDbIfd0 > div:nth-child(5)").shouldHave(Condition.text("Miami Beach, US"));
        $("#profile-experience-section-collapse > div.IC67WZBhkFFkq0qTL6gpO.KPe8xLEsv76QjiLDbIfd0 > div:nth-child(6)").shouldHave(Condition.text("5/2010 - 6/2015 (5.2 years)"));
        $("#profile-experience-section-collapse > div.IC67WZBhkFFkq0qTL6gpO.KPe8xLEsv76QjiLDbIfd0 > div._2Ch80asm1l_FdgzsqQ6whA > pre").shouldHave(Condition.text("Eda Kotmel summary test"));
        $("#profile-experience-section-collapse > div.IC67WZBhkFFkq0qTL6gpO.KPe8xLEsv76QjiLDbIfd0 > ul > li").shouldHave(Condition.text("EK achievment"));
    }

        @Test
                public void UserEditexistingworkexperience(){
                //Editing existing entry
        $(By.xpath("//a[@id='profile-experience-0-edit']")).click();
        $(By.xpath("//input[@name='company.name']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $(By.xpath("//input[@name='company.name']")).sendKeys("Monster");
        sleep(1000);
        $(By.xpath("//div[@tabindex='2']")).click();
        $(By.xpath("//input[@name='jobTitle']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $(By.xpath("//input[@name='jobTitle']")).setValue("Tester");
        $(By.xpath("//div[contains(@title,'Electrical/Electronics Inspector/Tester')]")).click();
        $(By.xpath("//select[@name='company.location.countryCode']")).selectOptionContainingText("US");
        $(By.xpath("//input[@placeholder='State/province']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $(By.xpath("//input[@placeholder='State/province']")).sendKeys("Washi");
        $(By.xpath("//div[@title='Washington']")).click();
        $(By.xpath("//input[@id='company.location.city']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        //$(By.xpath("//input[@name='city']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        $(By.xpath("//input[@id='company.location.city']")).setValue("washi");
        $(By.xpath("//div[@title='Washington Harbor (Clallam County)']")).click();
        $(By.xpath("//select[contains(@placeholder,'Job type')]")).selectOptionContainingText("Part Time");
        $(By.xpath("//select[contains(@id,'startMonth')]")).selectOptionContainingText("June");
        $(By.xpath("//select[@name='startYear']")).selectOptionContainingText("2011");
        $(By.xpath("//select[@id='endMonth']")).selectOptionContainingText("July");
        $(By.xpath("//select[@id='endYear']")).selectOptionContainingText("2014");
        $(By.xpath("//textarea[@id='summary']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $(By.xpath("//textarea[@id='summary']")).setValue("Eda Kotmel summary test 2");
        $(By.xpath("//button[@id='profile-experience-achievement-add']")).click();
        $(By.xpath("//input[@id='achievements[1]']")).setValue("EK achievment 2");
        sleep(3000);
        $(By.xpath("(//div[contains(.,'SAVE')])[23]")).click();
        sleep(3000);

        //Verify changed values
        $("#profile-experience-section-collapse > div.IC67WZBhkFFkq0qTL6gpO.KPe8xLEsv76QjiLDbIfd0 > div._1usGyBb1c5TBVbCyEtox8a").shouldHave(Condition.text("Electrical/Electronics Inspector/Tester"));
        // $("#profile-experience-section-collapse > div.IC67WZBhkFFkq0qTL6gpO.KPe8xLEsv76QjiLDbIfd0 > div.F_kvPueIDSY6m6G5h0uM1").shouldHave(Condition.text("Monster"));
        $("#profile-experience-section-collapse > div.IC67WZBhkFFkq0qTL6gpO.KPe8xLEsv76QjiLDbIfd0 > div:nth-child(5)").shouldHave(Condition.text("Washington Harbor, US"));
        $("#profile-experience-section-collapse > div.IC67WZBhkFFkq0qTL6gpO.KPe8xLEsv76QjiLDbIfd0 > div:nth-child(6)").shouldHave(Condition.text("6/2011 - 7/2014 (3.2 years)"));
        $("#profile-experience-section-collapse > div.IC67WZBhkFFkq0qTL6gpO.KPe8xLEsv76QjiLDbIfd0 > div._2Ch80asm1l_FdgzsqQ6whA > pre").shouldHave(Condition.text("Eda Kotmel summary test 2"));
        $("#profile-experience-section-collapse > div.IC67WZBhkFFkq0qTL6gpO.KPe8xLEsv76QjiLDbIfd0 > ul > li:nth-child(2)").shouldHave(Condition.text("EK achievment 2"));
    }
       @Test
               public void UserDeleteWorkExerience(){
           //Deletint the work experience
        $("#profile-experience-0-edit").click();
        $(By.xpath("(//div[contains(.,'DELETE')])[23]")).click();
        $(By.xpath("(//span[contains(.,'Yes, delete this experience')])[2]")).click();

        //Verify that the work experience was deleted
        $("#profile-experience-section-collapse > div.IC67WZBhkFFkq0qTL6gpO.KPe8xLEsv76QjiLDbIfd0 > div._1usGyBb1c5TBVbCyEtox8a").shouldNotHave(Condition.text("Electrical/Electronics Inspector/Tester"));

    }
}
