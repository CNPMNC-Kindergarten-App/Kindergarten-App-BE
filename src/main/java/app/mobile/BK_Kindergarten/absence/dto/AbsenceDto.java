package app.mobile.BK_Kindergarten.absence.dto;

import app.mobile.BK_Kindergarten.absence.Absence;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AbsenceDto {
    private Long absenceId;
    private String reason;
    private String childName; // ví dụ lấy tên của Children
    private Absence.statusAbsence status;
}
