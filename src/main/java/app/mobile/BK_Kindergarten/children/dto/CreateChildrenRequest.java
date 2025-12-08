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
}