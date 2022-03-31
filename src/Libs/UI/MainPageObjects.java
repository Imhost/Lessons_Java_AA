package Libs.UI;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPageObjects
{
    protected AppiumDriver driver;

    public MainPageObjects(AppiumDriver driver)
    {
        this.driver = driver;
    }

    public WebElement WaitElement(By by, String error_m, long timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(error_m + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement WaitElement(By by, String error_m)
    {
        return WaitElement(by, error_m, 15);
    }

    public WebElement Click(By by, String error_m, long timeout)
    {
        WebElement element = WaitElement(by, error_m, timeout);
        element.click();
        return element;
    }

    public WebElement Click_AccessibilityId(String aid, String error_m, long timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(error_m + "\n");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(aid)));
        WebElement element = driver.findElementByAccessibilityId(aid);
        element.click();
        return element;
    }

    public WebElement SendKeys(By by, String value, String error_m, long timeout)
    {
        WebElement element = WaitElement(by, error_m, timeout);
        element.sendKeys(value);
        return element;
    }

    //Функция для отладки локаторов
    public String DebugElement_Func(By by, String value, String error_m, long timeout)
    {
        WebElement element = WaitElement(by, error_m, timeout);
        System.out.println(element);
        System.out.println(element.getAttribute("enabled"));
        System.out.println(element.getAttribute("contentDescription"));
        System.out.println(element.getAttribute("text"));
        String compare_value = element.getAttribute("contentDescription");
        return compare_value;
    }

    public static void TT() throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(5);
    }

    public WebElement AssertElements(By by, String value, String error_m, long timeout)
    {
        WebElement element = WaitElement(by, error_m, timeout);
        String compare_value = element.getAttribute("contentDescription");

        //Проверка в тексте по слову
//        final String phrase = compare_value;
//        final String findWord = value;
//        if (phrase.matches(".*\\b" + findWord + ".*\\b"))
//            System.out.println("Match");
//        else
//        System.out.println(compare_value);
        //----------------------------
//        Assert.assertEquals(
//                "Not True Content",
//                value,
//                compare_value
//        );
        return element;
    }

    public WebElement Assert_withOutTimeout(By by, String value, String error_m, long timeout)
    {
        WebElement element = WaitElement(by, error_m, timeout);
        String compare_value = element.getAttribute("contentDescription");
        Assert.assertEquals(
                "Not True Content",
                value,
                compare_value
        );
        return element;
    }
}
