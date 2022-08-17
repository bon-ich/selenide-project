package PageElements;

import PageObjects.SearchResultsPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Header {
    private final String SEARCH_INPUT_SELECTOR = "//input[@name='search_query']";

    public SearchResultsPage runSearch(String query) {
        $(By.xpath(SEARCH_INPUT_SELECTOR)).setValue(query).pressEnter();
        return new SearchResultsPage();
    }
}
