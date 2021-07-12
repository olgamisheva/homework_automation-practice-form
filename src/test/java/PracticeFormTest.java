import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void  positiveFillTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("test@example.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9651435879");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__year-select").selectOptionByValue("1980");
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        File file = new File("src/test/resources/Picture.jpg");
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Lenina street 18");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").scrollTo().click();

        $(".modal-body").shouldHave(text("Ivan"));
        $(".modal-body").shouldHave(text("Ivanov"));
        $(".modal-body").shouldHave(text("test@example.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9651435879"));
        $(".modal-body").shouldHave(text("14 August,1980"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("Picture.jpg"));
        $(".modal-body").shouldHave(text("Lenina street 18"));
        $(".modal-body").shouldHave(text("NCR Delhi"));


    }

}


