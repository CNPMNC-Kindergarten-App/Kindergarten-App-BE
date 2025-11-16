package app.mobile.BK_Kindergarten.children;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/children")
public class ChildrenController {
    private final ChildrenService childrenService;
    public ChildrenController(ChildrenService childrenService) {
        this.childrenService = childrenService;
    }

    @GetMapping("/findAll")
    public List<Childeren> getAllChildren() {
        return  this.childrenService.getAllChildren();
    }

    @GetMapping("/{id}")
    public Childeren getChildren(@PathVariable Long  id) {
        return this.childrenService.getChildrenById(id);
    }
}
