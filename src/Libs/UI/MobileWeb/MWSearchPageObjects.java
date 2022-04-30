package Libs.UI.MobileWeb;

import Libs.UI.MainPageObjects;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObjects extends MainPageObjects {
    private static final String
            SEARCH_INIT_ELEMENT = "css:button#searchIcon",
            SEARCH_INPUT = "css:form>input[type='search']",
            CANCEL_BUTTON = "css:div>button[type='button']",
            SEARCH_SUBSTRING_TPL = "xpath://div[contains(@class, 'wikidata-description')][contains(text(), '{SUBSTRING}')]",
            SEARCH_RESULT = "css:ul.page-list>li.page-summary",
            WATCH_SAVE = "css:li>a[title='Watch']",
            UNWATCH_SAVE = "css:li>a[title='Unwatch']",
            MAIN_MENU = "css:nav>label[title='Open main menu']",
            FAVORITE = "css:a[class='menu__item--watchlist']",
            DELETE_ARTICLE = "css:ul>li[title='{SUBSTRING}']",
            SECOND_VALIDATION = "a[href='/wiki/Java_(programming_language)']>h3",
            COUNTS = "xpath://androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup//*[@resource-id='org.wikipedia:id/page_list_item_title']",
            SEARCH_EMPTY = "css:p.without-results";

    public MWSearchPageObjects(RemoteWebDriver driver) {
        super(driver);
    }

    private static String getResultSearchElement(String substring)
    {
        return SEARCH_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchElement2(String substring)
    {
        return DELETE_ARTICLE.replace("{SUBSTRING}", substring);
    }

    public void initSearchLine()
    {
        this.WaitElement(SEARCH_INIT_ELEMENT, "Cant find element");
        this.Click(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
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

    public void saveArticleToFavorite_Func()
    {
        this.WaitElement(WATCH_SAVE, "Cant find element");
        this.Click(WATCH_SAVE, "Cant save to favorite", 5);
    }

    public void enterToMain_Menu()
    {
        this.WaitElement(MAIN_MENU, "Cant find element");
        this.Click(MAIN_MENU, "Cant return to main page", 5);
    }
    public void enterToFavorite_Func()
    {
        this.WaitElement(FAVORITE, "Cant find element");
        this.Click(FAVORITE, "Cant return to main page", 5);
    }

    public void deleteArticle(String substring)
    {
        String search_result_xpath = getResultSearchElement2(substring);
        this.Click(search_result_xpath, "Cant enter element" + substring, 5);
    }

    public void enterToUnwatch_Func()
    {
        this.WaitElement(UNWATCH_SAVE, "Cant find element");
        this.Click(UNWATCH_SAVE, "Cant return to main page", 5);
    }

    public String validation(String validate_title)
    {
        String search_result_xpath = getResultSearchElement2(validate_title);
        this.Click(search_result_xpath, "Cant enter element" + validate_title, 5);
        return (SECOND_VALIDATION);
    }

    @Step("Возврат результата подсчета")
    public int debugTestCount()
    {
        return this.debugMWTestCount_Func(COUNTS, "Cant enter to deleted page", 15);
    }
}