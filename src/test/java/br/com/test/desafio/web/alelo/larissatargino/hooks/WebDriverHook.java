package br.com.test.desafio.web.alelo.larissatargino.hooks;

import br.com.test.desafio.web.alelo.larissatargino.config.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class WebDriverHook {

    @Getter
    private static WebDriver driver;

    @Before
    public void initDriver() {
        driver = DriverFactory.getDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
