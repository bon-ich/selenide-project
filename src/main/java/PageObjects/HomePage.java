package PageObjects;

import PageElements.Header;

import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    private final String url = "https://www.etsy.com/";
    private final Header header = new Header();

    public void openHomePage() {
        open(url);
    }
}
