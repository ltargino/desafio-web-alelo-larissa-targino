package br.com.test.desafio.web.alelo.larissatargino.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getDriver() {

        switch (Properties.browser) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();

        return driver;
    }

}
