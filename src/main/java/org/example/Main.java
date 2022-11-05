package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Berlin", "London");
        map.put("London", "Kiev");
        map.put("Tokyo", "Seoul");
        map.put("Vien", "Toronto");
        map.put("Seoul", "Mumbai");
        map.put("Kiev", "Dresden");
        map.put("Mumbai", "Berlin");
        map.put("Paris", "Vien");

        findRoute(map);

    }

    public static void findRoute(Map<String, String> map) {
        HashSet<String> values = new HashSet<>(map.values());

        String nextCity;
        for (Map.Entry<String, String> data : map.entrySet()) {
            String key = data.getKey();
            if (!values.contains(key)) {
                LinkedList<OneTrip> trips = new LinkedList<>();
                nextCity = data.getValue();
                trips.add(new OneTrip(key, nextCity));

                while (map.containsKey(nextCity)) {
                    trips.add(new OneTrip(nextCity, map.get(nextCity)));
                    nextCity = map.get(nextCity);
                }
                System.out.println("The following route was found: ");
                print(trips);
                System.out.println();
            }
        }
    }

    public static void print(LinkedList<OneTrip> trips) {
        for (OneTrip trip : trips) {
            System.out.println(trip.getDepartureCity() + " > " + trip.getArrivalCity());
        }
    }
}