package com.w2a.testcases;

import com.relevantcodes.extentreports.ExtentTest;
import com.w2a.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws IOException, InterruptedException {

        verifyEquals("abc","xyz");
        Thread.sleep(3000);
        log.debug("Inside Login Test");
        click("bmlBtn_CSS");

        assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))), "Login not successful");

        log.debug("Login successfully executed");

    }
}
