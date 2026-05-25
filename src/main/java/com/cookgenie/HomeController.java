package com.cookgenie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private static final String MEALDB_URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

    @GetMapping("/home")
    public String home(@RequestParam(required = false) String query, Model model) {
        if (query != null && !query.isEmpty()) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String response = restTemplate.getForObject(MEALDB_URL + query, String.class);

                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(response);
                JsonNode mealsNode = root.get("meals");

                if (mealsNode != null && mealsNode.isArray()) {
                    List<Map<String, String>> meals = new ArrayList<>();
                    for (JsonNode meal : mealsNode) {
                        Map<String, String> m = new HashMap<>();
                        m.put("name", meal.get("strMeal").asText());
                        m.put("image", meal.get("strMealThumb").asText());
                        m.put("category", meal.get("strCategory").asText());
                        m.put("area", meal.get("strArea").asText());
                        m.put("youtube", meal.get("strYoutube") != null ? meal.get("strYoutube").asText() : "");
                        meals.add(m);
                    }
                    model.addAttribute("meals", meals);
                } else {
                    model.addAttribute("noResults", true);
                }
            } catch (Exception e) {
                model.addAttribute("error", "Something went wrong!");
            }
            model.addAttribute("query", query);
        }
        return "home";
    }
}