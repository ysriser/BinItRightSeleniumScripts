package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificationMethods {

	protected WebDriver driver;
    protected String appUrl;

    @BeforeMethod
    public void setUp() {

        // URL provided by CI/CD
        appUrl = System.getenv("APP_URL");

        if (appUrl == null) {
            throw new RuntimeException("APP_URL not provided by CI/CD pipeline");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
