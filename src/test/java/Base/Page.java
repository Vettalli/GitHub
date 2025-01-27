package Base;

import Core.DriverSetup;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class Page {
    public Logger logger;
    public WebDriver driver;
    public WebDriverWait waitDriver;

    public Page() {
        logger = LoggerFactory.getLogger(Page.class);
        driver = DriverSetup.getDriver();
        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement findElementByAttribute(String nameAttribute,
                                             String content) throws NoSuchElementException {
        logger.info(String.format("Search element with attribute %s and content %s", nameAttribute, content));
        WebElement element = waitDriver.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@" + nameAttribute + "," + "'" + content + "'" + ")]")));

        return element;
    }

    public WebElement findElementByText(String content) throws NoSuchElementException {
        logger.info(String.format("Search element with text %s", content));
        WebElement element = waitDriver.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text()," + "'" + content + "'" + ")]")));

        return element;
    }
}
