package br.com.test.desafio.web.alelo.larissatargino.pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class CorreiosHomePagePage extends BasePage {

    public CorreiosHomePagePage(WebDriver driver) {
        super(driver);
    }

    public void fillFieldSearch(String texto) {
        WebElement campoBuscar = driver.findElement(By.name("relaxation"));
        campoBuscar.sendKeys(texto);
        this.takeScreenShot();
    }

    public CorreiosSearchResultPage search() {
        WebElement lupaBuscar = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[2]/form/button/i"));
        lupaBuscar.click();

        String currentWindow = this.driver.getWindowHandle();
        List<String> windows = new ArrayList<>(this.driver.getWindowHandles());
        int currentWindowIndex = windows.indexOf(currentWindow);

        this.driver.switchTo().window(windows.get(currentWindowIndex + 1));

        this.takeScreenShot();

        return new CorreiosSearchResultPage(this.driver);
    }

    public void goToHomePage() {
        this.driver.get("https://www.correios.com.br/");
        this.takeScreenShot();
    }

    public String getTitle () {
        return driver.getTitle();
    }


}




