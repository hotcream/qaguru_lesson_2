package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;

public class HerokuAppTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void registrationFormTest() {
        open("/drag_and_drop");
        SelenideElement source = $("#column-a");
        SelenideElement target = $("#column-b");
        actions().clickAndHold(source)
                .moveToElement(target)
                .release()
                .build()
                .perform();
        source.shouldHave(text("B"));
        target.shouldHave(text("A"));
    }
}