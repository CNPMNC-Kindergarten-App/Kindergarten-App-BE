package app.mobile.BK_Kindergarten.menu;

import app.mobile.BK_Kindergarten.dish.Dish;
import app.mobile.BK_Kindergarten.dish.DishRepository;
import app.mobile.BK_Kindergarten.menu.dto.AddDishToMenuRequest;
import app.mobile.BK_Kindergarten.menu.dto.CreateMenuRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final DishRepository dishRepository;

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    public Menu getMenu(int id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found"));
    }

    public Menu createMenu(CreateMenuRequest request) {
        Menu m = new Menu();
        m.setMeal(request.getMeal());
        return menuRepository.save(m);
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
