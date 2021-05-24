package com.sgic.automation.leaveSystem.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class OrangeHrmTestScript {
    public static void main(String[] args)
    {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        driver.findElement(By.id("menu_admin_UserManagement")).click();
        driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
        driver.findElement(By.id("systemUser-information")).click();



        driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Thevaki");

        Select selectByVisibleText=new Select(driver.findElement(By.id("searchSystemUser_userType")));
        selectByVisibleText.selectByVisibleText("Admin");

        driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys("Kamala");

        Select selectByVisibleText1=new Select(driver.findElement(By.id("searchSystemUser_status")));
        selectByVisibleText1.selectByVisibleText("Enabled");

        driver.findElement(By.id("btnAdd")).click();

        Select selectByVisibleText2=new Select(driver.findElement(By.id("systemUser_userType")));
        selectByVisibleText2.selectByVisibleText("Admin");

        driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("John Smith");
        driver.findElement(By.id("systemUser_userName")).sendKeys("Kamalesh");

        Select selectByVisibleText3=new Select(driver.findElement(By.id("systemUser_status")));
        selectByVisibleText3.selectByVisibleText("Enabled");

        driver.findElement(By.id("systemUser_password")).sendKeys("Thevaki@#123");
        driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Thevaki@#123");

        driver.findElement(By.id("btnSave")).click();


        //driver.close();

    }
}
