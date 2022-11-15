package test.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    String site = "https://www.marketalertum.com/";
    final WebDriver driver = new ChromeDriver();

    @Given("^I am a user$")
    public void iAmAUserOfMarketalertum() {
        driver.get(site);
    }

    @When("I login using valid credentials")
    public void iLoginUsingValidCredentials() {
        driver.get(site);
        driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[3]/a")).click();
        driver.findElement(By.name("UserId")).sendKeys("defd0362-b0f9-4f8a-85f9-c48be427ba5a");
        driver.findElement(By.name("UserId")).sendKeys(Keys.RETURN);
    }

    @Then("I should see my alerts")
    public void iShouldSeeMyAlerts() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl, "https://www.marketalertum.com/Alerts/List");
    }
}

