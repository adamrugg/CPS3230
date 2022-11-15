package test.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class IconCheckSteps {

    String site = "https://www.marketalertum.com/";
    final WebDriver driver = new ChromeDriver();

    @Given("I am an administrator of the website and I upload an alert of type <alert-type>")
    public void iAmAnAdministratorOfTheWebsiteAndIUploadAnAlertOfTypeAlertType() throws IOException {

        ArrayList<String> alertData = new ArrayList<>();
        String alert = "{\n\"alertType\":" + 1 + ",\n\"heading\":" + "\"" + "Heading" + "\",\n\"description\":" + "\"" + "description" + "\",\n\"url\":" + "\"" + "google.com" + "\",\n\"imgUrl\":" + "\"" + "google.com" + "\",\n\"postedBy\":" + "\"defd0362-b0f9-4f8a-85f9-c48be427ba5a\"" + ",\n\"priceInCents\":" + "100" + "\n}";
        alertData.add(alert);

        URL url = new URL("https://api.marketalertum.com/Alert");

        for (String mockAlert : alertData) {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            byte[] out = mockAlert.getBytes(StandardCharsets.UTF_8);
            OutputStream outputStream = con.getOutputStream();
            outputStream.write(out);
            con.disconnect();
        }
    }

    @Given("^I am a website user of marketalertum$")
    public void iAmAUserOfMarketalertum() {
        driver.get(site);
    }

    @When("^I view alerts$")
    public void iViewAListOfAlerts() {
        driver.get(site);
        driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[3]/a")).click();
        driver.findElement(By.name("UserId")).sendKeys("defd0362-b0f9-4f8a-85f9-c48be427ba5a");
        driver.findElement(By.name("UserId")).sendKeys(Keys.RETURN);
    }

    @Then("I should see 1 alerts")
    public void iShouldSee1Alerts() {
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
