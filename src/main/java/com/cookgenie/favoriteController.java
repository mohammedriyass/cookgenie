package com.cookgenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@Controller
public class favoriteController {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @PostMapping("/favorites/add")
    public String addFavorite(@RequestParam String mealName,
            @RequestParam String mealImage,
            @RequestParam String mealYoutube,
            Principal principal) {
        String username = principal.getName();

        if (!favoriteRepository.existsByUsernameAndMealName(username, mealName)) {
            Favorite favorite = new Favorite();

            favorite.setUsername(username);
            favorite.setMealName(mealName);
            favorite.setMealImage(mealImage);
            favorite.setMealYoutube(mealYoutube);
            favoriteRepository.save(favorite);
        }

        return "redirect:/favorites";
    }

    @GetMapping("/favorites")
    public String viewFavorites(Principal principal, Model model) {
        String username = principal.getName();
        List<Favorite> favorites = favoriteRepository.findByUsername(username);
        model.addAttribute("favorites", favorites);
        return "favorites";
    }

    @PostMapping("/favorites/remove")
    public String removeFavorite(@RequestParam Long id) {
        favoriteRepository.deleteById(id);
        return "redirect:/favorites";
    }

}
