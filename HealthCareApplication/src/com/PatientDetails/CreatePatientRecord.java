package com.PatientDetails;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaseTest.UtilityMethods;

public class CreatePatientRecord extends UtilityMethods
{
	//added new comments
	public WebDriver driver;
	public int a,b,c,d,e,f,g,h,i,j,k,l;
	
	public void CreatePatient1() throws InterruptedException, AWTException 
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@title='Enter Patient']")));
		
		driver.findElement(By.xpath(".//*[@title='Enter Patient']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='textfield-1475-inputEl']")).sendKeys(LName);
		driver.findElement(By.xpath(".//*[@id='textfield-1476-inputEl']")).sendKeys(FName);
		driver.findElement(By.xpath(".//*[@id='datefield-1479-inputEl']")).sendKeys(DDOB);
		driver.findElement(By.xpath(".//*[@id='combo-1480-trigger-picker']")).click();
		String ADOB=driver.findElement(By.xpath(".//*[@id='boundlist-1987-listEl']/li[2]")).getText();
		if(ADOB.equals(DOB))
		{
			driver.findElement(By.xpath(".//*[@id='boundlist-1987-listEl']/li[2]")).click();
		}
		else
		{
			driver.findElement(By.xpath(".//*[@id='boundlist-1987-listEl']/li[3]")).click();
		}
		driver.findElement(By.xpath(".//*[@id='boundlist-1987-listEl']/li[2]")).click();
		driver.findElement(By.xpath(".//*[@id='textfield-1482-inputEl']")).sendKeys(Address);
		driver.findElement(By.xpath(".//*[@id='zipcode-1485-inputEl']")).sendKeys(ZipCode);
		driver.findElement(By.xpath(".//*[@id='textfield-1486-inputEl']")).sendKeys(City);
		driver.findElement(By.xpath(".//*[@id='phonenumber-1505-inputEl']")).sendKeys(PhoneNo);
		driver.findElement(By.xpath(".//*[@id='savebutton-1549']")).click();
		Thread.sleep(3000);
//		UploadDocuments();
	}
	public void UploadDocuments() throws InterruptedException, AWTException
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tab-1956']")));
		
		driver.findElement(By.xpath(".//*[@id='tab-1956']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='ext-element-1']")).click();
		Thread.sleep(1000);
		StringSelection stringSelection = new StringSelection("D:\\Patient.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		// native key strokes for CTRL, V and ENTER keys
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);//press control 
		robot.keyPress(KeyEvent.VK_V);//press v
		robot.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath(".//*[@name='fileName']")).sendKeys("PatientDetails");
		driver.findElement(By.xpath(".//*[@name='documentType']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='boundlist-2017-listEl']/li[9]")).click();
		driver.findElement(By.name("providerLegalEntityKey")).click();
		Thread.sleep(400);
		driver.findElement(By.xpath(".//*[@id='boundlist-2019-listEl']/li[2]")).click();
		driver.findElement(By.xpath(".//*[@id='savebutton-1643']")).click();
	}
}
