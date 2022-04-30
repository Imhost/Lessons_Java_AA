package Libs.Tests;

import Libs.CoreTestCase;
import Libs.UI.MobileWeb.MWSearchPageObjects;
import Libs.UI.SearchPageObjects;
import org.junit.Test;

public class testDebug extends CoreTestCase
{
//--
    @Test
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

        assertEquals(
                "Not True Content",
                search_line,
                value);
    }

    @Test
    public void testMW_Search_Element()
    {
        String search_word = "Search Wikipedia";
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
    public void testMWCount_Element() {
        String search_word = "Search Wikipedia";
        String search_line = "Java";

        MWSearchPageObjects MWSearchPageObjects = new MWSearchPageObjects(driver);

        MWSearchPageObjects.initSearchLine();                                     //Перейти на строку поиск
        MWSearchPageObjects.typeSearchLine(search_line);                          //Ввести значение в строке поиска

        int count = MWSearchPageObjects.debugTestCount();

        assertTrue("Нашли менее трех "+ count, count > 3);
    }
}
