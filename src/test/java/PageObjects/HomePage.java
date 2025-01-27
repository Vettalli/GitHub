package PageObjects;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import Base.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

public class HomePage extends Page {
    private WebElement backgroundElement = findElementByAttribute("class",
            "octicon octicon-mark-github");
    private WebElement signInButton = driver.findElement(By.xpath(
            "//*[contains(@class, 'HeaderMenu-link') and contains(@class, 'sign-in')]"));
    private WebElement signUpButton = driver.findElement(By.xpath(
            "//*[contains(@class, 'HeaderMenu-link') and contains(@class, 'sign-up')]"));
    private WebElement searchField = findElementByAttribute("class",
            "search-input-container");

    public void checkHomePageBackGroundPresent() {
        logger.info("Check Home page Background presents");
        Assert.isTrue(backgroundElement.isDisplayed(), "Home page Background not presented");
    }

    public void checkMainElementsPresent() {
        SoftAssert softAssert = new SoftAssert();
        logger.info("Check sign in button presents");
        softAssert.assertTrue(signInButton.isDisplayed(), "sign in button not presented");
        logger.info("Check sign up button presents");
        softAssert.assertTrue(signUpButton.isDisplayed(), "sign up button not presented");
        logger.info("Check search field presents");
        softAssert.assertTrue(searchField.isDisplayed(), "search field not presented");
        softAssert.assertAll();
    }

    public void clickSingInButton() {
        waitDriver.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

    public void sendTextToSearchField(String text) {
        searchField.click();
        WebElement searchFieldInput = driver.findElement(By.id("query-builder-test"));
        searchFieldInput.sendKeys(text);
        searchFieldInput.sendKeys(Keys.ENTER);
    }


}
