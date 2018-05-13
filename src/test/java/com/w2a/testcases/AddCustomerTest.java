package com.w2a.testcases;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AddCustomerTest extends TestBase {

    @Test(dataProviderClass = TestUtil.class,dataProvider = "dp")
    public void addCustomerTest(String firstName, String lastName, String postCode, String alerttext) throws InterruptedException {
        click("addCustBtn_CSS");
        type("firstname_CSS",firstName);
        type("lastname_XPATH",lastName);
        type("postcode_CSS",postCode);
        click("addbtn_CSS");
        Thread.sleep(2000);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains(alerttext));
        alert.accept();

        Thread.sleep(2000);

    }
}
