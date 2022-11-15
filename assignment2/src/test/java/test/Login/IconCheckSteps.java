package test.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class IconCheckSteps {

    String site = "https://www.marketalertum.com/";
    final WebDriver driver = new ChromeDriver();

    @Given("I am an administrator of the website and I upload an alert of type <alert-type>")
    public void iAmAnAdministratorOfTheWebsiteAndIUploadAnAlertOfTypeAlertType() {
    }

   /* @Given("^I am a website user of marketalertum$")
    public void iAmAUserOfMarketalertum() {
        driver.get(site);
    }*/

  /*  @When("^I view a list(.*) of alerts$")
    public void iViewAListOfAlerts() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl, "https://www.marketalertum.com/Alerts/Lists");
    }*/

    @Then("I should see 1 alerts")
    public void iShouldSee1Alerts(int arg0) {
        WebElement element = (WebElement) driver.findElements(By.xpath("/html/body/div/main/table[1]/tbody"));
        int numOfAlerts = driver.findElements(By.tagName("table")).size();
        Assertions.assertEquals(numOfAlerts, 1);
    }

    @And("the icon displayed should be <icon file name>")
    public void theIconDisplayedShouldBeIconFileName() {
       List<WebElement> url = driver.findElements(By.tagName("src"));

//        Assertions.assertEquals(url, );
    }
}
