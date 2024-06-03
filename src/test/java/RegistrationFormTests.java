package src.test.java;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationFormTests {
    @Test
    void registrationFormTest() {
        
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Henry");
        $("#lastName").setValue("Chinaski");




        //$("[id=search]").shouldHave(text("https://selenide.org"));
    }
}
