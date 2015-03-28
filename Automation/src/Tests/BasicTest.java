package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import drivers.ChromeWebDriver;
import drivers.ExtendedRunner;
import drivers.FirefoxWebDriver;
import drivers.GenericWebDriver;

@RunWith(ExtendedRunner.class)
public class BasicTest {

	GenericWebDriver webDriver;

	@Before
	public void setup() throws Exception {

		String broswer = System.getProperty("browser");
		
		if(broswer.equals("chrome")){
			webDriver=new ChromeWebDriver();
		}
		else if(broswer.equals("firefox")){
			webDriver=new FirefoxWebDriver();
		}
		//if you are running the test on diffreent machine, chngae the ip here
		webDriver.init("http://localhost:5555");

	}

	@After
	public void tearDown() {
		webDriver.close();
	}

}
