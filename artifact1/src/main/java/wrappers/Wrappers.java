package wrappers;

public interface Wrappers {
	
//This method will launch the browser, maximize the browser, set the wait time for 30 seconds and load the URL 
	public void invokeApp(String browser, String URL);
	
//This method will enter the value to the text field using id attribute to locate
	public void enterById(String idValue, String data);
	
//This method will enter the value to the text field using xpath attribute to locate
	public void enterByXpath(String xpathValue, String data);
	
//This method will enter the value to the text field using name attribute to locate
	public void enterByName(String nameValue,String data);
	
//This method will enter the value to the text field using className attribute to locate
	public void  entertByClassName(String classValue, String data);
	
//This method will verify the title of the page
	public boolean verifyTitle(String title);
	
//This method will verify the given text using id attribute to locate
	public void verifyTextById(String idValue, String text);
	
//This method will verify the given text using Xpath attribute to locate
	public void verifyTextByXpath(String xpathValue, String text);
	
//This method will verify then given text using name attribute to locate
	public void verifyTextByName(String nameValue, String text);
	
//This method will verify the given text using class attribute to locate
	public void  verifyTextByClassName(String classValue, String text);
	
//This method will verify the given text using id attribute to locate
	public void verifyTextContainsById(String idValue, String text);
	
//This method will verify the given text using xpath attribute to locate
	public void verifyTextContainsByXpath(String xpathValue, String text);
	
//This method will verify the given text using name attribute to locate
	public void verifyTextContainsByName(String nameValue, String text);
	
//This method will verify the given text using class attribute to locate
	public void verifyTextContainsByClassName(String classNameValue, String text);
	
//This method eill click the element using id as locator
	public void clickById(String idValue);
	
//This method will click the element using xpath as locator
	public void clickbyXpath(String xpathValue);
	
//This method will click the element usilng Class a locator
	public void clickByClassName(String classNameValue);
	
//This method will click the element using linktext as locator
	public void clickByLinkText(String linkTextValue);
	
//This method will click the element using linktext without taking snap
	public void clickByLinkTextNoSnap(String linkTextValue);
	
//This method will get the text of the element using id as locator
	public String getTextById(String idValue);
	
//This method will get the text of the element using xpath as locator
	public String getTextByXpath(String xpathValue);
	
//This method will get the text of the element using class as locator
	public String getTextByClassName(String classNameValue);
	
//This method will get the text of the element using Name as locator
	public String getTextByName(String nameValue);
	
//This method will select the dropdown visibleText using id as locator
	public void selectVisibleTextById(String idValue, String value);
	
//This method will select dropdown index using id as locator
	public void selectIndexById(String idValue, String value);
	
//This method will select dropdown visibleText using xpath as loctor
	public void selectVisibleTextByXpath(String xpathValue, String value);
	
//This method will select dropdown index using xpath as locator
	public void selectIndexByXpath(String xpathValue, String value);
	
//This method will move the control to the parent window
	public void switchToParentWindow();
	
//This method will move the control tot he last window
	public void switchToLastWindow();
	
//This method will accept the alert
	public void acceptAlert();
	
//This method will dismiss the alert
	public void dismissAlert();
	
	
//This method will get the alert text
	public String getAlertText();
	
//This method will close the current browser window
	public void closeBrowser();
	
//This method will close all the browser windows
	public void quitBrowser();
	
	
}
