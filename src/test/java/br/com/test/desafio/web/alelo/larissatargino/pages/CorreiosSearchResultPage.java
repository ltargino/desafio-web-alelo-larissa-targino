package br.com.test.desafio.web.alelo.larissatargino.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CorreiosSearchResultPage extends BasePage {

    private WebElement resultTable;

    public CorreiosSearchResultPage(WebDriver driver) {
        super(driver);

        resultTable = driver.findElement(By.id("resultado-DNEC"));
    }

    public long getResultTableCount() {
        return this.resultTable
                .findElements(By.tagName("tr"))
                .stream().count();
    }

    public void printResults() {

        System.out.println("| Logradouro/Nome | Bairro/Distrito | Localidade/UF | CEP |");

        List<WebElement> rows = this.resultTable.findElements(By.tagName("tr"));

        rows.stream()
            .forEach(line -> {

                List<WebElement> cells = line.findElements(By.tagName("td"));

                cells.stream().forEach(cell -> {
                    System.out.print("| " + cell.getText() + " ");
                });

                if (cells.size() > 0) {
                    System.out.println("|");
                }

            });

    }

    public String getTitle () {
        return driver.getTitle();
    }

    public String getResultTitle(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mensagem-resultado\"]/h4")));
      return driver.findElement(By.xpath("//*[@id=\"mensagem-resultado\"]/h4")).getText();


    }

}