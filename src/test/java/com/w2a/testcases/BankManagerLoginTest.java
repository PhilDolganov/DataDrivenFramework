package com.w2a.testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() {


        log.debug("Inside Login Test");
        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();

        assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))), "Login not successful");

        log.debug("Login successfully executed");
       // Reporter.log("Login successfully executed");
        Assert.fail("Login not successful");
    }
}
