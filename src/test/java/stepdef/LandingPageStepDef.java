package stepdef;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.GenericUtils;
import utils.TestContextSetup;

public class LandingPageStepDef {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	GenericUtils genericUtils;
	Properties prop;

	public LandingPageStepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
		this.prop = testContextSetup.prop;
		this.genericUtils = testContextSetup.pageObjectManager.getGenericUtils();
	}

	@Given("User is on the eBay homepage")
	public void user_is_on_the_e_bay_homepage() {
		landingPage.verifyLandingPage(prop.getProperty("title"));
	}

	@When("User navigates to Search by category")
	public void user_navigates_to_search_by_category() {
		landingPage.selectOnShopByCategory();
	}

	@Then("User navigates CellPhone and Accesories under Electronics")
	public void user_navigates_cell_phone_and_accesories_under_electronics() {
		landingPage.selectOnCellPhoneAndAccessories();
		genericUtils.waitForPageToLoad();
	}

	@When("User navigates to CellPhone and SmartPhone under Navigation section")
	public void user_navigates_to_cell_phone_and_smart_phone_under_navigation_section() {
		landingPage.selectCellPhoneAndSmartPhone();
	}

	@Then("User navigates to See All section")
	public void user_navigates_to_see_all_section() {
		landingPage.selectSeeAllOption();
	}

	@When("User adds filters to Screen, Prize and Item location and Applies")
	public void user_adds_filters_to_screen_prize_and_item_location_and_applies() throws InterruptedException {
		landingPage.selectFilters();
	}

	@Then("User verifies if all the filters are applied")
	public void user_verifies_if_all_the_filters_are_applied() {
		landingPage.verifyIfAllFiltersApplied();
	}

	@When("User searches for {string}")
	public void user_searches_for(String searchKey) {
		landingPage.userEntersStringInSearchBar(searchKey);
	}

	@Then("User changes the search category to {string}")
	public void user_changes_the_search_category_to(String categoryOption) {
		landingPage.selectCategoryBasedOnInput(categoryOption);
	}

	@When("User searches for product")
	public void user_searches_for_product() {
		landingPage.searchProduct();
	}

	@Then("User verifies if the page is loaded completely")
	public void user_verifies_if_the_page_is_loaded_completely() {
		genericUtils.waitForPageToLoad();
	}

	@Then("User verifies if the search string matches the first result name")
	public void user_verifies_if_the_search_string_matches_the_first_result_name() {
		landingPage.verifyFirstSearch();
	}

}
