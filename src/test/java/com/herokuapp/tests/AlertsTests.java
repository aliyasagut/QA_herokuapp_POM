package com.herokuapp.tests;

import com.herokuapp.pages.AlertsPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsPage();
    }

    @Test
    public void clickForJsAlertTest() {
        new AlertsPage(driver).clickForJsAlert().verifyAlertClosed();
    }

    @Test
    public void clickForJsConfirm() {
        new AlertsPage(driver).selectResult("Cancel").verifyResult("Cancel");
    }

    @Test
    public void clickForJsPrompt() {
        new AlertsPage(driver).sendMessageToAlert("Hello test").verifyMessage("Hello test");
    }

}
