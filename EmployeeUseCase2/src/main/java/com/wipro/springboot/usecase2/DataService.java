package com.wipro.springboot.usecase2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataService {
    private final TreeMap<Integer, User> userTreeMap = new TreeMap<>();
    private final HashMap<Integer, User> userHashMap = new HashMap<>();

    // Populate TreeMap with sample data
    public DataService() {
        userTreeMap.put(3, new User(3, "Alice"));
        userTreeMap.put(1, new User(1, "Bob"));
        userTreeMap.put(2, new User(2, "Charlie"));
    }

    // Fetch data from TreeMap and store it in HashMap
    public void transferDataToHashMap() {
        userHashMap.clear();
        userHashMap.putAll(userTreeMap);
    }

    // Retrieve data from TreeMap (sorted)
    public Map<Integer, User> getTreeMapData() {
        return userTreeMap;
    }

    // Retrieve data from HashMap (unsorted)
    public Map<Integer, User> getHashMapData() {
        return userHashMap;
    }

    // Add new user to TreeMap
    public void addUser(int id, String name) {
        userTreeMap.put(id, new User(id, name));
    }
}