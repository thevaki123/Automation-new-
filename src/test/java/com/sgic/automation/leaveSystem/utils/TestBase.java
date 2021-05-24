package com.sgic.automation.leaveSystem.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class TestBase extends PageBase {

    public SoftAssert softAssert;
    public static ExtentReports extentReport = new ExtentReports(System.getProperty("user.dir") + "/src/test/resources/reports/ExtentReportResults.html");
    public static ExtentTest extentTest;
    private static final Logger LOGGER = Logger.getLogger(TestBase.class);

    @BeforeTest
    public void beforeTest() {

        System.out.println("Test Running " + this.getClass().toString());
    }

    @BeforeMethod
    public void loadBrowser() {
        LOGGER.info("Initiate Browser");
        try {
            PageBase.initiateDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        LOGGER.info("Browser Initiated");
    }

    @BeforeMethod
    public void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void nameBefore(Method method) {

        LOGGER.info("Test name: " + method.getName());
    }
    @BeforeClass
    public void login(){
//        DashboardPage.clickManageLeaveMenu();
//        DashboardPage.clickManageLeaveTypeSubMenu();
    }
    @AfterMethod(alwaysRun=true)
    public void endTest(ITestResult result){
        if(!result.isSuccess()){
            extentReport.endTest(extentTest);
            extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(ExtentReportFunctions.getFilePath()));


        }
        LOGGER.info("Closing Browser");
        PageBase.closeDriver();
        LOGGER.info("Browser Closed");

    }


    @AfterMethod
    public void afterMethod(Method method, ITestResult result) {
        LOGGER.info("Executed test case name:" + method.getName() + " Execution Results : " + result.toString());
    }

    //report generation

    @AfterSuite
    public void cleanUp() {
        extentReport.flush();

    }
}
