package app.mobile.BK_Kindergarten.attend;

import app.mobile.BK_Kindergarten.attend.dto.CreateAttendRequest;
import app.mobile.BK_Kindergarten.children.Children;
import app.mobile.BK_Kindergarten.children.ChildrenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendService {

    private final AttendRepository attendRepository;
    private final ChildrenRepository childrenRepository;

    public AttendService(AttendRepository attendRepository, ChildrenRepository childrenRepository) {
        this.attendRepository = attendRepository;
        this.childrenRepository = childrenRepository;
    }

    public Attend markAttendance(CreateAttendRequest request) {
        // 1. Kiểm tra xem học sinh có tồn tại không
        Children child = childrenRepository.findById(request.getChildId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy học sinh có ID: " + request.getChildId()));

        // 2. Xử lý ngày: Nếu request không gửi ngày, lấy ngày hôm nay
        LocalDate attendDate = request.getDate() != null ? request.getDate() : LocalDate.now();

        // 3. Kiểm tra xem đã có bản ghi điểm danh cho học sinh này vào ngày này chưa
        Optional<Attend> existingAttend = attendRepository.findByChildIdAndAttendDate(request.getChildId(), attendDate);

        Attend attend;
        if (existingAttend.isPresent()) {
            // Nếu đã tồn tại, cập nhật bản ghi cũ
            attend = existingAttend.get();
            attend.setStatus(request.getStatus());
        } else {
            // Nếu chưa tồn tại, tạo bản ghi mới
            attend = new Attend();
            attend.setChild(child);
            attend.setClassId(request.getClassId());
            attend.setStatus(request.getStatus());
            attend.setAttendDate(attendDate);
        }

        // 4. Lưu vào DB
        return attendRepository.save(attend);
    }

    // 1. Lấy danh sách điểm danh của lớp trong ngày
    public List<Attend> getClassAttendance(Integer classId, LocalDate date) {
        if (date == null) {
            date = LocalDate.now(); // Nếu không gửi ngày, mặc định lấy hôm nay
        }
        return attendRepository.findByClassIdAndAttendDate(classId, date);
    }

    // 2. Lấy lịch sử đi học của một học sinh
    public List<Attend> getChildHistory(Long childId) {
        return attendRepository.findByChildId(childId);
    }
}