package Base;

import Core.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    WebDriver driver;
    protected Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverSetup.setChromeDriverObject();
        driver = DriverSetup.getDriver();
        logger.info("Open GitHub home page");
        driver.get("https://github.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            DriverSetup.driver.remove();
        }
    }
}
