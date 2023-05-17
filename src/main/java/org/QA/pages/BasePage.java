package org.QA.pages;

import org.QA.utils.Config;
import org.QA.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public WebDriver Driver;
    protected String Url;
    // define header element
    protected WebElement CountryButton;
    protected WebElement LanguageButton;
    //Define driver Wait
     protected WebDriverWait DriverWait;
    public BasePage() {
        Driver =  DriverManager.getDriver();
        DriverWait = new WebDriverWait(Driver, Duration.ofSeconds(Config.getTimeOut()));
        Url = Config.getBaseUrl();
    }

    //Navigate to URL
    public void GoTo() {
        Driver.get(Url);
    }
}
