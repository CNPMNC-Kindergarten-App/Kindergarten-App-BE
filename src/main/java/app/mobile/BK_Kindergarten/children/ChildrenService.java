package app.mobile.BK_Kindergarten.children;

// import app.mobile.BK_Kindergarten.children.dto.ChildrenResponse;
import app.mobile.BK_Kindergarten.children.dto.CreateChildrenRequest; // Import DTO
import app.mobile.BK_Kindergarten.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import app.mobile.BK_Kindergarten.parent.Parent; // Import Parent entity

import app.mobile.BK_Kindergarten.parent.ParentRepository;

import java.util.List;

@Service
public class ChildrenService {
    private final ChildrenRepository childrenRepository;
    private final ParentRepository parentRepository;

    public ChildrenService(ChildrenRepository childrenRepository, ParentRepository parentRepository) {
        this.childrenRepository = childrenRepository;
        this.parentRepository = parentRepository;
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
            newChildren.setAllergy(request.getAllergy());
            newChildren.setMedical_issue(request.getMedical_issue());
            newChildren.setMedical_history(request.getMedical_history());
            newChildren.setHealth_status(request.getHealth_status());
            // Thiết lập Parent nếu parent_id được cung cấp
            if (request.getParent_id() != null) {
                Parent parent = parentRepository.findById(Long.valueOf(request.getParent_id()))
                        .orElseThrow(() -> new ResourceNotFoundException("Parent not found with id " + request.getParent_id()));
                newChildren.setParent(parent);
            }

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
            // Lấy đối tượng Children từ database
            Children child = this.childrenRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Children not found with id " + id));

            // Xóa thông tin không cần thiết từ Parent -> User
            if (child.getParent() != null && child.getParent().getUser() != null) {
                child.getParent().getUser().setPassword(null); // Xóa password
                child.getParent().getUser().setRole(null);     // Xóa role
            }

            return child; // Trả về đối tượng đã chỉnh sửa
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // public ChildrenResponse getChildrenById(Long id) {
    //     try {
    //         // Lấy đối tượng Children từ database
    //         Children child = this.childrenRepository.findById(id)
    //                 .orElseThrow(() -> new ResourceNotFoundException("Children not found with id " + id));

    //         // Chuyển đổi sang DTO
    //         ChildrenResponse response = new ChildrenResponse();
    //         response.setId(child.getId());
    //         response.setName(child.getName());
    //         response.setSex(child.getSex());
    //         response.setDob(child.getDob() != null ? child.getDob().toString() : null);
    //         response.setHabit(child.getHabit());
    //         response.setCharacter(child.getCharacter());
    //         response.setAllergy(child.getAllergy());
    //         response.setMedical_issue(child.getMedical_issue());
    //         response.setMedical_history(child.getMedical_history());
    //         response.setHealth_status(child.getHealth_status());

    //         if (child.getParent() != null) {
    //             ChildrenResponse.ParentResponse parentResponse = new ChildrenResponse.ParentResponse();
    //             parentResponse.setId(child.getParent().getId());
    //             parentResponse.setUuid(child.getParent().getUuid());

    //             if (child.getParent().getUser() != null) {
    //                 ChildrenResponse.ParentResponse.UserResponse userResponse = new ChildrenResponse.ParentResponse.UserResponse();
    //                 userResponse.setUserId(child.getParent().getUser().getUserId());
    //                 userResponse.setName(child.getParent().getUser().getName());
    //                 userResponse.setEmail(child.getParent().getUser().getEmail());
    //                 userResponse.setPhone(child.getParent().getUser().getPhone());
    //                 userResponse.setAddress(child.getParent().getUser().getAddress());
    //                 parentResponse.setUser(userResponse);
    //             }

    //             response.setParent(parentResponse);
    //         }

    //         return response;
    //     } catch (Exception e) {
    //         throw new RuntimeException(e);
    //     }
    // }






    public List<Children> getChildrenByParentId (Integer id) {
        try {
            return this.childrenRepository.findAllByParent_Id(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
