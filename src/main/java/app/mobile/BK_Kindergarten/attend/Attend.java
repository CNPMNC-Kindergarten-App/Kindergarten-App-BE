package app.mobile.BK_Kindergarten.attend;

import app.mobile.BK_Kindergarten.children.Children;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "Attend")
@Data
public class Attend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attend_id")
    private Integer id;

    @Column(name = "class_id")
    private Integer classId;

    // QUAN HỆ: Nối với bảng Children
    @ManyToOne(fetch = FetchType.LAZY)
    // QUAN TRỌNG: columnDefinition="INT" để tránh lỗi
    @JoinColumn(name = "child_id", nullable = false, columnDefinition = "INT")
    private Children child;

    // BẮT BUỘC PHẢI CÓ: Ngày điểm danh (Để xem lại lịch sử)
    // Nếu bạn không muốn client gửi lên, có thể gán mặc định là ngày hiện tại
    @Column(name = "attend_date")
    private LocalDate attendDate;
}