package org.sda.service;

import org.sda.entities.IssData;
import org.sda.entities.IssDataDao;
import org.sda.entities.IssSpeedDao;
import org.sda.util.HibernateUtil;
import org.sda.util.HttpUtil;
import org.sda.util.JsonUtil;

import java.net.http.HttpResponse;

public class PositionService {

    public static String calculateSpeed() throws Exception {
        IssData data1 = getIssData();
        Thread.sleep(3000);
        IssData data2 = getIssData();

        double distance = haversine(
                Double.parseDouble(data1.getIssPosition().getLatitude()),
                Double.parseDouble(data1.getIssPosition().getLongitude()),
                Double.parseDouble(data2.getIssPosition().getLatitude()),
                Double.parseDouble(data2.getIssPosition().getLongitude())
        );
        Double speed = calculateSpeed(distance, data2.getTimestamp() - data1.getTimestamp());
        HibernateUtil.save(new IssSpeedDao(data2.getTimestamp(), speed));
        return "Speed is: " + Math.round(speed) + " km/h";
    }

    private static IssData getIssData() {
        IssData data = new IssData();
        try {
            HttpResponse<String> response = HttpUtil.sendGetRequest("http://api.open-notify.org/iss-now.json");
            String json = response.body();
            data = JsonUtil.parseIssData(json);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return data;
    }

    private static double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the Earth in kilometers
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distance in kilometers
    }

    // Calculate speed based on distance and time difference
    private static double calculateSpeed(double distance, long timeDiffSeconds) {
        double timeDiffHours = timeDiffSeconds / 3600.0; // Convert seconds to hours
        return distance / timeDiffHours; // Speed in km/h
    }

    // show actual position method
    public static String showActualPosition(){
        IssData data = getIssData();
        HibernateUtil.save(new IssDataDao(data));
        return "Latitude: " + data.getIssPosition().getLatitude() +
                ", longitude: " + data.getIssPosition().getLongitude();
    }

}
