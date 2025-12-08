package app.mobile.BK_Kindergarten.absence;

import app.mobile.BK_Kindergarten.children.Children;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "Absence")
@Data
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "absence_id")
    private Long absence_id;

    @Column(name = "reason")
    private String reason;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private statusAbsence status;

    public enum statusAbsence {
        ACCEPTED,
        WAITING,
    }

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Children children;

}
