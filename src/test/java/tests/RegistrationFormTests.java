package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests {

    static File file;

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        file = new File("src/test/resources/hi.jpg");
    }

    @Test
    void registrationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Henri");
        $("#lastName").setValue("Chinaski");
        $("#userEmail").setValue("test@gmail.pu");
        $(".custom-radio", 0).click();
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
        $("#uploadPicture").uploadFile(file);
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(exactText("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                Condition.text("Student Name Henri Chinaski"),
                Condition.text("Student Email test@gmail.pu\n"),
                Condition.text("Gender Male"),
                Condition.text("Mobile 9998887776"),
                Condition.text("Date of Birth 10 October,1990"),
                Condition.text("Subjects Physics"),
                Condition.text("Hobbies Music"),
                Condition.text("Picture hi.jpg"),
                Condition.text("Address Bangkok"),
                Condition.text("State and City NCR Delhi")
        );
    }
}