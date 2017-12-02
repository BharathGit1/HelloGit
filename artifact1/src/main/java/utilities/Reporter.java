package utilities;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporter {
	
	public ExtentTest test;
	public static ExtentReports extent;
	public String testCaseName, testCaseDescription, category, author;
	
	
	public void reportStep(String desc, String status)
	{
	
		long snapNumber = 1000000L;
		
		try{
			snapNumber = takeSnap();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	
			if (status.toUpperCase().equals("PASS")){
				test.log(LogStatus.PASS, desc+test.addScreenCapture("./Reports/images/"+snapNumber+".jpeg"));
			} else if(status.toUpperCase().equals("FAIL")){
				test.log(LogStatus.FAIL, desc+test.addScreenCapture("./Reports/images/"+snapNumber+".jpeg"));
				throw new RuntimeException("FALIED");
			} else if (status.toUpperCase().equals("INFO")){
				test.log(LogStatus.INFO,desc);
			} else if (status.toUpperCase().equals("WARN")){
				test.log(LogStatus.WARNING, desc+test.addScreenCapture("./Reports/Images"+snapNumber+".jpeg"));
			}
		
		}
		
	
	public abstract long takeSnap();
	
	public ExtentReports startResult(){
		extent = new ExtentReports("./Reports/Results.html", false);
		extent.loadConfig(new File("./src/main/resources/extent-config.xml"));
		return extent;
	}
	
	public ExtentTest startTestCase(String testCaseName, String testCaseDescription){
		test = extent.startTest(testCaseName, testCaseDescription);
		return test;
	}
	
	public void endResult(){
		extent.flush();
	}
	
	public void endTestCase(){
		extent.endTest(test);
	}
}


