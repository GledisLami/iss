package org.sda.service;

import org.sda.entities.IssPeopleDao;
import org.sda.entities.IssPeopleDetails;
import org.sda.entities.IssPeopleInSpace;
import org.sda.util.HibernateUtil;
import org.sda.util.HttpUtil;
import org.sda.util.JsonUtil;

import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PeopleService {
    // 1. show number of people in space
    public static String getNumberOfPeople() throws Exception {
        IssPeopleInSpace peopleInSpace = getIssPeopleInSpace();
        HibernateUtil.save(new IssPeopleDao(peopleInSpace.getNumber()));
        return "People in space: " + peopleInSpace.getNumber();
    }
    // 2. show names of people in space
    public static void showNamesOfPeople() throws Exception {
        IssPeopleInSpace peopleInSpace = getIssPeopleInSpace();

        System.out.println("People in space:");
        for (IssPeopleDetails astronaut : peopleInSpace.getPeople()){
            System.out.println(astronaut.getName());
        }
    }

    private static IssPeopleInSpace getIssPeopleInSpace() throws Exception {
        HttpResponse<String> response = HttpUtil.sendGetRequest("http://api.open-notify.org/astros.json");
        String json = response.body();
        IssPeopleInSpace peopleInSpace = JsonUtil.parseIssPeopleInSpace(json);
        return peopleInSpace;
    }

    // 3. show all different crafts in space
    public static void showNamesOfCrafts() throws Exception {
        IssPeopleInSpace peopleInSpace = getIssPeopleInSpace();

        System.out.println("Crafts in space: ");
        List<String> uniqueCrafts = peopleInSpace.getPeople().stream()
                .map(craft -> craft.getCraft())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueCrafts);
    }
}
