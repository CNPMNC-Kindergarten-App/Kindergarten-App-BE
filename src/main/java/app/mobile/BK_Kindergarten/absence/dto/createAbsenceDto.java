package app.mobile.BK_Kindergarten.absence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@AllArgsConstructor
@Data
public class createAbsenceDto {
    private String reason;
    private Date start_date;
    private Date end_date;
    private Long child_id;
}
