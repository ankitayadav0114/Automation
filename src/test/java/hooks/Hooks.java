package hooks;

import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import driverUtilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private DriverManager driverManager;
    private WebDriver driver;

    public Hooks(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Before
    public void setup() {
        driver = driverManager.initDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
    }

    @After
    public void tearDown() {
       driverManager.quitDriver();
    }
}
