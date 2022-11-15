package test.Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class invalidLoginSteps {

    String site = "https://www.marketalertum.com/";
    final WebDriver driver = new ChromeDriver();

    @Given("^I am a user of marketalertum$")
    public void iAmAUserOfMarketalertum() {
        driver.get(site);
    }

    @When("I login using invalid credentials")
    public void iLoginUsingInvalidCredentials() {

        driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[3]/a")).click();
        driver.findElement(By.name("UserId")).sendKeys("incorrect-password");
        driver.findElement(By.name("UserId")).sendKeys(Keys.RETURN);
    }

    @Then("I should see the login screen again")
    public void iShouldSeeTheLoginScreenAgain() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl, "https://www.marketalertum.com/Alerts/Login");
    }
}
