package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By shopByCategory = By.cssSelector("#gh-shop-a");
	By cellPhoneAndAccessories = By.xpath("//a[contains(text(),'Cell phones & accessories')]");
	By verifyCellPhoneAndAccessories = By.xpath("//body/div[4]/div[2]/div[1]/nav[1]/ul[1]/li[3]/a[1]");
	By cellPhoneAndSmartPhone = By.linkText("Cell Phones & Smartphones");
	By verifyCellPhoneAndSmartPhone = By.xpath("//body[1]/div[4]/div[2]/div[1]/nav[1]/ul[1]/li[4]");
	By seeAllOption = By.xpath("//body[1]/div[4]/div[4]/div[3]/div[1]/section[1]/div[1]/div[2]/button[1]/span[1]");
	By selectScreenSizeOption = By
			.xpath("//body/div[@id='refineOverlay']/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[7]/span[1]");
	By screenSize = By.xpath("//span[contains(text(),'5.0 - 5.4 in')]");
	By selectPrize = By.cssSelector("#c3-mainPanel-price");
	By fromPriceAmount = By.xpath("//*[@id=\"c3-subPanel-_x-price-textrange\"]/div/div[1]/div/input");
	By toPriceAmount = By.xpath("//*[@id=\"c3-subPanel-_x-price-textrange\"]/div/div[2]/div/input");
	By itemLocation = By.cssSelector("#c3-mainPanel-location > span");
	By usOnlyLocation = By.xpath("//*[@id=\"c3-subPanel-location_Worldwide\"]/span/span");
	By applyBtn = By.xpath("//*[@id=\"x-overlay__form\"]/div[3]/div[2]/button");
	By appliedScreensize = By.xpath("//*[@id=\"c3-tray-4[0[0]]\"]");
	By appliedPrice = By.xpath("//*[@id=\"c3-tray-4[0[1]]\"]");
	By appliedLocation = By.xpath("//*[@id=\"c3-tray-4[0[2]]\"]");
	By selectedFilters = By.xpath("//body[1]/div[4]/div[4]/div[3]/section[1]/section[1]/ul[1]/li[1]/div[1]/button[1]");
	By selectedscreenSize = By.xpath(
			"//body[1]/div[4]/div[4]/div[3]/section[1]/section[1]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]");
	By selectedPrize = By.xpath(
			"//body[1]/div[4]/div[4]/div[3]/section[1]/section[1]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]");
	By selectedLocation = By.xpath(
			"//body[1]/div[4]/div[4]/div[3]/section[1]/section[1]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]");
	By searchBar = By.cssSelector("#gh-ac");
	By searchCategory = By.cssSelector("#gh-cat");
	By applyButton = By.cssSelector("#gh-btn");
	By firstSearchResultName = By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div/span/span");

	Logger log = Logger.getLogger(LandingPage.class);
	public String screensizeAppliedText;
	public String PriceAppliedText;
	public String ItemLocationAppliedText;
	public String searchKeyString;

	public void verifyLandingPage(String expectedLandingPageTitle) {
		log.info("Verifying the landing page title");
		Assert.assertEquals(expectedLandingPageTitle, driver.getTitle());
	}

	public void selectOnShopByCategory() {
		log.info("Select the Shop by category option");
		driver.findElement(shopByCategory).click();
	}

	public void selectOnCellPhoneAndAccessories() {
		log.info("Select the CellPhone and Accessories under electronics option");
		driver.findElement(cellPhoneAndAccessories).click();
		log.info("Verify is the CellPhone and Accessories option is selected");
		driver.findElement(verifyCellPhoneAndAccessories).isDisplayed();
	}

	public void selectCellPhoneAndSmartPhone() {
		log.info("Selecting the Cell Phone and SmartPhone Category on Navigation Section");
		driver.findElement(cellPhoneAndSmartPhone).click();
		driver.findElement(verifyCellPhoneAndSmartPhone).isDisplayed();
	}

	public void selectSeeAllOption() {
		log.info("Selecting the see All option");
		driver.findElement(seeAllOption).click();
	}

	public void selectFilters() {
		log.info("Selecting the screen size option");
		driver.findElement(selectScreenSizeOption).click();
		log.info("Selecting the screen size");
		driver.findElement(screenSize).click();
		log.info("Scroll down to select the prize and Item location");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.querySelector(\"#x-overlay__form > div.x-overlay__container > div.x-overlay__wrapper--left\").scrollTop=700");
		log.info("Selecting the prize from options");
		driver.findElement(selectPrize).click();
		log.info("Entering the from amount range to $1000");
		driver.findElement(fromPriceAmount).sendKeys("1000.00");
		log.info("Entering the from amount range to $2000");
		driver.findElement(toPriceAmount).sendKeys("2000.00");
		log.info("Selecting the Item location");
		driver.findElement(itemLocation).click();
		log.info("Selecting the World Wide Item location");
		driver.findElement(usOnlyLocation).click();
		screensizeAppliedText = driver.findElement(appliedScreensize).getText();
		PriceAppliedText = driver.findElement(appliedPrice).getText();
		ItemLocationAppliedText = driver.findElement(appliedLocation).getText();
		log.info("Applying all the filters");
		driver.findElement(applyBtn).click();
	}

	public void verifyIfAllFiltersApplied() {
		log.info("Select the selected filters to see the options");
		driver.findElement(selectedFilters).click();
		log.info("Verifying the screen size if the applied matches");
		Assert.assertTrue(driver.findElement(selectedscreenSize).getText().contains(screensizeAppliedText));
		log.info("Verifying the amount if the applied matches");
		Assert.assertTrue(driver.findElement(selectedPrize).getText().contains("Price: $1,000.00 to $2,000.00"));
		log.info("Verifying the location if the applied matches");
		Assert.assertTrue(driver.findElement(selectedLocation).getText().contains(ItemLocationAppliedText));
	}

	public void userEntersStringInSearchBar(String searchKey) {
		log.info("User enters the search Key in the search bar");
		driver.findElement(searchBar).sendKeys(searchKey);
		searchKeyString = searchKey;
	}

	public void selectCategoryBasedOnInput(String categoryType) {
		log.info("Click on category to display the categories");
		Select searchCategoryOptions = new Select(driver.findElement(searchCategory));
		searchCategoryOptions.selectByVisibleText(categoryType);
	}

	public void searchProduct() {
		log.info("Click on Search Button");
		driver.findElement(applyButton).click();
	}

	public void verifyFirstSearch() {
		log.info("Verifying the first search String");
		Assert.assertTrue(driver.findElement(firstSearchResultName).getText().contains(searchKeyString));
	}
}
