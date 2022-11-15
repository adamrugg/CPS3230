package test.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertLayoutSteps {

    String site = "https://www.marketalertum.com/";
    final WebDriver driver = new ChromeDriver();

    @Given("I am an administrator of the website and I upload 3 alerts")

    public void iAmAnAdministratorOfTheWebsiteAndIUploadAlerts(int arg0) {
        String alert1;

        String alert2;

        String alert3;



    }

    @Given("^I use the website marketalertum$")
    public void iAmAUserOfMarketalertum() {
    }

  /*  @When("^I view a list (.*)of alerts$")
    public void iViewAListOfAlerts() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl, "https://www.marketalertum.com/Alerts/List");
    }*/

    @Then("each alert should contain an icon")
    public void eachAlertShouldContainAnIcon() {
        int numOfIcons = driver.findElements(By.tagName("src")).size();
        Assertions.assertEquals(numOfIcons, 3);
    }

    @And("each alert should contain a heading")
    public void eachAlertShouldContainAHeading() {
        int numOfHeadings = driver.findElements(By.tagName("h4")).size();
        Assertions.assertEquals(numOfHeadings, 3);
    }

    @And("each alert should contain a description")
    public void eachAlertShouldContainADescription() {
    }

    @And("each alert should contain an image")
    public void eachAlertShouldContainAnImage() {
    }

   /* @And("each alert should contain a price")
    public void eachAlertShouldContainAPrice() {
        int numOfPrices = driver.findElements(By.tagName("href")).size();
        Assertions.assertEquals(numOfLinks, 3);
    }*/

    @And("each alert should contain a link to the original product website")
    public void eachAlertShouldContainALinkToTheOriginalProductWebsite() {
        int numOfLinks = driver.findElements(By.tagName("href")).size();
        Assertions.assertEquals(numOfLinks, 3);
    }
}
