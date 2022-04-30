package Libs.UI;

import Libs.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class MainPageObjects
{
    protected RemoteWebDriver driver;

    public MainPageObjects(RemoteWebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement WaitElement(String locator, String error_m, long timeout)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(error_m + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement WaitElement(String locator, String error_m)
    {
        return WaitElement(locator, error_m, 15);
    }

    public WebElement Click(String locator, String error_m, long timeout)
    {
        WebElement element = WaitElement(locator, error_m, timeout);
        element.click();
        return element;
    }

    public WebElement Click_AccessibilityId(String aid, String error_m, long timeout)
    {
//        if (driver instanceof AppiumDriver)
//        {
//            WebDriverWait wait = new WebDriverWait((AppiumDriver) driver, timeout);
//            wait.withMessage(error_m + "\n");
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(aid)));
//            WebElement element = driver.findElementByAccessibilityId(aid);
//            element.click();
//            return element;
//        }
//        else {
            System.out.println("Method Click_AccessibilityId() does noting for platform" + Platform.getInstance().getPlatformVar());
//        }
        return null;
    }

    public WebElement SendKeys(String locator, String value, String error_m, long timeout)
    {
        WebElement element = WaitElement(locator, error_m, timeout);
        element.sendKeys(value);
        return element;
    }

    //Функция для отладки локаторов
    public WebElement DebugElement_Func(String locator, String value, String error_m, long timeout)
    {
        WebElement element = WaitElement(locator, error_m, timeout);
        System.out.println(element);
        System.out.println(element.getAttribute("enabled"));
        System.out.println(element.getAttribute("contentDescription"));
        System.out.println(element.getAttribute("text"));
        return element;
    }

    public WebElement tref_val(String locator, String value, String error_m, long timeout)
    {
        WebElement element = WaitElement(locator, error_m, timeout);
        System.out.println(element);
        System.out.println(element.getAttribute("tref"));
        return element;
    }

    public String DebugTest_Func(String locator, String error_m, long timeout)
    {
        WebElement element = WaitElement(locator, error_m, timeout);
        String compare_value = element.getAttribute("text");
        return compare_value;
    }

    public int debugTestCount_Func(String locator, String error_m, long timeout)
    {
        By by = this.getLocatorByString(locator);
        WebElement element = WaitElement(locator, error_m, timeout);
        List elements = driver.findElements(by);
//        System.out.println(elements);
        return elements.size();
    }

    @Step("Подсчет количества найденых элементов на странице")
    public int debugMWTestCount_Func(String locator, String error_m, long timeout)
    {
        By by = this.getLocatorByString(locator);
//        WebElement element = WaitElement(locator, error_m, timeout);
        List elements = driver.findElements(by.tagName("li"));
//        System.out.println(elements);
        screenshot(this.takeScreenshot("element_size"));
        int count = elements.size();
        return elements.size();
    }

    public static void TT() throws InterruptedException
    {
        TimeUnit.SECONDS.sleep(5);
    }

    public WebElement AssertElements(String locator, String value, String error_m, long timeout)
    {
        WebElement element = WaitElement(locator, error_m, timeout);
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

    public WebElement Assert_withOutTimeout(String locator, String value, String error_m, long timeout)
    {
        WebElement element = WaitElement(locator, error_m, timeout);
        String compare_value = element.getAttribute("contentDescription");
        Assert.assertEquals(
                "Not True Content",
                value,
                compare_value
        );
        return element;
    }

    private By getLocatorByString(String locator_with_type) //throws Exception
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"),2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);
        } else if (by_type.equals("css")) {
            return By.cssSelector(locator);
        } else
//        {
//            throw new IllegalAccessException("Cannot get type of locator:" + locator_with_type);
//        }
        return null;
    }

    public String takeScreenshot (String name)
    {
        TakesScreenshot ts = (TakesScreenshot)this.driver;
        File source  = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/" + name + "_screenshot.png";
        try {
            FileUtils.copyFile(source, new File(path));
            System.out.println("The screenshot was taken: " + path);
        } catch (Exception e){
            System.out.println("Cannot take screenshot. Error: " + e.getMessage());
        }
        return path;
    }

    @Attachment
    public static byte[] screenshot(String path){
        byte[] bytes = new byte[0];

        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Cannot get bytes from screenshot. Error: " + e.getMessage());
        }
        return bytes;
    }
}
