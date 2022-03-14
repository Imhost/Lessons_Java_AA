//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class Elements
//{
//    public WebElement waitForElementPresent(By by, String error_message, long timeout)
//    {
//        WebDriverWait wait = new WebDriverWait(driver, timeout);
//        wait.withMessage(error_message + "\n");
//        return wait.until(ExpectedCondition.presenceOfElementLocated(by));
//    }
//
//    public WebElement waitForElementPresent(By by, String error_message)
//    {
//        return waitForElementPresent(by, error_message, 5);
//    }
//
//    public WebElement waitElementAndClick(By by, String error_message, long timeout)
//    {
//        WebElement element = waitForElementPresent(by, error_message, timeout);
//        element.click();
//        return element;
//    }
//
//    public WebElement waitElementAndSendKeys(By by, String value, String error_message, long timeout)
//    {
//        WebElement element = waitForElementPresent(by, error_message, timeout);
//        element.sendKeys(value);
//        return element;
//    }
//
//    public WebElement waitElementNotPresent(By by, String error_message, long timeout)
//    {
//        WebDriverWait wait = new WebDriverWait(driver, timeout);
//        wait.withMessage(error_message + "\n");
//        return  wait.until(ExpectedCondition.invisibilityOfElementLocated(by));
//    }
//}
// ------------------------------------------------
//
//    private WebElement waitForElementPresent(By by, String error_message)
//    {
//        return waitForElementPresent(by, error_message, 5);
//    }
//
//    private WebElement waitElementAndClick(By by, String error_message, long timeout)
//    {
//        WebElement element = waitForElementPresent(by, error_message, timeout);
//        element.click();
//        return element;
//    }
//
//    private WebElement waitElementAndSendKeys(By by, String value, String error_message, long timeout)
//    {
//        WebElement element = waitForElementPresent(by, error_message, timeout);
//        element.sendKeys(value);
//        return element;
//    }
//
//    private boolean WebElement waitElementNotPresent(By by, String error_message, long timeout)
//    {
//        WebDriverWait wait = new WebDriverWait(driver, timeout);
//        wait.withMessage(error_message + "\n");
//        return  wait.until(ExpectedCondition.invisibilityOfElementLocated(by));
//    }
