package drivers;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeWebDriver extends GenericWebDriver {

	@Override
	public void init(String remoteUrl) throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--start-maximized");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		webDriver = new RemoteWebDriver(new URL(remoteUrl + "/wd/hub"),
				capabilities);

	}

	

}
