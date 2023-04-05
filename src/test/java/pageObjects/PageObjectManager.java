package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.GenericUtils;

public class PageObjectManager {

	public LandingPage landingPage;
	public WebDriver driver;
	public GenericUtils genericUtils;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}

	public GenericUtils getGenericUtils() {
		genericUtils = new GenericUtils(driver);
		return genericUtils;
	}

}
