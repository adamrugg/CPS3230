package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class ScraperTests {

    @Test
    public void testScraperPopulated() {
        // Setup
        ScraperService service = new ScraperService();
        // Exercise
        final String site = "https://www.thomann.de/intl/search_dir.html?sw=baritone%20guitar&smcs=1a5a5c_1732";
        ArrayList<String> alertData = service.scrape(site);

        // Verify
        Assertions.assertEquals(5, alertData.size());

    }

    @Test
    public void testPostAlerts() throws IOException {
        // Setup
        ScraperService service = new ScraperService();
        final String site = "https://www.thomann.de/intl/search_dir.html?sw=baritone%20guitar&smcs=1a5a5c_1732";
        ArrayList<String> alertData = service.scrape(site);

        // Exercise

        ArrayList<Integer> responseCodes = service.postAlerts(alertData);

        //Verify
        ArrayList<Integer> response = new ArrayList<Integer>();
        response.add(201);
        response.add(201);
        response.add(201);
        response.add(201);
        response.add(201);
        Assertions.assertEquals(response, responseCodes);
    }

    @Test
    public void testGetAlerts() throws IOException {
        // Setup
        ScraperService service = new ScraperService();
        final String site = "https://www.thomann.de/intl/search_dir.html?sw=baritone%20guitar&smcs=1a5a5c_1732";
        ArrayList<String> alertData = service.scrape(site);

        // Exercise

        int responseCode = service.getAlerts();

        //Verify
        Assertions.assertEquals(200, responseCode);
    }

    @Test
    public void testDeleteAlerts() throws IOException {
        // Setup
        ScraperService service = new ScraperService();
        final String site = "https://www.thomann.de/intl/search_dir.html?sw=baritone%20guitar&smcs=1a5a5c_1732";
        ArrayList<String> alertData = service.scrape(site);


        // Exercise

        int responseCode = service.deleteAlerts();

        //Verify
        Assertions.assertEquals(200, responseCode);
    }
}


