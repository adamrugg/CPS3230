package AlertView;

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

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class Runner {

	String endpoint = "https://api.marketalertum.com/EventsLog/defd0362-b0f9-4f8a-85f9-c48be427ba5a/";
	
	public void alertView() throws IOException {
		
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
		    
			int alertCount = 0;
		    int eventLogType = 9;
			JSONArray list = new JSONArray(response.toString());
		    
		    for (int i = 0; i < list.length(); i++) {
		    JSONObject event = (JSONObject) list.get(i);
		    eventLogType = event.getInt("eventLogType");
		    
			    if (eventLogType == 0) {
					alertCount = alertCount + 1;
				} else if (eventLogType == 1) {
					alertCount = alertCount - 1;
				}
			    
	    	}  
	    }


	public void invalidAlertView() throws IOException {
		
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
	    
		int alertCount = 0;
	    int eventLogType = 9;
		JSONArray list = new JSONArray(response.toString());
	    
	    for (int i = 0; i < list.length(); i++) {
	    JSONObject event = (JSONObject) list.get(i);
	    eventLogType = event.getInt("eventLogType");
	    
		    if (eventLogType == 0) {
			}
    	}  
    }

	
public static void main(String[] args) throws IOException, ParseException {
		
		final Runner m = new Runner();
		m.alertView();
		m.invalidAlertView();
	}
}
