package app.mobile.BK_Kindergarten.parent;

import app.mobile.BK_Kindergarten.user.entity.User;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name =  "Parent")
@Data
public class Parent {
    @Id
    @Column(name = "parent_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid", insertable = false, updatable = false) // Prevent duplicate mapping
    private String uuid;

    @OneToOne
    @JoinColumn(name = "uuid", referencedColumnName = "uuid") // Foreign key to User table
    private User user;

}
