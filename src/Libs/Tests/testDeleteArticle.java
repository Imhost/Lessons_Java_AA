package Libs.Tests;

import Libs.CoreTestCase;
import Libs.UI.SearchPageObjects;
import org.junit.Test;

public class testDeleteArticle extends CoreTestCase
{
    @Test
    public void testFirst()
    {
        String search_line_1= "Java";
        String search_line_2= "Metallica";

        SearchPageObjects SearchPageObjects = new SearchPageObjects(driver);

        SearchPageObjects.closeMenu();                                          //Нажать кнопку ПРОПУСТИТЬ после входа в app
        SearchPageObjects.initSearchLine();                                     //Перейти на строку поиск
        SearchPageObjects.typeSearchLine(search_line_1);                        //Ввести значение в строке поиска
        SearchPageObjects.enterArticle(search_line_1);                          //Перейти в статью
        SearchPageObjects.saveArticleToFavorite_Func();                         //Сохранить статью в ИЗБРАННОЕ
        SearchPageObjects.navigateUp_Func();                                    //Возврат назад
        SearchPageObjects.clearQuery_Func();                                    //Очистка строки поиска
        SearchPageObjects.typeSearchLine(search_line_2);                        //Ввести значение в строке поиска
        SearchPageObjects.enterArticle(search_line_2);                          //Перейти в статью
        SearchPageObjects.saveArticleToFavorite_Func();                         //Сохранить статью в ИЗБРАННОЕ
        SearchPageObjects.navigateUp_Func();                                    //Возврат назад
        SearchPageObjects.backToMainPage_Func();                                //Возврат главное меню
        SearchPageObjects.enterToFavorite_Func();                               //Переход в избранное
        SearchPageObjects.closeWindow_Func();                                   //Закрытие всплывающкго окна
        SearchPageObjects.enterToFavoriteFolder_Func();                         //Вход в список избранного
        SearchPageObjects.listItemTitle_Func();                                 //Переход в удаляемую статью
        SearchPageObjects.saveToDelete_Func();                                  //Меню избранного
        SearchPageObjects.removeFromSaved_Func();                               //Удаление статьи из избранного
        SearchPageObjects.navigateUp_Func();                                    //Возврат назад
        SearchPageObjects.searchMetallica_Func();                               //Переход в статью
        String value = SearchPageObjects.metallicaElement_Func(search_line_2);

        assertEquals(
                "Not True Content",
                value,
                search_line_2);

    }
}
