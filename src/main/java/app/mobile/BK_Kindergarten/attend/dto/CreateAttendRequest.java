package app.mobile.BK_Kindergarten.attend.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CreateAttendRequest {
    private Integer childId;  // ID học sinh được điểm danh
    private Integer classId;  // ID lớp học
    private LocalDate date;   // Ngày điểm danh (nếu không gửi sẽ lấy ngày hiện tại)
}