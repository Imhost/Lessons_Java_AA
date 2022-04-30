package Libs.Tests;

import Libs.CoreTestCase;
import Libs.UI.MobileWeb.MWSearchPageObjects;
import Libs.UI.SearchPageObjects;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for Debug")
public class testDebug extends CoreTestCase
{
//--
    @Test
    @Features(value = {@Feature(value="Screen"), @Feature(value="Article")})
    @DisplayName("Проверка удаления статьи")
    @Description("Описание теста которое должно быть тут")
    @Step ("Начало теста testDebug_Element")
    @Severity(value = SeverityLevel.NORMAL)
    public void testDebug_Element()
    {
        String search_word = "Search Wikipedia";
        String search_line = "Metallica";

        SearchPageObjects SearchPageObjects = new SearchPageObjects(driver);

        SearchPageObjects.closeMenu();                                          //Нажать кнопку ПРОПУСТИТЬ после входа в app
        SearchPageObjects.initSearchLine(search_word);                                     //Перейти на строку поиск
        SearchPageObjects.typeSearchLine(search_line);                          //Ввести значение в строке поиска
        SearchPageObjects.enterArticle(search_line);                            //Перейти в статью
        String value = SearchPageObjects.debugElement_Test(search_line);        //Получение атрибутов элемента

        Assert.assertEquals(
                "Not True Content",
                search_line,
                value);
    }

    @Test
    @Features(value = {@Feature(value="Screen"), @Feature(value="Article")})
    @DisplayName("Проверка удаления статьи")
    @Description("Описание теста которое должно быть тут")
    @Step ("Начало теста testMW_Search_Element")
    @Severity(value = SeverityLevel.NORMAL)
    public void testMW_Search_Element()
    {
        String search_line = "Java";
        String search_line2 = "Metallica";
        String substring = "Object-oriented programming language";
        String substring2 = "Band discography";
        String substring3 = "Metallica discography";
        String validate_title = "Java (programming language)";
        MWSearchPageObjects MWSearchPageObjects = new MWSearchPageObjects(driver);


        MWSearchPageObjects.initSearchLine();                                     //Перейти на строку поиск
        MWSearchPageObjects.typeSearchLine(search_line);                          //Ввести значение в строке поиска
        MWSearchPageObjects.enterArticle(substring);                            //Перейти в статью
        MWSearchPageObjects.saveArticleToFavorite_Func();                         //Сохранить статью в ИЗБРАННОЕ
        MWSearchPageObjects.initSearchLine();                                     //Перейти на строку поиск
        MWSearchPageObjects.typeSearchLine(search_line2);                          //Ввести значение в строке поиска
        MWSearchPageObjects.enterArticle(substring2);                            //Перейти в статью
        MWSearchPageObjects.saveArticleToFavorite_Func();                         //Сохранить статью в ИЗБРАННОЕ
        MWSearchPageObjects.enterToMain_Menu();                                     //Перейти в меню
        MWSearchPageObjects.enterToFavorite_Func();                               //Переход в избранное
        MWSearchPageObjects.deleteArticle(substring3);                            //Перейти в статью
        MWSearchPageObjects.enterToUnwatch_Func();                         //Удалить статью из ИЗБРАННОЕ
        MWSearchPageObjects.enterToMain_Menu();                                     //Перейти в меню
        MWSearchPageObjects.enterToFavorite_Func();                               //Переход в избранное
        MWSearchPageObjects.validation(validate_title);                               //Переход в избранное
        System.out.println("val");
    }

    @Test
    @Features(value = {@Feature(value="Screen"), @Feature(value="Article")})
    @DisplayName("Проверка найденых результатов > 3")
    @Description("Описание теста которое должно быть тут")
    @Step ("Начало теста MWCount_Element")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testMWCount_Element() {
        String search_word = "Search Wikipedia";
        String search_line = "Java";

        MWSearchPageObjects MWSearchPageObjects = new MWSearchPageObjects(driver);

        MWSearchPageObjects.initSearchLine();                                     //Перейти на строку поиск
        MWSearchPageObjects.typeSearchLine(search_line);                          //Ввести значение в строке поиска

        int count = MWSearchPageObjects.debugTestCount();

        Assert.assertTrue("Нашли менее трех "+ count, count > 3);

        //MWSearchPageObjects.takeScreenshot("elements_on_page");
    }
}
