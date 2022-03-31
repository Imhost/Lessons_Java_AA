package Libs.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObjects extends MainPageObjects
{
    private static final String
            CLOSE_START_MENU = "org.wikipedia:id/fragment_onboarding_skip_button",
            SEARCH_INIT_ELEMENT_TPL = "//*[contains(@text, '{VALUE}')]",
            SEARCH_INPUT = "org.wikipedia:id/search_src_text",
            ENTER_TO_ARTICLE_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{SUBSTRING}']",
            NAVIGATE_UP = "Navigate up",
            CLEAR_QUERY = "Clear query",
            FAVORITE = "Saved",
            ENTER_TO_FAVORITE_FOLDER = "org.wikipedia:id/item_title",
            BACK_TO_MAIN_PAGE = "//*[@resource-id='org.wikipedia:id/search_toolbar']//android.widget.ImageButton",
            CLOSE_WINDOW = "org.wikipedia:id/negativeButton",
            PAGE_LIST_ITEM_TITLE = "org.wikipedia:id/page_list_item_title",
            DEBUG_ELEMENT = "//android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView";

    public SearchPageObjects(AppiumDriver driver)
    {
        super(driver);
    }

    /*  TEMPLATE METHODS    */
    private static String getResultSearchElement(String substring)
    {
        return ENTER_TO_ARTICLE_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getContainsElement(String search_word)
    {
        return SEARCH_INIT_ELEMENT_TPL.replace("{VALUE}", search_word);
    }
    /*  TEMPLATE METHODS    */

    public void closeMenu()
    {
        this.WaitElement(By.id(CLOSE_START_MENU), "Cant find element");
        this.Click(By.id(CLOSE_START_MENU), "Cannot find and click search init element", 5);
    }

    public void initSearchLine(String search_word)
    {
        String search_result_xpath = getContainsElement(search_word);
        this.WaitElement(By.xpath(search_result_xpath), "Cant find element");
        this.Click(By.xpath(search_result_xpath), "Cannot find and click search init element", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.SendKeys(By.id(SEARCH_INPUT), search_line, "Cant type element", 5);
    }

    public void enterArticle(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.Click(By.xpath(search_result_xpath), "Cant enter element" + substring, 5);
    }

    public String debugElement_Test(String search_line)
    {
        this.DebugElement_Func(By.xpath(DEBUG_ELEMENT), search_line, "Cant debug element", 15);
        return search_line;
    }

    public void saveArticleToFavorite_Func(String search_word)
    {
        String search_result_xpath = getContainsElement(search_word);
        this.Click(By.xpath(search_result_xpath), "Cant save to favorite", 5);
    }

    public void navigateUp_Func()
    {
        this.Click_AccessibilityId(NAVIGATE_UP, "Cant click back button", 5);
    }

    public void clearQuery_Func()
    {
        this.Click_AccessibilityId(CLEAR_QUERY, "Cant clear search line", 5);
    }

    public void backToMainPage_Func()
    {
        this.Click(By.xpath(BACK_TO_MAIN_PAGE), "Cant return to main page", 5);
    }

    public void enterToFavorite_Func()
    {
        this.Click_AccessibilityId(FAVORITE, "Cant return to main page", 5);
    }

    public void closeWindow_Func()
    {
        this.Click(By.id(CLOSE_WINDOW), "Cant close window", 5);
    }

    public void enterToFavoriteFolder_Func()
    {
        this.Click(By.id(ENTER_TO_FAVORITE_FOLDER), "Cant return to main page", 5);
    }

    public void listItemTitle_Func()
    {
        try {MainPageObjects.TT();}                                             //Принудительный таймаут
        catch (InterruptedException e) {e.printStackTrace();}

        this.Click(By.id(PAGE_LIST_ITEM_TITLE), "Cant enter to deleted page", 5);
    }

    public void saveToDelete_Func(String search_word)
    {
        String search_result_xpath = getContainsElement(search_word);
        this.Click(By.xpath(search_result_xpath), "Cant enter to deleted page", 5);
    }

    public void removeFromSaved_Func(String search_word)
    {
        String search_result_xpath = getContainsElement(search_word);
        this.Click(By.xpath(search_result_xpath), "Cant enter to deleted page", 5);
    }

    public void searchMetallica_Func(String search_word)
    {
        String search_result_xpath = getContainsElement(search_word);
        this.Click(By.xpath(search_result_xpath), "Cant enter to deleted page", 15);
    }

    public String metallicaElement_Func(String search_line)
    {
        this.AssertElements(By.xpath(DEBUG_ELEMENT), search_line, "Cant enter to deleted page", 15);
        return search_line;
    }

}
