package Libs.Tests;

import Libs.CoreTestCase;
import Libs.UI.SearchPageObjects;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for delete")
public class testDeleteArticle extends CoreTestCase
{
    @Test
    @Features(value = {@Feature(value="Compare"), @Feature(value="Article")})
    @DisplayName("Удаление статей")
    @Description("Описание теста которое должно быть тут")
    @Step("Начало теста testFirst")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testFirst()
    {
        String search_word = "Search Wikipedia";
        String save_button = "Save";
        String remove_button = "Remove from Saved";
        String search_line_1= "Java";
        String search_line_2= "Metallica";

        SearchPageObjects SearchPageObjects = new SearchPageObjects(driver);

        SearchPageObjects.closeMenu();                                          //Нажать кнопку ПРОПУСТИТЬ после входа в app
        SearchPageObjects.initSearchLine(search_word);                                     //Перейти на строку поиск
        SearchPageObjects.typeSearchLine(search_line_1);                        //Ввести значение в строке поиска
        SearchPageObjects.enterArticle(search_line_1);                          //Перейти в статью
        SearchPageObjects.saveArticleToFavorite_Func(save_button);                         //Сохранить статью в ИЗБРАННОЕ
        SearchPageObjects.navigateUp_Func();                                    //Возврат назад
        SearchPageObjects.clearQuery_Func();                                    //Очистка строки поиска
        SearchPageObjects.typeSearchLine(search_line_2);                        //Ввести значение в строке поиска
        SearchPageObjects.enterArticle(search_line_2);                          //Перейти в статью
        SearchPageObjects.saveArticleToFavorite_Func(save_button);                         //Сохранить статью в ИЗБРАННОЕ
        SearchPageObjects.navigateUp_Func();                                    //Возврат назад
        SearchPageObjects.backToMainPage_Func();                                //Возврат главное меню
        SearchPageObjects.enterToFavorite_Func();                               //Переход в избранное
        SearchPageObjects.closeWindow_Func();                                   //Закрытие всплывающкго окна
        SearchPageObjects.enterToFavoriteFolder_Func();                         //Вход в список избранного
        SearchPageObjects.listItemTitle_Func();                                 //Переход в удаляемую статью
        SearchPageObjects.saveToDelete_Func(save_button);                                  //Меню избранного
        SearchPageObjects.removeFromSaved_Func(remove_button);                               //Удаление статьи из избранного
        SearchPageObjects.navigateUp_Func();                                    //Возврат назад
        SearchPageObjects.searchMetallica_Func(search_line_2);                               //Переход в статью
        String value = SearchPageObjects.metallicaElement_Func(search_line_2);

        Assert.assertEquals(
                "Not True Content",
                value,
                search_line_2);

    }
}
