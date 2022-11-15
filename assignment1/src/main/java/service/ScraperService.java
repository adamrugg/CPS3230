package service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ScraperService {
    public ArrayList<String> scrape(String site) {
        final WebDriver driver = new ChromeDriver();

        List titleList = new ArrayList<>();
        List descList = new ArrayList<>();
        List priceList = new ArrayList<>();
        List imgList = new ArrayList<>();
        List urlList = new ArrayList<>();

        ArrayList<String> alertData = new ArrayList<>();

        driver.get(site);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/button[1]/span")).click(); // accepts cookies

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        for (int i = 1; i <= 5; i++) {
            String manufacturerXpath = "/html/body/div[4]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div[" + i + "]/div/a[2]/div[1]/div[1]/span[1]";
            String titleXpath = "/html/body/div[4]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div[" + i + "]/div/a[2]/div[1]/div[1]/span[2]";

            titleList.add(i - 1, driver.findElement(By.xpath(manufacturerXpath)).getText() + " " + driver.findElement(By.xpath(titleXpath)).getText()); // title
            System.out.println(titleList.get(i - 1));

            String descXpath1 = "/html/body/div[4]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div[" + i + "]/div/a[2]/div[1]/div[3]/ul/li[1]/span";
            String descXpath2 = "/html/body/div[4]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div[" + i + "]/div/a[2]/div[1]/div[3]/ul/li[2]/span";
            String descXpath3 = "/html/body/div[4]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div[" + i + "]/div/a[2]/div[1]/div[3]/ul/li[3]/span";


            String description = driver.findElement(By.xpath(descXpath1)).getText() + " " + driver.findElement(By.xpath(descXpath2)).getText() + " " + driver.findElement(By.xpath(descXpath3)).getText();
            description = description.replace("\"", ""); // cleaning up inverted commas
            descList.add(i - 1, description); // description
            System.out.println(descList.get(i - 1));


            String priceXpath = "/html/body/div[4]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div[" + i + "]/div/a[2]/div[2]/div/span";
            String pr = driver.findElement(By.xpath(priceXpath)).getText();

            String price = pr.replace("€", ""); // cleaning up currency
            price = price.replace(",", "");
            int priceInt = Integer.parseInt(price);
            priceInt = priceInt * 100; //price conversion to cents
            priceList.add(i - 1, priceInt); // price
            System.out.println(priceList.get(i - 1));


            String urlXpath = "/html/body/div[4]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div[" + i + "]/div/a[2]";
            urlList.add(i - 1, driver.findElement(By.xpath(urlXpath)).getAttribute("href")); // URL
            System.out.println(urlList.get(i - 1));


            String imgXpath = "/html/body/div[4]/div/div[2]/div/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div[" + i + "]/div/a[1]/picture/img";
            imgList.add(i - 1, driver.findElement(By.xpath(imgXpath)).getAttribute("src")); // imageUrl
            System.out.println(imgList.get(i - 1));

            String alert = "{\n\"alertType\":" + 6 + ",\n\"heading\":" + "\"" + titleList.get(i - 1) + "\",\n\"description\":" + "\"" + descList.get(i - 1) + "\",\n\"url\":" + "\"" + urlList.get(i - 1) + "\",\n\"imgUrl\":" + "\"" + imgList.get(i - 1) + "\",\n\"postedBy\":" + "\"defd0362-b0f9-4f8a-85f9-c48be427ba5a\"" + ",\n\"priceInCents\":" + priceList.get(i - 1) + "\n}";
            alertData.add(alert);
        }
        System.out.println("alertdata: " + alertData); // test that alertdata works
        return alertData;
    }

    public ArrayList<Integer> postAlerts(ArrayList<String> alertData) throws IOException {
        URL url = new URL("https://api.marketalertum.com/Alert");
        ArrayList<Integer> responseCodeList = new ArrayList<>();

        for (String alert : alertData) {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            byte[] out = alert.getBytes(StandardCharsets.UTF_8);
            OutputStream outputStream = con.getOutputStream();
            outputStream.write(out);
            System.out.println(con.getResponseCode() + "" + con.getResponseMessage());
            responseCodeList.add(con.getResponseCode());
            con.disconnect();
        }
        return responseCodeList; // test: assertEqual(postRequestResponseCodes, [201, 201, 201, 201, 201])
    }

    public int getAlerts() throws IOException {
        int responseCode;
        URL url = new URL("https://api.marketalertum.com/Alert?userId=defd0362-b0f9-4f8a-85f9-c48be427ba5a");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        System.out.println(con.getResponseCode() + "" + con.getResponseMessage());
        responseCode = con.getResponseCode();
        con.disconnect();
        return responseCode; // successful GET request: 200 (test: assertEqual(responseCode, 200)
    }

    public int deleteAlerts() throws IOException {
        int responseCode;
        URL url = new URL("https://api.marketalertum.com/Alert?userId=defd0362-b0f9-4f8a-85f9-c48be427ba5a");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        System.out.println(con.getResponseCode() + "" + con.getResponseMessage());
        responseCode = con.getResponseCode();
        con.disconnect();
        return responseCode; // successful DELETE request: 200 (test: assertEqual(responseCode, 200)
    }


}

