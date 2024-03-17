package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AlertsPage extends BasePage{
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[onclick='jsAlert()']")
    WebElement jsAlert;

    public AlertsPage clickForJsAlert() {
        click(jsAlert);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "result")
    WebElement confirmResult;

    public AlertsPage verifyAlertClosed() {
        Assert.assertTrue(confirmResult.getText().contains("You successfully clicked an alert"));
        return this;
    }

    @FindBy(css = "[onclick='jsConfirm()']")
    WebElement jsConfirm;

    public AlertsPage selectResult(String confirm) {
        click(jsConfirm);
        if(confirm != null && confirm.equals("OK")) {
            driver.switchTo().alert().accept();
        } else if (confirm != null && confirm.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    public AlertsPage verifyResult(String result) {
        Assert.assertTrue(confirmResult.getText().contains(result));
        return this;
    }

    @FindBy(css = "[onclick='jsPrompt()']")
    WebElement jsPrompt;

    public AlertsPage sendMessageToAlert(String text) {
        click(jsPrompt);
        if (text != null) {
            driver.switchTo().alert().sendKeys(text);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    public AlertsPage verifyMessage(String text) {
        Assert.assertTrue(confirmResult.getText().contains(text));
        return this;
    }
}
