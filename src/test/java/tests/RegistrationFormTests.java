package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationFormTests {

    static File file;

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        file = new File("path/to/your/file.txt");
    }

    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }

    @Test
    void registrationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Henri");
        $("#lastName").setValue("Chinaski");
        $("#userEmail").setValue("test@gmail.pu");
        $(".custom-radio", 1).click();
        $("#userNumber").setValue("9998887776");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__day--010").click();
        $(".btn-primary").scrollTo();
        $("#hobbiesWrapper").$(".custom-control-label", 2).click();
        $("#subjectsInput").setValue("P");
        $(byText("Physics")).click();
        $("#currentAddress").setValue("Bangkok");
        $("#state").click();
        $("#state").$x(".//div[text()='NCR']").click();
        $("#city").click();
        $("#city").$x(".//div[text()='Delhi']").click();
        $("#uploadFile").uploadFile(file);


        //$("#subjectsWrapper").click();




        //$("#dateOfBirthInput").setValue("02 Nov 1993");











        $("[id=search]").shouldHave(text("https://selenide.org"));
    }
}
