package com.w2a.testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void bankManagerLoginTest() throws IOException, InterruptedException {

        verifyEquals("abc","xyz");

        log.debug("Inside Login Test");
        click("bmlBtn_CSS");

        assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))), "Login not successful");

        log.debug("Login successfully executed");

    }
}
