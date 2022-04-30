package Libs.UI;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjects extends MainPageObjects
{
    private static final String
        CLOSE_START_MENU = "id:org.wikipedia:id/fragment_onboarding_skip_button",
        SEARCH_INIT_ELEMENT_TPL = "xpath://*[contains(@text, '{VALUE}')]",
        SEARCH_INPUT = "id:org.wikipedia:id/search_src_text",
        ENTER_TO_ARTICLE_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{SUBSTRING}']",
        NAVIGATE_UP = "Navigate up",
        CLEAR_QUERY = "Clear query",
        FAVORITE = "Saved",
        ENTER_TO_FAVORITE_FOLDER = "id:org.wikipedia:id/item_title",
        BACK_TO_MAIN_PAGE = "xpath://*[@resource-id='org.wikipedia:id/search_toolbar']//android.widget.ImageButton",
        CLOSE_WINDOW = "id:org.wikipedia:id/negativeButton",
        PAGE_LIST_ITEM_TITLE = "id:org.wikipedia:id/page_list_item_title",
        DEBUG_ELEMENT = "xpath://android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView",
        SEARCH_TITLE_DESC_TPL = "xpath://androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]//*[@resource-id='org.wikipedia:id/page_list_item_{TEST}']",
        COUNTS = "xpath://androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup//*[@resource-id='org.wikipedia:id/page_list_item_title']";

    public SearchPageObjects(RemoteWebDriver driver)
    {
        super(driver);
    }

    /*  TEMPLATE METHODS    */
    @Step("Использование теплейта ENTER_TO_ARTICLE_BY_SUBSTRING_TPL")
    private static String getResultSearchElement(String substring)
    {
        return ENTER_TO_ARTICLE_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    @Step("Использование теплейта SEARCH_INIT_ELEMENT_TPL")
    private static String getContainsElement(String search_word)
    {
        return SEARCH_INIT_ELEMENT_TPL.replace("{VALUE}", search_word);
    }

    @Step("Использование теплейта SEARCH_TITLE_DESC_TPL")
    private static String getTest(String search_word)
    {
        return SEARCH_TITLE_DESC_TPL.replace("{TEST}", search_word);
    }
    /*  TEMPLATE METHODS    */

    @Step("Закрытие меню приветствия")
    public void closeMenu()
    {
        this.WaitElement(CLOSE_START_MENU, "Cant find element");
        this.Click(CLOSE_START_MENU, "Cannot find and click search init element", 5);
    }

    public void initSearchLine(String search_word)
    {
        String search_result_xpath = getContainsElement(search_word);
        this.WaitElement(search_result_xpath, "Cant find element");
        this.Click(search_result_xpath, "Cannot find and click search init element", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.SendKeys(SEARCH_INPUT, search_line, "Cant type element", 5);
    }

    public void enterArticle(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.Click(search_result_xpath, "Cant enter element" + substring, 5);
    }

    public String debugElement_Test(String search_line)
    {
        this.DebugElement_Func(DEBUG_ELEMENT, search_line, "Cant debug element", 15);
        return search_line;
    }

    public void saveArticleToFavorite_Func(String search_word)
    {
        String search_result_xpath = getContainsElement(search_word);
        this.Click(search_result_xpath, "Cant save to favorite", 5);
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
        this.Click(BACK_TO_MAIN_PAGE, "Cant return to main page", 5);
    }

    public void enterToFavorite_Func()
    {
        this.Click_AccessibilityId(FAVORITE, "Cant return to main page", 5);
    }

    public void closeWindow_Func()
    {
        this.Click(CLOSE_WINDOW, "Cant close window", 5);
    }

    public void enterToFavoriteFolder_Func()
    {
        this.Click(ENTER_TO_FAVORITE_FOLDER, "Cant return to main page", 5);
    }

    public void listItemTitle_Func()
    {
        try {MainPageObjects.TT();}                                             //Принудительный таймаут
        catch (InterruptedException e) {e.printStackTrace();}

        this.Click(PAGE_LIST_ITEM_TITLE, "Cant enter to deleted page", 5);
    }

    public void saveToDelete_Func(String search_word)
    {
        String search_result_xpath = getContainsElement(search_word);
        this.Click(search_result_xpath, "Cant enter to deleted page", 5);
    }

    public void removeFromSaved_Func(String search_word)
    {
        String search_result_xpath = getContainsElement(search_word);
        this.Click(search_result_xpath, "Cant enter to deleted page", 5);
    }

    public void searchMetallica_Func(String search_word)
    {
        String search_result_xpath = getContainsElement(search_word);
        this.Click(search_result_xpath, "Cant enter to deleted page", 15);
    }

    public String metallicaElement_Func(String search_line)
    {
        this.AssertElements(DEBUG_ELEMENT, search_line, "Cant enter to deleted page", 15);
        return search_line;
    }

    public String[] debug_Test(String title, String desc)
    {
        String title_from_el = getTest(title);
        String desc_from_el = getTest(desc);
        String val1 = this.DebugTest_Func(title_from_el,"Val1", 15);
        System.out.println(val1);
        String val2 = this.DebugTest_Func(desc_from_el,"Val2", 15);
        System.out.println(val2);
        return new String[] {val1, val2};
    }

    @Step("Отображение резкльтата поиска")
    public int debugTestCount()
    {
        return this.debugTestCount_Func(COUNTS, "Cant enter to deleted page", 15);
    }

}
