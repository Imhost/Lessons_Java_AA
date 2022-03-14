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

//public class FirstATest extends Elements
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

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void firstTest()
    {
//        System.out.println("First test run");
        WebElement element_skip_button = driver.findElementById("org.wikipedia:id/fragment_onboarding_skip_button");
        element_skip_button.click();

        Click(
                By.xpath("//*[contains(@text, 'Поиск по Википедии')]"),
                "Cannot",
                5
        );

//        SendKeys(
//                By.xpath("//*[contains(@text, 'Поиск по Википедии')]"),
//                "Java",
//                "Error Send JAVA",
//                5
//        );

        assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Поиск по Википедии",
                "Error Send JAVA",
                5
        );
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

    private WebElement SendKeys(By by, String value, String error_m, long timeout)
    {
        WebElement element = fTimeout(by, error_m, timeout);
        element.sendKeys(value);
        return element;
    }

    private WebElement assertElementHasText(By by, String value, String error_m, long timeout)
    {
        WebElement element = fTimeout(by, error_m, timeout);
        String compare_value = element.getText();
        Assert.assertEquals(
                "Not True Content",
                value,
                compare_value
        );
        return element;
    }
}
