package org.sda.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sda.entities.IssData;
import org.sda.entities.IssPeopleInSpace;

public class JsonUtil {

    // Parse ISS data using Jackson
    public static IssData parseIssData(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, IssData.class);
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
            return null;
        }
    }

    public static IssPeopleInSpace parseIssPeopleInSpace(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, IssPeopleInSpace.class);
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
            return null;
        }
    }
}
