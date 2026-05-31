package com.cookgenie;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String mealName;
    private String mealImage;
    private String mealYoutube;

}
