package app.mobile.BK_Kindergarten.children.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CreateChildrenRequest {
    private String name;
    private String sex;
    private LocalDate dob;
    private String habit;
    private String character;
    private String allergy;
    private String medical_issue;
    private String medical_history;
    private String health_status;
    private Integer parent_id;
}