package app.mobile.BK_Kindergarten.absence;

import app.mobile.BK_Kindergarten.children.Children;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "Absence")
@Data
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "absence_id")
    private Integer id; // Dùng Integer

    @Column(name = "reason")
    private String reason;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "status", length = 50)
    private String status;

    // QUAN HỆ: Nối với bảng Children
    @ManyToOne(fetch = FetchType.LAZY)
    // QUAN TRỌNG: columnDefinition="INT" để tránh lỗi incompatible với bảng Children cũ
    @JoinColumn(name = "child_id", nullable = false, columnDefinition = "INT")
    private Children child;
}