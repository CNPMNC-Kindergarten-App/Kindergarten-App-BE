package app.mobile.BK_Kindergarten.feed;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name =  "Feed")
@Data
public class Feed {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Type(JsonType.class)
    @Column(name = "image_url", columnDefinition = "json")
    private List<String> imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    public enum Category {
        ANNOUNCEMENT,
        EVENT
    }

    @Column(name = "content")
    private String content;

    @Column(name = "author")
    private String author;

    @Column(name = "textHtml")
    private String textHtml;

//    @Column(name = "published_at", updatable = false)
//    private Timestamp publishedAt;
//
//    @Column(name = "updated_at")
//    private Timestamp updatedAt;
}