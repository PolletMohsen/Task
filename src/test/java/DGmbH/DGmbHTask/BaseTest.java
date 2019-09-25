package DGmbH.DGmbHTask;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public static AppiumDriver<MobileElement> driver;
	public static AppiumDriverLocalService service;
	static final int PORT = 4723;

	@BeforeSuite
	public void installApp() throws InterruptedException, UnknownHostException
	{
		//Start Appium Server 
		final String ip = startAppiumServer();

		if (service == null || !service.isRunning()) {
			throw new AppiumServerHasNotBeenStartedLocallyException
			("An appium server node is not started!");
		}
		
	
		File appFolder2 = new File("src");
		File appSrc = new File(appFolder2,"android-sample-app.apk");
        //File AppiumJS_main=new File(appFolder2,"main.js");
        
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP,appSrc.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		//cap.setCapability("autoGrantPermissions", "true");
		//cap.setCapability("autoAcceptAlerts", "true");
		 
		try {
			driver = new AndroidDriver<MobileElement>
			(new URL("http://" + ip + ":" + PORT + "/wd/hub"), cap);
			
		}
		catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	public static String startAppiumServer() throws UnknownHostException {
		 
		service = new AppiumServiceBuilder()
				.usingPort(PORT).build()
				;
		service.start();
		InetAddress inetAddress = InetAddress.getLocalHost();
		return inetAddress.getHostAddress();
	}

	@AfterSuite(groups= {"smoke"})
	public void closeServer() throws IOException
	{
		    
		if (service != null) {
			service.stop();
		}
	}


}
