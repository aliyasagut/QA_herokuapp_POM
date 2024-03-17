package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.MultipleWindowsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getMultupleWindowsPage();
    }

    @Test
    public void openNewTabTest() {
        new MultipleWindowsPage(driver).switchToNextTab(1).verifyNewTabText("New Window");
    }
}
