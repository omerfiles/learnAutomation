package drivers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Enums.ByTypes;

public abstract class GenericWebDriver {
	
	protected RemoteWebDriver webDriver;
	
	abstract public void init(String remoteUrl)
			throws Exception;
	
	public void openUrl(String url) {
		webDriver.get(url);
	}

	public void close() {
		webDriver.quit();

	}
	public WebElement waitForElement(String idValue, ByTypes byType,
			int timeout, boolean isElementMandatory, String message, int sleepMS)
			throws Exception {
		
		WebElement element = null;

		try {
			WebDriverWait wait = new WebDriverWait(webDriver, timeout, sleepMS);

			switch (byType) {
			case className:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.className(idValue)));
				element = webDriver.findElement(By.className(idValue));
				;
				break;
			case linkText:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.linkText(idValue)));
				element = webDriver.findElement(By.linkText(idValue));
				break;
			case id:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.id(idValue)));
				element = webDriver.findElement(By.id(idValue));
				;
				break;
			case name:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.name(idValue)));
				element = webDriver.findElement(By.name(idValue));
				;
				break;
			case partialLinkText:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.partialLinkText(idValue)));
				element = webDriver.findElement(By.partialLinkText(idValue));
				break;
			case xpath:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(idValue)));
				element = webDriver.findElement(By.xpath(idValue));
				break;
			}

		} catch (Exception e) {
			if (isElementMandatory == true) {
			}

		} finally {
			if (isElementMandatory == true && element == null) {
				Assert.fail("Element: " + idValue + " not found");
			}
			return element;
		}
	}

}
