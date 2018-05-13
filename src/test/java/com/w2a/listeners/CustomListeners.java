package com.w2a.listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;
import org.testng.*;

import java.io.IOException;

public class CustomListeners extends TestBase implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = rep.startTest(iTestResult.getName().toUpperCase());
        //runmodes -Y
        if (!TestUtil.isTestRunnable(iTestResult.getName(), excel)){
            throw new SkipException("Skipping the test" + iTestResult.getName().toUpperCase() + "as the Run mode is NO");
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        test.log(LogStatus.PASS, iTestResult.getName().toUpperCase() + " PASS");
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
            TestUtil.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.log(LogStatus.FAIL, iTestResult.getName().toUpperCase() + " Failed with exception : " + iTestResult.getThrowable());
        test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

        Reporter.log("Click to see screenshot");
        Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + ">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName + " height=200 width=200></img></a>");
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.log(LogStatus.SKIP, iTestResult.getName().toUpperCase() + " Skipped the test as the Run mode is NO");
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
