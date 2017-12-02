package wrappers;


import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentTest;

public class ProjectWrappers extends GenericWrappers {

	public ProjectWrappers(RemoteWebDriver driver, ExtentTest test) {
		super(driver, test);
		// TODO Auto-generated constructor stub
	}
	
	public String browser;
	public String URL = "";
	
@BeforeSuite
	public void beforeSuite(){
	startResult();
}

@BeforeMethod
public void beforeMethod(){
	test = startTestCase(testCaseName,testCaseDescription);
	test.assignAuthor(author);
	test.assignCategory(category);
	invokeApp(browser,URL);
}

@AfterSuite
public void afterSuite(){
	endResult();
}

public void afterMethod(){
	endTestCase();
	quitBrowser();
}
	
}
