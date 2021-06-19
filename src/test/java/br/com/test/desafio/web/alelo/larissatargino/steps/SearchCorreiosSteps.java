package br.com.test.desafio.web.alelo.larissatargino.steps;

import br.com.test.desafio.web.alelo.larissatargino.hooks.WebDriverHook;
import br.com.test.desafio.web.alelo.larissatargino.pages.CorreiosHomePagePage;
import br.com.test.desafio.web.alelo.larissatargino.pages.CorreiosSearchResultPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class SearchCorreiosSteps {

    private CorreiosHomePagePage correiosHomePagePage = new CorreiosHomePagePage(WebDriverHook.getDriver());
    private CorreiosSearchResultPage correiosSearchResultPage;

    @Dado("que eu acesse o site dos correios")
    public void queEuAcesseOSiteDosCorreios() {
        correiosHomePagePage.goToHomePage();
        Assert.assertEquals("Correios — Correios, o maior operador logístico do Brasil.", correiosHomePagePage.getTitle());
    }

    @Quando("eu realizar a pesquisa por {string}")
    public void euRealizarAPesquisaPor(String texto) {
        correiosHomePagePage.fillFieldSearch(texto);
    }

    @Quando("clicar no botao Buscar")
    public void clicarNoBotaoBuscar() {
        correiosSearchResultPage = correiosHomePagePage.search();
    }

    @Então("devera ser possivel fazer output das informações retornadas")
    public void deveraSerPossivelFazerOutputDasInformaçõesRetornadas() {
        Assert.assertEquals("Busca CEP", correiosSearchResultPage.getTitle());
        Assert.assertEquals("Resultado da Busca por Endereço ou CEP", correiosSearchResultPage.getResultTitle());
        correiosSearchResultPage.printResults();
    }

}
