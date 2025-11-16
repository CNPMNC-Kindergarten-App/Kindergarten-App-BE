package app.mobile.BK_Kindergarten.children;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name =  "children")
@Data
public class Children {

    @Id
    @Column(name = "child_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private  String name;

    @Column(name = "sex")
    private  String sex;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "habit")
    private String habit;

    @Column(name = "`character`")
    private String character;

//    @OneToOne()
//    @JoinColumn(name = "parent_id")
//    private Parent parentId;

}
