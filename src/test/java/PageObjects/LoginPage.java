package PageObjects;

import Base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends Page {
    public void fillSignInForm(String login, String password) {
        logger.info("Fill Sign In Form");
        driver.findElement(By.id("login_field")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void clickSubmitButton() {
        logger.info("Click submit button");
        driver.findElement(By.name("commit")).click();
    }

    public void checkText(String text) {
        Assert.assertTrue(findElementByText(text).isDisplayed(), String.format("%s - are not displayed on this page!",
                text));
    }

    public void checkFormValidation() {
        logger.info("Check validation of the form!");
        WebElement form = driver.findElement(By.cssSelector("form"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", form);
        Assert.assertTrue(isValid, "There is no validation on this form!");
    }

    public void clickForgotPasswordButton() {
        logger.info("Click Forgot Password Button");
        driver.findElement(By.id("forgot-password")).click();
    }
}
