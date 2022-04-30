package Libs.Tests;

import Libs.CoreTestCase;
import Libs.UI.SearchPageObjects;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for Compare")
public class testCompare extends CoreTestCase
{
    @Test
    @Features(value = {@Feature(value="Compare"), @Feature(value="Article")})
    @DisplayName("Проверка найденых результатов > 3")
    @Description("Описание теста которое должно быть тут")
    @Step("Начало теста testCount_Element")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testCount_Element() {
        String search_word = "Search Wikipedia";
        String search_line = "Java";

        SearchPageObjects SearchPageObjects = new SearchPageObjects(driver);

        SearchPageObjects.closeMenu();                                          //Нажать кнопку ПРОПУСТИТЬ после входа в app
        SearchPageObjects.initSearchLine(search_word);                          //Перейти на строку поиск
        SearchPageObjects.typeSearchLine(search_line);                          //Ввести значение в строке поиска

        int count = SearchPageObjects.debugTestCount();

        Assert.assertTrue("Нашли менее трех "+ count, count > 3);
    }

    @Test
    @Features(value = {@Feature(value="Compare"), @Feature(value="Article")})
    @DisplayName("Сравнение title и description")
    @Description("Описание теста которое должно быть тут")
    @Step("Начало теста testCompare_Element")
    @Severity(value = SeverityLevel.MINOR)
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
        Assert.assertEquals(
                "Описание статьи "+ result[0] +" отличается от заголовка "+ result[1],
                result[0],
                result[1]);
    }
}
