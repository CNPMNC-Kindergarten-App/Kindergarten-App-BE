package app.mobile.BK_Kindergarten.attend;

import app.mobile.BK_Kindergarten.attend.dto.CreateAttendRequest;
import app.mobile.BK_Kindergarten.children.Children;
import app.mobile.BK_Kindergarten.children.ChildrenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

        // 2. Tạo bản ghi điểm danh mới
        Attend attend = new Attend();
        attend.setChild(child);
        attend.setClassId(request.getClassId());

        // 3. Xử lý ngày: Nếu request không gửi ngày, lấy ngày hôm nay
        if (request.getDate() != null) {
            attend.setAttendDate(request.getDate());
        } else {
            attend.setAttendDate(LocalDate.now());
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
    public List<Attend> getChildHistory(Integer childId) {
        return attendRepository.findByChildId(childId);
    }
}