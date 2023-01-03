package com.uom.cps3230.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginOperator {

    // final WebDriver driver = new ChromeDriver();
    final String site = "https://www.marketalertum.com/";
    final String endpoint = "https://api.marketalertum.com/EventsLog/defd0362-b0f9-4f8a-85f9-c48be427ba5a/login-status";

    private boolean loggedIn = false;

    boolean getLoggedIn() {
        return this.loggedIn;
    }

    public void validLogin() throws IOException {

//        driver.get(site);
//        driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[3]")).click(); // navigating to the login page
//        driver.findElement(By.xpath("/html/body/div/main/form/input[1]")).sendKeys("defd0362-b0f9-4f8a-85f9-c48be427ba5a"); // inputting  user-id
//        driver.findElement(By.xpath("/html/body/div/main/form/input[2]")).click(); // pressing login

        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        JsonObject json = (JsonObject) new JsonParser().parse(content.toString());

        if (json.get("isLoggedInOnWebsite").getAsBoolean() == true) {

            loggedIn = true;
            System.out.println("User is logged in.");

        }
    }



    public void invLogin() throws IOException {

//        driver.get(site);
//        driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[3]")).click(); // navigating to the login page
//        driver.findElement(By.xpath("/html/body/div/main/form/input[1]")).sendKeys("not the user-id"); // inputting  inval user-id
//        driver.findElement(By.xpath("/html/body/div/main/form/input[2]")).click(); // pressing login

        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        JsonObject json = (JsonObject) new JsonParser().parse(content.toString());

        if (json.get("isLoggedInOnWebsite").getAsBoolean() != true) {

            loggedIn = false;
            System.out.println("Invalid login");

        }
    }

    public void logOut() throws IOException {

        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        JsonObject json = (JsonObject) new JsonParser().parse(content.toString());

        if (json.get("isLoggedInOnWebsite").getAsBoolean() != true) {

            loggedIn = false;
            System.out.println("Logged out");
        }
    }
}
