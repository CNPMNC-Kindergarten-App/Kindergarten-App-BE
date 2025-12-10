package app.mobile.BK_Kindergarten.utils;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
// Add @CrossOrigin to ensure this specific controller also respects the frontend origin.
// Although configured globally in SecurityConfig, redundancy can be helpful here.
@CrossOrigin(origins = "http://localhost:5173")
public class DtoItemController {

    /**
     * Mock endpoint to return a list of items for the frontend.
     * Corresponds to the API call in the React ItemList component: GET /api/items
     * @return List of mock ItemDto objects
     */
    @GetMapping("/api/items")
    public List<DtoItem> getItems() {
        // Return a mock list of items matching the DTO structure.
        return Arrays.asList(
                new DtoItem(1L, "Milk"),
                new DtoItem(2L, "Bread"),
                new DtoItem(3L, "Apples"),
                new DtoItem(4L, "Pencils")
        );
    }
}