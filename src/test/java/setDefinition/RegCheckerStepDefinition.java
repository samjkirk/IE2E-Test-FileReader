package setDefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.qa.ie2etest.domain.Vehicle;
import com.qa.ie2etest.repository.FileRepositoryImpl;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.RegCheckerWebPage;
import Constants.Constants;

public class RegCheckerStepDefinition {
	private FileRepositoryImpl fileService = new FileRepositoryImpl();
	
	private RegCheckerWebPage webPage = new RegCheckerWebPage();
	
	private File vehicleInfo = new File(Constants.TEST_PATH + Constants.VEHICLE_DETAILS_FILE);
	
	@Given("^I have access to the spreadsheets that contain vehicle data$")
	public void i_have_access_to_the_spreadsheets_that_contain_vehicle_data() throws Throwable {
	    List<File> directory = fileService.getFilesFromDirectory(Constants.TEST_PATH);
	}
	
	@And("^I have access to the correct web page$")
	public void i_have_access_to_the_correct_web_page() throws Throwable {
	    webPage.startBrowser();
	    webPage.goToRegChecker();
	}

	@When("^I enter a valid reg number from the spreadsheet$")
	public void i_enter_a_valid_reg_number_from_the_spreadsheet() throws Throwable {
		ArrayList<Vehicle> list = new ArrayList<>();
		list = fileService.setVehicleInfo(vehicleInfo);
		String regNumber = list.get(0).getRegNumber();
		webPage.pressStartAndEnterRegNumber(regNumber);
	}

	@Then("^I am returned the correct details$")
	public void i_am_returned_the_correct_details() throws Throwable {
		Assert.assertEquals("MERCEDES-BENZ", webPage.getCarMake());
		Assert.assertEquals("GREY", webPage.getCarColour());
	}
	
	@And("^I can close down the browser$")
	public void i_can_close_down_the_browser() throws Throwable {
		webPage.shutDown();
	}
}
