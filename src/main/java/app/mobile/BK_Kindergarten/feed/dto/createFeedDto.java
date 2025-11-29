package app.mobile.BK_Kindergarten.feed.dto;

import app.mobile.BK_Kindergarten.feed.Feed;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class createFeedDto {
    private String title;
    private String content;
    private List<String> image_urls;
    private Feed.Category category_feed;
    private String author;
    private  String textHtml;

}
