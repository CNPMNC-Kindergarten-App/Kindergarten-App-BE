package app.mobile.BK_Kindergarten.menu;

import app.mobile.BK_Kindergarten.menu.dto.AddDishToMenuRequest;
import app.mobile.BK_Kindergarten.menu.dto.CreateMenuRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping
    public Menu createMenu(@RequestBody CreateMenuRequest request) {
        return menuService.createMenu(request);
    }

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAll();
    }

    @GetMapping("/{id}")
    public Menu getMenuDetail(@PathVariable int id) {
        return menuService.getMenu(id);
    }

    @PostMapping("/{id}/dishes")
    public Menu addDishToMenu(
            @PathVariable int id,
            @RequestBody AddDishToMenuRequest request) {
        return menuService.addDishToMenu(id, request);
    }

    @DeleteMapping("/{id}/dishes/{dishId}")
    public Menu removeDishFromMenu(
            @PathVariable int id,
            @PathVariable int dishId) {
        return menuService.removeDish(id, dishId);
    }
}
