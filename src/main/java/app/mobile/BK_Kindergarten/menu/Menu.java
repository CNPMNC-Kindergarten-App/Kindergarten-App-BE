package app.mobile.BK_Kindergarten.menu;

import app.mobile.BK_Kindergarten.dish.Dish;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Menu")
@Getter
@Setter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private int id;

    @Column(name = "meal")
    private String meal;

    @Column(name = "menu_day")
    private String menu_day;

    @ManyToMany
    @JoinTable(
            name = "Menu_Dish",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    @JsonManagedReference
    private Set<Dish> dishes = new HashSet<>();

    @JsonProperty("menu_day")
    public String getMenuDay() {
        return menu_day;
    }

}
