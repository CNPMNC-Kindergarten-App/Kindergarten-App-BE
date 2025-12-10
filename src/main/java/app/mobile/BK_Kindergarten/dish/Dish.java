package app.mobile.BK_Kindergarten.dish;

import app.mobile.BK_Kindergarten.menu.Menu;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Dish")
@Getter
@Setter
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private int id;

    @Column(name = "dname")
    private String name;

    @Column(name = "vitamin")
    private Integer vitamin;

    @Column(name = "fat")
    private Integer fat;

    @Column(name = "protein")
    private Integer protein;

    @Column(name = "carbohydrate")
    private Integer carbohydrate;

    @Column(name = "nutrients")
    private String nutrients;

    @Column(name = "allergy")
    private String allergy;

    @ManyToMany(mappedBy = "dishes")
    @JsonBackReference
    private Set<Menu> menus = new HashSet<>();
}
