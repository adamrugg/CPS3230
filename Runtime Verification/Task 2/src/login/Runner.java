package login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Runner {
	

	//final WebDriver driver = new ChromeDriver();
	final String site = "https://www.marketalertum.com/";
	final String endpoint = "https://api.marketalertum.com/EventsLog/defd0362-b0f9-4f8a-85f9-c48be427ba5a";
	String userID;
	
	public void validLogin() throws IOException, ParseException {
		
	/*
		driver.get(site);
		driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[3]")).click(); // navigating to the login page
		driver.findElement(By.xpath("/html/body/div/main/form/input[1]")).sendKeys("defd0362-b0f9-4f8a-85f9-c48be427ba5a"); // inputting  user-id
		driver.findElement(By.xpath("/html/body/div/main/form/input[2]")).click(); // pressing login
		*/
		
		URL url = new URL(endpoint);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    StringBuffer response = new StringBuffer();
	    String line;
	    while ((line = reader.readLine()) != null) {
	      response.append(line);
	    }
	    reader.close();

//	    int eventLogType = 0;
//		JSONArray list = new JSONArray(response.toString());
//		
//
//	    for (int i = 0; i < list.size(); i++) {
//	    JSONObject event = (JSONObject) list.get(i);
//	    eventLogType = event.getInt("eventLogType");
//	    }
//
//	    if (eventLogType == 5) {
//	    	
//	      System.out.println("Valid login");
//	      
//	    }
	}
	
public void invalidLogin() throws IOException, ParseException {
		
	/*
		driver.get(site);
		driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[3]")).click(); // navigating to the login page
		driver.findElement(By.xpath("/html/body/div/main/form/input[1]")).sendKeys("not the user-id"); // inputting  inval user-id
		driver.findElement(By.xpath("/html/body/div/main/form/input[2]")).click(); // pressing login
		*/
		
		URL url = new URL(endpoint);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    StringBuffer response = new StringBuffer();
	    String line;
	    while ((line = reader.readLine()) != null) {
	      response.append(line);
	    }
	    reader.close();
	
	
	    int eventLogType = 0;
//		JSONArray list = new JSONArray(response.toString());
//	   
//	    for (int i = 0; i < list.size(); i++) {
//	    JSONObject event = (JSONObject) list.get(i);
//	    eventLogType = event.getInt("eventLogType");
//	    }
//
//		if (eventLogType != 5 || eventLogType != 6) {
//	      System.out.println("Invalid login");
//	    }
	}
		

	public void logOut() throws IOException, ParseException {
		
		/* driver.get(site);
		driver.findElement(By.xpath("/html/body/header/nav/div/div/ul/li[3]")).click(); // pressing log-out
		*/

		URL url = new URL(endpoint);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    StringBuffer response = new StringBuffer();
	    String line;
	    while ((line = reader.readLine()) != null) {
	      response.append(line);
	    }
	    reader.close();


	    int eventLogType = 0;
//		JSONArray list = new JSONArray(response.toString());
//	   
//	    for (int i = 0; i < list.size(); i++) {
//	    JSONObject event = (JSONObject) list.get(i);
//	    eventLogType = event.getInt("eventLogType");
//	    }
//
//	    // Check if the login was successful
//	    if (eventLogType == 6) {
//	    	System.out.println("User logged out");
//	    }
//	    
	  }
	
	public static void main(String[] args) throws IOException, ParseException {
		
		final Runner m = new Runner();
		m.invalidLogin();
		m.validLogin();
		m.logOut();
		
	}
}
