package PageObjects;

import Base.Page;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class ResetPasswordPage extends Page {
    public void checkResetPasswordPagePresent() {
        logger.info("check reset password page opened");
        findElementByText("Reset your password");
    }

    public void checkMainElementsPresent() {
        logger.info("check all the main elements are presented on the page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.id("email_field")).isDisplayed(), "Email field is not displayed");
        softAssert.assertTrue(findElementByText("Verify your account").isDisplayed(),
                "Verify your account field is not displayed");
        softAssert.assertTrue(findElementByAttribute("name", "commit").isDisplayed(),
                "Commit field is not displayed");
        softAssert.assertAll();

    }

}
