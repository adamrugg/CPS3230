package test.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AlertLayoutSteps {

    String site = "https://www.marketalertum.com/";
    final WebDriver driver = new ChromeDriver();

    @Given("^I am an administrator of the website and I upload 3 alerts$")

    public void iAmAnAdministratorOfTheWebsiteAndIUpload3Alerts() throws IOException {
        ArrayList<String> alertData = new ArrayList<>();
        String alert = "{\n\"alertType\":" + 1 + ",\n\"heading\":" + "\"" + "Heading" + "\",\n\"description\":" + "\"" + "description" + "\",\n\"url\":" + "\"" + "google.com" + "\",\n\"imgUrl\":" + "\"" + "google.com" + "\",\n\"postedBy\":" + "\"defd0362-b0f9-4f8a-85f9-c48be427ba5a\"" + ",\n\"priceInCents\":" + "100" + "\n}";
        alertData.add(alert);

        String alert2 = "{\n\"alertType\":" + 1 + ",\n\"heading\":" + "\"" + "Heading" + "\",\n\"description\":" + "\"" + "description" + "\",\n\"url\":" + "\"" + "google.com" + "\",\n\"imgUrl\":" + "\"" + "google.com" + "\",\n\"postedBy\":" + "\"defd0362-b0f9-4f8a-85f9-c48be427ba5a\"" + ",\n\"priceInCents\":" + "100" + "\n}";
        alertData.add(alert2);

        String alert3 = "{\n\"alertType\":" + 1 + ",\n\"heading\":" + "\"" + "Heading" + "\",\n\"description\":" + "\"" + "description" + "\",\n\"url\":" + "\"" + "google.com" + "\",\n\"imgUrl\":" + "\"" + "google.com" + "\",\n\"postedBy\":" + "\"defd0362-b0f9-4f8a-85f9-c48be427ba5a\"" + ",\n\"priceInCents\":" + "100" + "\n}";
        alertData.add(alert3);

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

    @Given("^I use the website marketalertum$")
    public void iAmAUserOfMarketalertum() {
        driver.get(site);
    }

  @When("^A list of alerts is viewed$")
    public void iViewAListOfAlerts() {
      driver.get(site);
      driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[3]/a")).click();
      driver.findElement(By.name("UserId")).sendKeys("defd0362-b0f9-4f8a-85f9-c48be427ba5a");
      driver.findElement(By.name("UserId")).sendKeys(Keys.RETURN);
    }

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

    @And("each alert should contain a price")
    public void eachAlertShouldContainAPrice() {
        int numOfPrices = driver.findElements(By.xpath("/html/body/div/main/table[1]/tbody/tr[4]/td")).size();
        Assertions.assertEquals(numOfPrices, 3);
    }

    @And("each alert should contain a link to the original product website")
    public void eachAlertShouldContainALinkToTheOriginalProductWebsite() {
        int numOfLinks = driver.findElements(By.tagName("href")).size();
        Assertions.assertEquals(numOfLinks, 3);
    }
}
