package Libs;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;
import java.util.Properties;

public class CoreTestCase
{
    protected RemoteWebDriver driver;

    @Before
    @Step("Запуск драйвера и сессии")
    public void setUp() throws Exception
    {
        driver = Platform.getInstance().getDriver();
        this.createAllurePropertyFile();
        //this.openWikiWebPageForMobileWeb();
    }

    @After
    @Step("Завершение драйвера и сессии")
    public void tearDown()
    {
        driver.quit();
    }

    protected void rotateScreenPortrait()
    {
        if (driver instanceof AppiumDriver)
        {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateSreenPortrait() does noting for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    protected void rotateSreenLandscape()
    {
        if (driver instanceof AppiumDriver)
        {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method rotateSreenPortrait() does noting for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Открытие страницы Wikipedia (не используется для Android и iOS)")
    protected void openWikiWebPageForMobileWeb()
    {
        if(Platform.getInstance().isMW()){
            driver.get("https://en.m.wikipedia.org");
        } else {
            System.out.println("Method openWikiWebPageForMobileWeb() does noting for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    private void createAllurePropertyFile()
    {
        String path = System.getProperty("allure.results.directory");
        try {
            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
            props.setProperty("Environment", Platform.getInstance().getPlatformVar());
            props.store(fos, "See github");
            fos.close();
        } catch (Exception e){
            System.err.println("IO problems");
            e.printStackTrace();
        }
    }

}
