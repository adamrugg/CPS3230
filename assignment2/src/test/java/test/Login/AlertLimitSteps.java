package test.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertLimitSteps {


    String site = "https://www.marketalertum.com/";
    final WebDriver driver = new ChromeDriver();

    @Given("I am an administrator of the website and I upload more than 5 alerts")
    public void iAmAnAdministratorOfTheWebsiteAndIUploadMoreThanAlerts(int arg0) {
    }

   /* @Given("^I am a user of (.*)marketalertum$")
    public void iAmAUserOfMarketalertum() {
        driver.get(site);
    }*/

   /* @When("^I (.*)view a list of alerts$")
    public void iViewAListOfAlerts() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl, "https://www.marketalertum.com/Alerts/List");
    }*/

    @Then("I should see 5 alerts")
    public void iShouldSee5Alerts(int arg0) {
        int numOfAlerts = driver.findElements(By.tagName("table")).size();
        Assertions.assertEquals(numOfAlerts, 5);

    }
}
