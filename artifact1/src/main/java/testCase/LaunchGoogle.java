package testCase;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrappers;

public class LaunchGoogle extends ProjectWrappers {

	public LaunchGoogle(RemoteWebDriver dr, ExtentTest Frt) {
		super(dr, Frt);
		this.driver=driver;
		this.Frt=Frt;
	
		// TODO Auto-generated constructor stub
	}
	
	

}
