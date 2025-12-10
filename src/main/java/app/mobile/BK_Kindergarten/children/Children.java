package app.mobile.BK_Kindergarten.children;

import app.mobile.BK_Kindergarten.parent.Parent; // Import Parent entity
import jakarta.persistence.*; // Import JPA annotations
import lombok.Data;
import lombok.EqualsAndHashCode; // Import Lombok annotations
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name =  "Children")
@Data
public class Children {

    @Id
    @Column(name = "child_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private  String name;

    @Column(name = "sex")
    private  String sex;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "bedtime")
    private Time bedtime;

    @Column(name = "habit")
    private String habit;

    @Column(name = "`character`")
    private String character;



    @Column(name = "allergy")
    private String allergy;

    @Column(name = "medical_issue")
    private String medical_issue;

    @Column(name = "medical_history")
    private String medical_history;

    @Column(name = "health_status")
    private String health_status;


    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
}
