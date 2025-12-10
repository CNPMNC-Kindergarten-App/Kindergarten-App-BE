package app.mobile.BK_Kindergarten.menu;

import app.mobile.BK_Kindergarten.dish.Dish;
import app.mobile.BK_Kindergarten.dish.DishRepository;
import app.mobile.BK_Kindergarten.menu.dto.AddDishToMenuRequest;
import app.mobile.BK_Kindergarten.menu.dto.AddNewDishRequest;
import app.mobile.BK_Kindergarten.menu.dto.CreateMenuRequest;
import app.mobile.BK_Kindergarten.menu.dto.MenuGroupResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final DishRepository dishRepository;

    public List<MenuGroupResponse> getAll() {
        List<Menu> menus = menuRepository.findAll();

        // group by menu_day
        Map<String, List<Menu>> grouped = menus.stream()
                .collect(Collectors.groupingBy(Menu::getMenuDay));

        // convert to list of MenuGroupResponse
        return grouped.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) // sort theo menu_day
                .map(entry -> new MenuGroupResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public Menu getMenu(int id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found"));
    }

    public Menu createMenu(CreateMenuRequest request) {
        Menu m = new Menu();
        m.setMeal(request.getMeal());
        m.setMenu_day(request.getMenu_day());
        return menuRepository.save(m);
    }

    public Dish addNewDish(AddNewDishRequest req) {
        Dish dish = new Dish();
        dish.setName(req.getDname());
        dish.setNutrients(req.getNutrients());
        dish.setAllergy(req.getAllergy());
        dish.setVitamin(0);
        dish.setFat(0);
        dish.setProtein(0);
        dish.setCarbohydrate(0);

        return dishRepository.save(dish);
    }

    public Menu addDishToMenu(int menuId, AddDishToMenuRequest req) {
        Menu menu = getMenu(menuId);

        Dish dish = dishRepository.findById(req.getDishId())
                .orElseThrow(() -> new RuntimeException("Dish not found"));

        menu.getDishes().add(dish);
        return menuRepository.save(menu);
    }

    public Menu removeDish(int menuId, int dishId) {
        Menu menu = getMenu(menuId);

        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new RuntimeException("Dish not found"));

        menu.getDishes().remove(dish);
        return menuRepository.save(menu);
    }
}
