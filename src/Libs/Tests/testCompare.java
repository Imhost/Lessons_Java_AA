package Libs.Tests;

import Libs.CoreTestCase;
import Libs.UI.SearchPageObjects;
import org.junit.Test;

public class testCompare extends CoreTestCase
{
    @Test
    public void testCount_Element() {
        String search_word = "Search Wikipedia";
        String search_line = "Java";

        SearchPageObjects SearchPageObjects = new SearchPageObjects(driver);

        SearchPageObjects.closeMenu();                                          //Нажать кнопку ПРОПУСТИТЬ после входа в app
        SearchPageObjects.initSearchLine(search_word);                          //Перейти на строку поиск
        SearchPageObjects.typeSearchLine(search_line);                          //Ввести значение в строке поиска

        int count = SearchPageObjects.debugTestCount(search_line);

        assertTrue("Нашли менее трех "+ count, count > 3);
    }

    @Test
    public void testCompare_Element()
    {
        String search_word1 = "Search Wikipedia";
        String search_line1 = "Java";
        String title = "title";
        String desc = "description";

        SearchPageObjects SearchPageObjects = new SearchPageObjects(driver);

        SearchPageObjects.closeMenu();                                          //Нажать кнопку ПРОПУСТИТЬ после входа в app
        SearchPageObjects.initSearchLine(search_word1);                          //Перейти на строку поиск
        SearchPageObjects.typeSearchLine(search_line1);                          //Ввести значение в строке поиска

        String result[] = SearchPageObjects.debug_Test(title, desc);
        System.out.println(result[0] + result[1]);
        assertEquals(
                "Описание статьи "+ result[0] +" отличается от заголовка "+ result[1],
                result[0],
                result[1]);
    }
}
