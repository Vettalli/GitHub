package PageObjects;

import Base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class UserHomePage extends Page {

    public void openUserMenuAndGoToTab(String userName, String tab) {
        logger.info(String.format("Open user's manu and go tab - %s", tab));
        findElementByAttribute("data-login", userName).click();
        findElementByText(tab).click();
    }

    public void checkUserName(String name) {
        logger.info("Check user's name");
        WebElement actualUserName  = findElementByAttribute("data-login", name);
        Assert.assertTrue(actualUserName.isDisplayed(), "Incorrect users' names!");
    }

    public void checkMainElementsOnUserPage(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.id("overview-tab")).isDisplayed(), "overview tab is not presented");
        softAssert.assertTrue(driver.findElement(By.id("repositories-tab")).isDisplayed(),  "repositories tab is not presented");
        softAssert.assertTrue(driver.findElement(By.id("projects-tab")).isDisplayed(), "projects tab is not presented");
        softAssert.assertTrue(driver.findElement(By.id("packages-tab")).isDisplayed(), "packages tab is not presented");
        softAssert.assertTrue(driver.findElement(By.id("stars-tab")).isDisplayed(), "stars tab is not presented");

        softAssert.assertAll();
    }

    public void goToRepo(String repoName) {
        logger.info(String.format("Go to Repo %s", repoName));
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(
                "//*[contains(@href, '%s')]", repoName))));
        driver.findElement(By.xpath(String.format("//*[contains(@href, '%s')]", repoName))).click();
    }

    public void goToTab(String tab) {
        logger.info(String.format("Go to tab %s", tab));
        findElementByAttribute("data-content",tab).click();
    }

    public void clickNewIssueButton() {
        logger.info("Click new issue button");
        driver.findElement(By.xpath("//*[contains(@class, 'Button') and contains(text(), 'New issue')]")).click();
    }

    public void fillNewIssuesFields(String title, String text) {
        logger.info("fill new issue fields");
        driver.findElement(By.xpath("//input[@aria-label='Add a title']")).sendKeys(title);
        driver.findElement(By.xpath("//textarea[@aria-label='Markdown value']")).sendKeys(text);
        findElementByAttribute("data-testid", "create-issue-button").click();
    }

    public void checkNewIssuePresent(String issueTitle) {
        Assert.assertTrue(findElementByText(issueTitle).isDisplayed(), "New Issue is not presented!");
    }
}
