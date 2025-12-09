package app.mobile.BK_Kindergarten.menu.dto;

import java.util.List;

import app.mobile.BK_Kindergarten.menu.Menu;

public class MenuGroupResponse {
    private String menuDay;
    private List<Menu> menus;

    public MenuGroupResponse(String menuDay, List<Menu> menus) {
        this.menuDay = menuDay;
        this.menus = menus;
    }

    public String getMenuDay() {
        return menuDay;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
