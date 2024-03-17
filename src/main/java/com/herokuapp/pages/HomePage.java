package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[href='/javascript_alerts']")
    WebElement javaScriptAlertsLink;

    public AlertsPage getAlertsPage() {
        click(javaScriptAlertsLink);
        return new AlertsPage(driver);
    }

    @FindBy(css = "[href='/windows']")
    WebElement multipleWindowsLink;

    public MultipleWindowsPage getMultupleWindowsPage() {
        click(multipleWindowsLink);
        return new MultipleWindowsPage(driver);
    }
}
