package app.mobile.BK_Kindergarten.children;

import app.mobile.BK_Kindergarten.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildrenService {
    private final  ChildrenRepository childrenRepository;

    public ChildrenService(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    public List<Children> getAllChildren() {
        try {
            return this.childrenRepository.findAll();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Children getChildrenById (Long id) {
        try {
            return this.childrenRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Children not found with id " + id));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
