package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {
	

	public GenericWrappers (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	public RemoteWebDriver driver;

	public void invokeApp(String browser, String URL) {
	
	try{
		if(browser.equalsIgnoreCase("Chrome")){

			System.setProperty("WebDriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("Firefox")){
		System.setProperty("WebDriver.gecko.driver", "./Drivers/geckodriver_32bit.exe");
		driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		reportStep("The Broswer : "+browser+" Started successfull", "PASS");
		} catch(Exception e){
			e.printStackTrace();
			reportStep("The Browser : "+browser+" could not be started", "FAIL");
		}
	}

	public void enterById(String idValue, String data) {
		try{
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);
			reportStep("The "+data+" successfully entered in the field "+idValue, "PASS");
		} catch (NoSuchElementException e){
			reportStep("The element "+idValue+" could not be found", "FAIL");			
		} catch (WebDriverException e){
			reportStep("WebDriver exception occured while entering the data "+data+" in the field "+idValue, "FAIL");
		} catch(Exception e){
			reportStep("Unknown exception ocured while entering the data "+data+" in the field "+idValue, "FAIL");
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		try{
			
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);
			reportStep("The "+data+" entered successfully in the field "+xpathValue, "PASS");
		} catch(NoSuchElementException e){
			reportStep("The element "+xpathValue+" could not be found", "FAIL");
		} catch(WebDriverException e){
			reportStep("WebDriver Exception occured while entering the data "+data+" in the field "+xpathValue, "FAIL");
		} catch(Exception e){
			reportStep("Unknown exception occured while entering the data "+data+" in the field "+xpathValue, "FAIL");
		}
	}

	public void enterByName(String nameValue, String data) {
		try{
			driver.findElement(By.id(nameValue)).clear();
			driver.findElement(By.id(nameValue)).sendKeys(data);
			reportStep("The "+data+" entered successfull in the feild "+nameValue, "PASS");
		} catch (NoSuchElementException e){
			reportStep("The element "+nameValue+" could not be found", "FAIL");
		} catch(WebDriverException e){
			reportStep("WebDriver Exception occured while entering the data "+data+" in the field "+nameValue, "FAIL");
		} catch(Exception e){
			reportStep("Unknown exception occured while entering the data "+data+" in the field "+nameValue, "FAIL");
		}
	}

	public void entertByClassName(String classValue, String data) {
		try{
			driver.findElement(By.className(classValue)).clear();
			driver.findElement(By.className(classValue)).sendKeys("data");
		} catch(NoSuchElementException e){
			reportStep("The data "+data+" entered successfully in the field "+classValue, "PASS");
		} catch (WebDriverException e){
			reportStep("WebDriver Exception occured while entering the data "+data+" in the field"+classValue, "FAIL");
		} catch(Exception e){
			reportStep("Unknown excpetion occured while entering the data "+data+" in the field "+classValue, "FAIL");
		}
	}

	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		try{
			
		if(driver.getTitle().equalsIgnoreCase(title)){
			reportStep("The title matches with the given value: "+title, "PASS");
			bReturn = true;
		} else{
			reportStep("The title of the page: "+driver.getTitle()+" does not match with the value: "+title, "FAIL");
		} 
		
		} catch(Exception e){
			reportStep("Unknown exception occured while verifying the title "+title, "FAIL");
		}
		return bReturn;
	}

	public void verifyTextById(String idValue, String text) {
		String sText = driver.findElement(By.id(idValue)).getText();
		try{
			if(sText.equals(text)){
				reportStep("The text "+sText+" matches with the value"+text, "PASS");
			} else{
				reportStep("The text "+sText+" does not matches with the value"+text, "FAIL");
			}
		} catch(NoSuchElementException e){
			reportStep("The field "+idValue+ " is not found", "FAIL");
		} catch(WebDriverException e){
			reportStep("WebDriver Exception occured while verifying text "+sText+" with the value: "+text, "FAIL");
		} catch (Exception e){
			reportStep("Unknown Exception occured while verifying text "+sText+" with the value: "+text, "FAIL");
		}
	}

	public void verifyTextByXpath(String xpathValue, String text) {
		String sText = driver.findElement(By.xpath(xpathValue)).getText();
		try{
			if(sText.equals(text)){
				reportStep("The text "+sText+" matches with the value"+text, "PASS");
			} else{
				reportStep("The text "+sText+" does not matches with the value"+text, "FAIL");
			}
		} catch(NoSuchElementException e){
			reportStep("The field "+xpathValue+ " is not found", "FAIL");
		} catch(WebDriverException e){
			reportStep("WebDriver Exception occured while verifying text "+sText+" with the value: "+text, "FAIL");
		} catch (Exception e){
			reportStep("Unknown Exception occured while verifying text "+sText+" with the value: "+text, "FAIL");
		}
	}

	public void verifyTextByName(String nameValue, String text) {
		String sText = driver.findElement(By.name(nameValue)).getText();
		try{
			if(sText.equals(text)){
				reportStep("The text "+sText+" matches with the value"+text, "PASS");
			} else{
				reportStep("The text "+sText+" does not matches with the value"+text, "FAIL");
			}
		} catch(NoSuchElementException e){
			reportStep("The field "+nameValue+ " is not found", "FAIL");
		} catch(WebDriverException e){
			reportStep("WebDriver Exception occured while verifying text "+sText+" with the value: "+text, "FAIL");
		} catch (Exception e){
			reportStep("Unknown Exception occured while verifying text "+sText+" with the value: "+text, "FAIL");
		}
	}

	public void verifyTextByClassName(String classValue, String text) {
		String sText = driver.findElement(By.className(classValue)).getText();
		try{
			if(sText.equals(text)){
				reportStep("The text "+sText+" matches with the value"+text, "PASS");
			} else{
				reportStep("The text "+sText+" does not matches with the value"+text, "FAIL");
			}
		} catch(NoSuchElementException e){
			reportStep("The field "+classValue+ " is not found", "FAIL");
		} catch(WebDriverException e){
			reportStep("WebDriver Exception occured while verifying text "+sText+" with the value: "+text, "FAIL");
		} catch (Exception e){
			reportStep("Unknown Exception occured while verifying text "+sText+" with the value: "+text, "FAIL");
		}
		
	}
		


	public void verifyTextContainsById(String idValue, String text) {
		String sText = driver.findElement(By.id(idValue)).getText();
		try{
		if(sText.contains(text)){
			reportStep("The text "+sText+" contains the value "+text, "PASS");
		} else {
			reportStep("The text "+sText+" does not contains the value"+text, "FAIL");
			} 
		} catch(NoSuchElementException e){
			reportStep("The element: "+idValue+" not found", "FAIL");
		} catch(WebDriverException e){
			reportStep("WebDriver exception occured while comparing the text "+sText+" with the value "+text, "FAIL");
		} catch(Exception e){
			reportStep("Unknown exception occured while comparing the text "+sText+" with the value "+text, "FAIL");
		}
	}

	public void verifyTextContainsByXpath(String xpathValue, String text) {
		String sText = driver.findElement(By.xpath(xpathValue)).getText();
		try{
			if(sText.contains(text)){
				reportStep("The text "+sText+" contains the value "+text, "PASS");
			} else {
				reportStep("The text "+sText+" does not contains the value"+text, "FAIL");
				} 
			} catch(NoSuchElementException e){
				reportStep("The element: "+xpathValue+" not found", "FAIL");
			} catch(WebDriverException e){
				reportStep("WebDriver exception occured while comparing the text "+sText+" with the value "+text, "FAIL");
			} catch(Exception e){
				reportStep("Unknown exception occured while comparing the text "+sText+" with the value "+text, "FAIL");
			}
	}

	public void verifyTextContainsByName(String nameValue, String text) {
		String sText = driver.findElement(By.name(nameValue)).getText();
		try{
			if(sText.contains(text)){
				reportStep("The text "+sText+" contains the value "+text, "PASS");
			} else {
				reportStep("The text "+sText+" does not contains the value"+text, "FAIL");
				} 
			} catch(NoSuchElementException e){
				reportStep("The element: "+nameValue+" not found", "FAIL");
			} catch(WebDriverException e){
				reportStep("WebDriver exception occured while comparing the text "+sText+" with the value "+text, "FAIL");
			} catch(Exception e){
				reportStep("Unknown exception occured while comparing the text "+sText+" with the value "+text, "FAIL");
			}
	}

	public void verifyTextContainsByClassName(String classNameValue, String text) {
		String sText = driver.findElement(By.className(classNameValue)).getText();
		try{
			if(sText.contains(text)){
				reportStep("The text "+sText+" contains the value "+text, "PASS");
			} else {
				reportStep("The text "+sText+" does not contains the value"+text, "FAIL");
				} 
			} catch(NoSuchElementException e){
				reportStep("The element: "+classNameValue+" not found", "FAIL");
			} catch(WebDriverException e){
				reportStep("WebDriver exception occured while comparing the text "+sText+" with the value "+text, "FAIL");
			} catch(Exception e){
				reportStep("Unknown exception occured while comparing the text "+sText+" with the value "+text, "FAIL");
			}
		
	}

	public void clickById(String idValue) {
		try{
			driver.findElement(By.id(idValue)).click();
			reportStep("The element "+idValue+" is clicked successfully", "PASS");
			} catch (NoSuchElementException e){
				reportStep("The element "+idValue+" is not found","FAIL");
			} catch(WebDriverException e){
				reportStep("WebDriverException Occured while clicking the element"+idValue, "FAIL");
			} catch (Exception e){
				reportStep("Unknown exception occured while clicking the element "+idValue, "FAIL");
			}
	}

	public void clickbyXpath(String xpathValue) {
		try{
			driver.findElement(By.xpath(xpathValue)).click();
			reportStep("The element "+xpathValue+" is clicked successfully", "PASS");
		} catch(NoSuchElementException e){
			reportStep("The element "+xpathValue+" is not found", "FAIL");
		} catch(WebDriverException e){
			reportStep("WebDriver exception occured while clicking the element "+xpathValue, "FAIL");
		} catch(Exception e){
			reportStep("Unknown exception occured while clicking the element "+xpathValue, "FAIL");
		}
	}

	public void clickByClassName(String classNameValue) {
		try{
			driver.findElement(By.className(classNameValue)).click();
			reportStep("The element "+classNameValue+" is clicked successfully", "PASS");
		} catch(NoSuchElementException e){
			reportStep("The element "+classNameValue+" is not found", "FAIL");
		} catch(WebDriverException e){
		reportStep("WebDriver Exception occured while clicking the element "+classNameValue, "FAIL");
		} catch(Exception e){
			reportStep("Unknown exception occured while clicking the element "+classNameValue, "FAIL");
		}
	}

	public void clickByLinkText(String linkTextValue) {
		try{
			driver.findElement(By.linkText(linkTextValue)).click();
			reportStep("The element "+linkTextValue+" is clicked successfully", "PASS");
		} catch(NoSuchElementException e){
			reportStep("The element "+linkTextValue+" is not found", "FAIL");
		} catch(WebDriverException e){
			reportStep("WebDriverException Occured while clicking the element "+linkTextValue, "FAIL");
		} catch(Exception e){
			reportStep("Unknown exception occured while clicking the element "+linkTextValue, "FAIL");
		}
	}
	
	public void clickByLinkTextNoSnap(String linkTextValue) {
		try{
			driver.findElement(By.linkText(linkTextValue)).click();
		} catch(NoSuchElementException e){
			reportStep("The element "+linkTextValue+" is not found", "FAIL");
		} catch(WebDriverException e){
			reportStep("WebDriverException Occured while clicking the element "+linkTextValue, "FAIL");
		} catch(Exception e){
			reportStep("Unknown exception occured while clicking the element "+linkTextValue, "FAIL");
		}		
	}

	public String getTextById(String idValue) {
		String bReturn = "";
			try{
				return driver.findElement(By.id(idValue)).getText();
				
			} catch(NoSuchElementException e){
				reportStep("The element with idValue: "+idValue+" could not be found", "PASS");
			}
		return bReturn;
	}

	public String getTextByXpath(String xpathValue) {
		String bReturn = "";
		try{
			return driver.findElement(By.id(xpathValue)).getText();
			
		} catch(NoSuchElementException e){
			reportStep("The element with xpathValue: "+xpathValue+" could not be found", "PASS");
		}
	return bReturn;
	}

	public String getTextByClassName(String classNameValue) {
		String bReturn = "";
		try{
			return driver.findElement(By.id(classNameValue)).getText();
			
		} catch(NoSuchElementException e){
			reportStep("The element with classNameValue: "+classNameValue+" could not be found", "PASS");
		}
	return bReturn;
	}

	public String getTextByName(String nameValue) {
		String bReturn = "";
		try{
			return driver.findElement(By.id(nameValue)).getText();
			
		} catch(NoSuchElementException e){
			reportStep("The element with nameValue: "+nameValue+" could not be found", "PASS");
		}
	return bReturn;
	}

	public void selectVisibleTextById(String idValue, String value) {
		try{
			new Select(driver.findElement(By.id(idValue))).selectByVisibleText(value);
			reportStep("The visible text: "+value+" of dropdown element with idValue: "+idValue+" is selected successfully", "PASS");
		} catch(NoSuchElementException e){
			reportStep("The dropdown element with idValue: "+idValue+" could not be found", "FAIL");
		} catch(WebDriverException e){
			reportStep("WebdriverException occured while selecting the visible text in dropdown element with idValue: "+idValue, "FAIL");
		} catch(Exception e){
			reportStep("Unknown exception occured while selectiong the visible text in dropdown element with idValue"+idValue, "FAIL");
		}
	}

	public void selectIndexById(String idValue, String value) {
		try{
			new Select(driver.findElement(By.id(idValue))).selectByIndex(Integer.parseInt(value));
			reportStep("The index: "+value+" of the dropdown element with idValue: "+idValue+" is selected successfully", "PASS");
		}	catch(NoSuchElementException e){
				reportStep("The dropdown element with idValue: "+idValue+" could not be found", "FAIL");
			} catch(WebDriverException e){
				reportStep("WebdriverException occured while selecting the index in dropdown element with idValue: "+idValue, "FAIL");
			} catch(Exception e){
				reportStep("Unknown exception occured while selectiong the index in dropdown element with idValue"+idValue, "FAIL");
			}
	} 

	public void selectVisibleTextByXpath(String xpathValue, String value) {
		try{
			new Select(driver.findElement(By.xpath(xpathValue))).selectByVisibleText(value);
			reportStep("The visible text :"+value+" of dropdown element with xpathValue: "+xpathValue+" is selected successfully", "PASS");
		} catch(NoSuchElementException e){
			reportStep("The dropdown element with xpathValue: "+xpathValue+" could not be found", "FAIL");
		} catch(WebDriverException e){
			reportStep("WebdriverException occured while selecting the index in dropdown element with xpathValue: "+xpathValue, "FAIL");
		} catch(Exception e){
			reportStep("Unknown exception occured while selectiong the index in dropdown element with xpathValue"+xpathValue, "FAIL");
		}
	}

	public void selectIndexByXpath(String xpathValue, String value) {
		try{
			new Select(driver.findElement(By.xpath(xpathValue))).selectByIndex(Integer.parseInt(value));
			reportStep("The index: "+value+" of dropdown element with xpathValue: "+xpathValue+"is selected successfully", "PASS");
		} catch(NoSuchElementException e){
			reportStep("The dropdown element with index: "+xpathValue+" could not be found", "FAIL");
		} catch(WebDriverException e){
			reportStep("WebdriverException occured while selecting the index in dropdown element with index: "+xpathValue, "FAIL");
		} catch(Exception e){
			reportStep("Unknown exception occured while selectiong the index in dropdown element with index"+xpathValue, "FAIL");
		}
	}

	public void switchToParentWindow() {
		try{
			Set<String> windowHandles = driver.getWindowHandles();
			for (String eachHandle : windowHandles) {
				driver.switchTo().window(eachHandle);
				break;
			} 
		} catch(NoSuchWindowException e){
			reportStep("Primary window does not exist", "FAIL");
		} catch(Exception e){
				reportStep("The window could not be switched to primary window","FAIL");
			}
		
		
	}

	public void switchToLastWindow() {
		try{
			Set<String> winHandles = driver.getWindowHandles();
			for(String eachHandle : winHandles){
				driver.switchTo().window(eachHandle);
			} 
		} catch(NoSuchWindowException e){
			reportStep("Primary window does not exist", "FAIL");
		} catch(Exception e){
				reportStep("The window cound not be switched to last window","FAIL");
			}
		}
	

	public void acceptAlert() {
		try{
			driver.switchTo().alert().accept();
		} catch(NoAlertPresentException e){
			reportStep("The alert does not exist", "FAIL");
		} catch(Exception e){
			reportStep("The alert could not be accepted", "FAIL");
		}
	}

	public void dismissAlert() {
		try{
			driver.switchTo().alert().dismiss();
		} catch(NoAlertPresentException e){
			reportStep("The alert doesnot exist", "FAIL");
		} catch(Exception e){
			reportStep("The alert could not be dismissed", "FAIL");
		}
		 
	}

	public String getAlertText() {
		String text = "";
		try{
			text = driver.switchTo().alert().getText();
		} catch(NoAlertPresentException e){
			reportStep("The alert does not exist", "FAIL");
		}
		return text;
	}

	public void closeBrowser() {
		try{
			driver.close();
		} catch(Exception e){
			reportStep("The Browser: "+driver.getCapabilities().getBrowserName()+ "could not be closed", "FAIL");
		}
		
	}

	public void quitBrowser() {
		try{
			driver.quit();
		} catch(Exception e){
			reportStep("The Browser: "+driver.getCapabilities().getBrowserName()+" could not be closed", "FAIL");
		}
		
	}

	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try{
		FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./Reports/images/"+number+".jpeg"));
		return number;
	} catch (WebDriverException e){
		reportStep("The browser has been closed", "FAIL");
	}catch(IOException e){
		reportStep("ScreenShot Could not be taken", "WARN");
	}
		return number;
	}
}
