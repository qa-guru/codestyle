import org.junit.jupiter.api.Test;
import utils.TestUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DatepickerTests {

    String URL = "https://demoqa.com/automation-practice-form",
            dayOfBirth = "29",
            monthOfBirth = "November",
            yearOfBirth = "1922";

    String dateOfBirth = monthOfBirth.concat(" ").concat(dayOfBirth).concat(", ").concat(yearOfBirth);

    @Test
    void datepickerSelenideElementsCollectionTest() {
        open(URL);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text(dayOfBirth)).click();

/*      Assertion:
        $(".modal-body tbody tr", 4)
                .shouldHave(text("Date of Birth"))
                .shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
 */
    }

    @Test
    void datepickerSelenideElementTest() {
        TestUtils.isValidDate(dateOfBirth);

        open(URL);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day[aria-label*='" + TestUtils.ordinalDayDateFormat(dateOfBirth) + "']").click();

/*      Assertion:
        $(".modal-body tbody tr", 4)
                .shouldHave(text("Date of Birth"))
                .shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
 */
    }
}