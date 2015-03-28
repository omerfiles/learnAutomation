package drivers;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxWebDriver extends GenericWebDriver {

	@Override
	public void init(String remoteUrl) throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		
		webDriver = new RemoteWebDriver(new URL(remoteUrl + "/wd/hub"),
				capabilities);

	}

}
