package PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    private final String SEARCH_RESULT_ITEMS = "//div[contains(@class, 'search-listings-group')]//ul[contains(@class, 'tab-reorder-container')]//li";
    private final String SEARCH_RESULT_ITEM_TITLES = "//div[contains(@class, 'search-listings-group')]//ul[contains(@class, 'tab-reorder-container')]//li//h3";

    public ElementsCollection getResultItems() {
        return $$(By.xpath(SEARCH_RESULT_ITEMS));
    }

    public List<String> getResultItemsTitles() {
        return $$(By.xpath(SEARCH_RESULT_ITEM_TITLES)).texts();
    }

    public String getItemTitle(SelenideElement item) {
        return item.find(By.xpath(".//h3")).text();
    }
}
