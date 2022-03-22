import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class FirstATest
{
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformVersion","8.0.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","K:/!Arduino/Lessons/AutoTest/J_Appium_A/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

//    @After
//    public void tearDown() {driver.quit();}

    @Test
    public void secondTest()
    {
        //Нажать кнопку ПРОПУСТИТЬ после входа в app
        Click(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "Cannot click",
                3
        );

        //Перейти на строку поиск
        Click(
                By.xpath("//*[contains(@text, 'Поиск по Википедии')]"),
                "Cannot click",
                3
        );

        //Поиск первой статьи--------------
        //Ввести значение в строке поиска
        SendKeys(
                By.xpath("//*[contains(@text, 'Поиск по Википедии')]"),
                "Metallica",
                "Error Send JAVA",
                3
        );

        //Перейти в статью
        Click(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Metallica']"),
                "Cannot click",
                10
        );

        Assert_withOutTimeout(
                By.xpath("//android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView"),
                "Metallica",
                "So little time to load the page",
                0
        );
    }

    @Test
    public void firstTest()
    {
//        System.out.println("First test run");

        //Нажать кнопку ПРОПУСТИТЬ после входа в app
        Click(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "Cannot click",
                3
        );

        //Перейти на строку поиск
        Click(
                By.xpath("//*[contains(@text, 'Поиск по Википедии')]"),
                "Cannot click",
                3
        );

        //Поиск первой статьи--------------
        //Ввести значение в строке поиска
        SendKeys(
                By.xpath("//*[contains(@text, 'Поиск по Википедии')]"),
                "Java",
                "Error Send JAVA",
                3
        );

        //Перейти в статью
        Click(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Java']"),
                "Cannot click",
                10
        );

        //Сохранить статью в ИЗБРАННОЕ
        Click(
                By.xpath("//*[contains(@text, 'Сохранить')]"),
                "Ошибка сохранение в избранное",
                3
        );

        //Возврат к поиску
        Click_AccessibilityId(
                "Перейти вверх",
                "Ошибка возврата",
                3
        );

        //Очистить строку поиска
        Click_AccessibilityId(
                "Удалить запрос",
                "Ошибка возврата",
                3
        );

        //Поиск второй статьи--------------
        //Ввести значение в строке поиска
        SendKeys(
                By.xpath("//*[contains(@text, 'Поиск по Википедии')]"),
                "Metallica",
                "Error Send JAVA",
                5
        );

        //Перейти в статью
        Click(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Metallica']"),
                "Cannot click",
                10
        );

        //Сохранить статью в ИЗБРАННОЕ
        Click(
                By.xpath("//*[contains(@text, 'Сохранить')]"),
                "Ошибка сохранение в избранное",
                3
        );

        //Возврат к поиску
        Click_AccessibilityId(
                "Перейти вверх",
                "Ошибка возврата - 1",
                3
        );

        //Возврат на начальный экран
        Click(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_toolbar']//android.widget.ImageButton"),
                "Ошибка возврата - 2",
                3
        );

        //Вход в избранное
        Click_AccessibilityId(
                "Сохранено",
                "Ошибка входа в избранное",
                3
        );

        //Закрыть всплывающее окно
        Click(
                By.id("org.wikipedia:id/negativeButton"),
                "Ошибка закрытия всплывающего окна",
                3
        );

        //Переход в избранную папку
        Click(
                By.id("org.wikipedia:id/item_title"),
                "Ошибка перехода в избранную папку",
                3
        );

        //Принудительный таймаут, т.к. неуспевает прогрузиться окно
        try
        {
            TT();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        //Переход в удаляемую статью
        Click(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Ошибка перехода в удаляемую статью",
                3
        );

        //Меню избранного
        Click(
                By.xpath("//*[contains(@text, 'Сохранить')]"),
                "Ошибка меню избранного",
                3
        );

        //Удаление сохраненного
        Click(
                By.xpath("//*[contains(@text, 'Удалить из Сохранённое')]"),
                "Ошибка удаления статьи",
                3
        );

        //Возврат списку сохраненных статей
        Click_AccessibilityId(
                "Перейти вверх",
                "Ошибка возврата - 3",
                3
        );

        //Переход в удаляемую статью
        Click(
                By.xpath("//*[contains(@text, 'Metallica')]"),
                "Переход в статью Metallica",
                10
        );

        //Проверка значений
        Assert(
                By.xpath("//android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView"),
                "Metallica",
                "Not True Content",
                5
        );

        //Удаление искомого слова из строки поиска
//        Click(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "Cannot click",
//                5
//        );
    }
//---------------------------Func----------------------------------
    private WebElement fTimeout(By by, String error_m, long timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(error_m + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement fTimeout(By by, String error_m)
    {
        return fTimeout(by, error_m, 5);
    }

    private WebElement Click(By by, String error_m, long timeout)
    {
        WebElement element = fTimeout(by, error_m, timeout);
        element.click();
        return element;
    }

    private WebElement Click_AccessibilityId(String aid, String error_m, long timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(error_m + "\n");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(aid)));
        WebElement element = driver.findElementByAccessibilityId(aid);
        element.click();
        return element;
    }

    private WebElement SendKeys(By by, String value, String error_m, long timeout)
    {
        WebElement element = fTimeout(by, error_m, timeout);
        element.sendKeys(value);
        return element;
    }

    //Функция для отладки локаторов
//    private WebElement FindElement(By by, String value, String error_m, long timeout)
//    {
//        WebElement element = fTimeout(by, error_m, timeout);
//        System.out.println(element);
//        System.out.println(element.getAttribute("enabled"));
//        System.out.println(element.getAttribute("contentDescription"));
//        return element;
//    }

    private void TT() throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(2);
    }

    private WebElement Assert(By by, String value, String error_m, long timeout)
    {
        WebElement element = fTimeout(by, error_m, timeout);
        String compare_value = element.getAttribute("contentDescription");

        //Проверка в тексте по слову
//        final String phrase = compare_value;
//        final String findWord = value;
//        if (phrase.matches(".*\\b" + findWord + ".*\\b"))
//            System.out.println("Match");
//        else
//        System.out.println(compare_value);
        Assert.assertEquals(
                "Not True Content",
                value,
                compare_value
        );
        return element;
    }

    private WebElement Assert_withOutTimeout(By by, String value, String error_m, long timeout)
    {
        WebElement element = fTimeout(by, error_m, timeout);
        String compare_value = element.getAttribute("contentDescription");

        //Проверка в тексте по слову
//        final String phrase = compare_value;
//        final String findWord = value;
//        if (phrase.matches(".*\\b" + findWord + ".*\\b"))
//            System.out.println("Match");
//        else
//        System.out.println(compare_value);
        Assert.assertEquals(
                "Not True Content",
                value,
                compare_value
        );
        return element;
    }

}
