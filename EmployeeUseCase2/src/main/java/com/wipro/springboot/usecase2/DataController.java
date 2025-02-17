package com.wipro.springboot.usecase2;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    // Get Data from TreeMap (sorted)
    @GetMapping("/treemap")
    public Map<Integer, User> getTreeMapData() {
        return dataService.getTreeMapData();
    }

    // Transfer Data from TreeMap to HashMap
    @PostMapping("/transfer")
    public String transferData() {
        dataService.transferDataToHashMap();
        return "Data transferred from TreeMap to HashMap!";
    }

    // Get Data from HashMap (unsorted)
    @GetMapping("/hashmap")
    public Map<Integer, User> getHashMapData() {
        return dataService.getHashMapData();
    }

    // Add a new user to TreeMap
    @PostMapping("/add")
    public String addUser(@RequestParam int id, @RequestParam String name) {
        dataService.addUser(id, name);
        return "User added successfully to TreeMap!";
    }
}