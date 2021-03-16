import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.DateValidator;
import utils.StringFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DatepickerTests {

    static String URL = "https://demoqa.com/automation-practice-form",
            dayOfBirth = "29",
            monthOfBirth = "November",
            yearOfBirth = "1922";

    @BeforeAll
    public static void checkDate() {
        DateValidator validator = new DateValidator("MMM dd, yyyy");
        validator.isValid(monthOfBirth + " " + dayOfBirth + ", " + yearOfBirth);
    }

    String dateOfBirth = monthOfBirth.concat(" " + StringFormatter.numberToOrdinal(dayOfBirth)).concat(", " + yearOfBirth);

    @Test
    void datePickerSelenideElementTest() {
        open(URL);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day[aria-label*='" + dateOfBirth + "']").click();

//        $(".modal-body tbody tr", 4)
//                .shouldHave(text("Date of Birth"))
//                .shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
    }

    @Test
    void datePickerSelenideElementsCollectionTest() {
        open(URL);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text(dayOfBirth)).click();

//        $(".modal-body tbody tr", 4)
//                .shouldHave(text("Date of Birth"))
//                .shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
    }
}