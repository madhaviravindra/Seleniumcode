package com.BaseTest;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.PatientDetails.CreatePatientRecord;

public class RunTest extends CreatePatientRecord
{
	//private WebDriver driver;
	public void Setup() throws InterruptedException, AWTException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Browser Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://ps7.practicesuite.com/PracticeSuite/login.do");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		loginApp();
	}
	public void loginApp() throws InterruptedException, AWTException
	{
		driver.findElement(By.xpath(".//*[@id='userName']")).sendKeys("rkasaragadda");	
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Ravindra@123456");
		driver.findElement(By.xpath(".//*[@id='accountId']")).sendKeys("10281");
		driver.findElement(By.xpath(".//*[@id='myButton']")).click();
		WebDriverWait wait = new WebDriverWait(driver,50);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='tool-1293-toolEl']")));
		driver.findElement(By.xpath(".//*[@id='tool-1293-toolEl']")).click();
		Thread.sleep(1000);
		CreatePatient1();
	}

	public static void main(String[] args) throws InterruptedException, AWTException, IOException 
	{
		RunTest m= new RunTest();
		ReadExcel();
		m.Setup();
	//	m.CreatePatient1();
	}

}
