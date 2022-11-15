package service;

import org.json.simple.JSONArray;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ScraperClass {
    public static void main(String args[]) throws IOException, InterruptedException {
        final String site = "https://www.thomann.de/intl/search_dir.html?sw=baritone%20guitar&smcs=1a5a5c_1732";

        ScraperService scraper = new ScraperService();
        ArrayList<String> alertData = scraper.scrape(site);
        scraper.postAlerts(alertData);

    }

}
