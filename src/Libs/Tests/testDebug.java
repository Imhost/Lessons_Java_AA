package Libs.Tests;

import Libs.CoreTestCase;
import Libs.UI.SearchPageObjects;
import org.junit.Test;

public class testDebug extends CoreTestCase
{
    @Test
    public void testDebug_Element()
    {
        String search_line = "Metallica";

        SearchPageObjects SearchPageObjects = new SearchPageObjects(driver);

        SearchPageObjects.closeMenu();                                          //Нажать кнопку ПРОПУСТИТЬ после входа в app
        SearchPageObjects.initSearchLine();                                     //Перейти на строку поиск
        SearchPageObjects.typeSearchLine(search_line);                          //Ввести значение в строке поиска
        SearchPageObjects.enterArticle(search_line);                            //Перейти в статью
        String value = SearchPageObjects.debugElement_Test(search_line);        //Получение атрибутов элемента

        assertEquals(
                "Not True Content",
                search_line,
                value);
    }
}
