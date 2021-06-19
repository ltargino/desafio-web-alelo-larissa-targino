package br.com.test.desafio.web.alelo.larissatargino.pages;

import lombok.Getter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public abstract class BasePage {

    @Getter
    protected WebDriver driver;

    public BasePage(final WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenShot() {

        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        String path = "./target/screenshots/" + source.getName();

        try {
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
