package app.mobile.BK_Kindergarten.children;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.sql.Time;

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

    @JoinColumn(name = "parent_id")
    private int parent_id;

}