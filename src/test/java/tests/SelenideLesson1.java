package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideLesson1 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void registrationFormTest() {
        open("");
        $(".search-input-container").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $$(".search-title").first().click();
        $("#wiki-tab").click();
        $$("#wiki-body").shouldHave(texts("Soft assertions"));
        $(byText("Soft assertions")).click();
        $$(".markdown-body").shouldHave(texts("JUnit5"));
    }
}