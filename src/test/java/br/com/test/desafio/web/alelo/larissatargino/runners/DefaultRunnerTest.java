package br.com.test.desafio.web.alelo.larissatargino.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/report-html.html"},
        features = "src/test/resources/features",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {
                "br.com.test.desafio.web.alelo.larissatargino.steps",
                "br.com.test.desafio.web.alelo.larissatargino.hooks"
        }
)
public class DefaultRunnerTest {
}
