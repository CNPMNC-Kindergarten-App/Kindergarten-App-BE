package app.mobile.BK_Kindergarten.children;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/children")
public class ChildrenController {
    private final ChildrenService childrenService;
    public ChildrenController(ChildrenService childrenService) {
        this.childrenService = childrenService;
    }

    @GetMapping("/findAll")
    public List<Children> getAllChildren() {
        return  this.childrenService.getAllChildren();
    }

    @GetMapping("/{id}")
    public Children getChildren(@PathVariable Long  id) {
        return this.childrenService.getChildrenById(id);
    }

    @GetMapping()
    public List<Children> getChildrenByParentId(@RequestParam(name = "parent_id") int  id) {
        return this.childrenService.getChildrenByParentId(id);
    }
}
