package app.mobile.BK_Kindergarten.children;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name =  "Children")
@Data
public class Children {

    @Id
    @Column(name = "child_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private  String name;

    @Column(name = "sex")
    private  String sex;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "habit")
    private String habit;

    @Column(name = "character")
    private String character;

//    @OneToOne()
//    @JoinColumn(name = "parent_id")
//    private Parent parentId;

}
