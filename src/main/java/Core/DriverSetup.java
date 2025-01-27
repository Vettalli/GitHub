package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverSetup {
    public static ThreadLocal<WebDriver> driver;

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setChromeDriverObject() {
        driver = new ThreadLocal<>();
        driver.set(new ChromeDriver(DriverSetup.getChromeOptions()));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-web-security");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");

        return options;
    }
}
