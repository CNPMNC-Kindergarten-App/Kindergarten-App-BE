package app.mobile.BK_Kindergarten.children;

// Thêm các import cần thiết
import app.mobile.BK_Kindergarten.children.dto.CreateChildrenRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Sửa: import *

import java.util.List;

@RestController()
@RequestMapping("/children") // API chung là /children
public class ChildrenController {
    private final ChildrenService childrenService;

    public ChildrenController(ChildrenService childrenService) {
        this.childrenService = childrenService;
    }

    // === THÊM API NÀY ===
    /**
     * API để tạo học sinh mới
     * POST /children
     */
    @PostMapping
    public ResponseEntity<Children> createChildren(@RequestBody CreateChildrenRequest request) {
        Children savedChildren = childrenService.createChildren(request);
        // Trả về 201 Created
        return new ResponseEntity<>(savedChildren, HttpStatus.CREATED);
    }
    // =====================

    /**
     * API lấy tất cả học sinh
     * GET /children/findAll
     */
    @GetMapping("/findAll")
    public List<Children> getAllChildren() {
        return this.childrenService.getAllChildren();
    }

    /**
     * API lấy học sinh theo ID
     * GET /children/{id}
     */
    @GetMapping("/{id}")
    public Children getChildren(@PathVariable Long id) {
        return this.childrenService.getChildrenById(id);
    }
}