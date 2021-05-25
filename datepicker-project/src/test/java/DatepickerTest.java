import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
public class DatepickerTest extends TestData {
    @BeforeAll
    public static void chkDate() throws TestUtils.InvalidDateException {
        TestUtils.isValidDate(dateOfBirth);
    }

    @Test
    void datepickerSelenideElementsCollectionTest() {
        open(URL);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text(dayOfBirth)).click();

/*        $(".modal-body tbody tr", 4)
                .shouldHave(text("Date of Birth"))
                .shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
*/
    }

    @Test
    void datepickerSelenideElementTest() {
        open(URL);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day[aria-label*='" + TestUtils.ordinalDayDateFormat(dateOfBirth) + "']").click();

/*        $(".modal-body tbody tr", 4)
                .shouldHave(text("Date of Birth"))
                .shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
*/
    }
}