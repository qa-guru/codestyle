import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultsPage {
    SelenideElement searchBlock = $("#search");

    void checkSearchResults(String text) {
        $$("#rso .g").shouldHave(sizeGreaterThanOrEqual(1));
        searchBlock.shouldHave(text(text));
    }

    void checkNoSearchResults() {
        searchBlock.shouldNotBe(visible);
    }
}
