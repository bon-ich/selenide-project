import PageElements.Header;
import PageObjects.HomePage;
import PageObjects.SearchResultsPage;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.switchTo;

public class SearchTest {
    private HomePage homePage = new HomePage();
    private Header header = new Header();

    @BeforeTest
    public void beforeTest() {
        homePage.openHomePage();
        header.runSearch("");
    }

    @Test
    public void searchResultsContainSearchQuery() {
        String query = "backpack";
        SearchResultsPage searchResultsPage = header.runSearch(query);
        var items = searchResultsPage.getResultItemsTitles();
        items.forEach(i -> Assert.assertTrue(i.toLowerCase(Locale.ROOT).contains(query.toLowerCase())));
    }

    @Test
    public void searchWithBadQueryDoesntGiveResults() {
        String query = RandomStringUtils.randomAlphanumeric(15);
        SearchResultsPage searchResultsPage = header.runSearch(query);
        var items = searchResultsPage.getResultItems();
        Assert.assertEquals(items.size(), 0);
    }

    @Test
    public void properSearchResultItemOpensInNewTab() {
        String query = "backpack";
        SearchResultsPage searchResultsPage = header.runSearch(query);
        var items = searchResultsPage.getResultItems();
        for (SelenideElement item : items) {
            String itemTitle = searchResultsPage.getItemTitle(item);
            item.click();
            switchTo().window(1);
            closeWindow();
            switchTo().window(0);
        }
    }
}
