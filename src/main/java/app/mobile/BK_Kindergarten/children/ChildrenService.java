package app.mobile.BK_Kindergarten.children;

import app.mobile.BK_Kindergarten.children.dto.CreateChildrenRequest; // Import DTO
import app.mobile.BK_Kindergarten.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildrenService {
    private final ChildrenRepository childrenRepository;

    public ChildrenService(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    // === THÊM PHƯƠNG THỨC NÀY ===
    public Children createChildren(CreateChildrenRequest request) {
        try {
            // 1. Chuyển đổi từ DTO (Request) sang Entity (Children)
            Children newChildren = new Children();
            newChildren.setName(request.getName());
            newChildren.setSex(request.getSex());
            newChildren.setDob(request.getDob());
            newChildren.setHabit(request.getHabit());
            newChildren.setCharacter(request.getCharacter());

            // 2. Lưu vào database và trả về
            return childrenRepository.save(newChildren);
        } catch (Exception e) {
            // Cân nhắc log lỗi ở đây
            throw new RuntimeException("Error while creating children: " + e.getMessage(), e);
        }
    }
    // ==============================

    public List<Children> getAllChildren() {
        try {
            return this.childrenRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Children getChildrenById(Long id) {
        try {
            return this.childrenRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Children not found with id " + id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Children> getChildrenByParentId (Long id) {
        try {
            return this.childrenRepository.findAllByparentId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Children> getChildrenByParentId (int id) {
        try {
            return this.childrenRepository.findAllByparentId(id);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
