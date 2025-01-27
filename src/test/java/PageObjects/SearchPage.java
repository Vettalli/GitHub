package PageObjects;

import Base.Page;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SearchPage extends Page {
    public void goToUsersTab() {
        logger.info("Go to Users tab");
        findElementByAttribute("data-testid", "nav-item-users").click();
    }

    public void goToIssuesTab() {
        logger.info("Go to Issues tab");
        findElementByAttribute("data-testid", "nav-item-issues").click();
    }

    public void checkTabWithResultsOpened() {
       Assert.assertTrue(driver.findElement(By.id("search-results-count")).isDisplayed(), "Issues' tab is not opened");
    }

    public void checkPageAfterSearchingEmptyStringPresent() {
        Assert.assertTrue(findElementByText("advanced search").isDisplayed(), "Wrong Page!");
    }

    public void goToRepositoriesTab() {
        logger.info("Go to Repositories tab");
        findElementByAttribute("data-testid", "nav-item-repositories").click();
    }
}
