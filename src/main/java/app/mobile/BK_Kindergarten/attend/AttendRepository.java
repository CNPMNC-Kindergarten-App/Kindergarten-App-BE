package app.mobile.BK_Kindergarten.attend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendRepository extends JpaRepository<Attend, Integer> {
    // Tìm điểm danh của 1 học sinh
    List<Attend> findByChildId(Integer childId);

    // Tìm điểm danh của 1 lớp trong 1 ngày cụ thể (dùng cho tính năng "Xem điểm danh")
    List<Attend> findByClassIdAndAttendDate(Integer classId, LocalDate attendDate);

    // Kiểm tra xem hôm nay bé này đã được điểm danh chưa (tránh trùng lặp)
    Optional<Attend> findByChildIdAndAttendDate(Integer childId, LocalDate attendDate);
}