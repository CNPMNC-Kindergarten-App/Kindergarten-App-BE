package app.mobile.BK_Kindergarten.feed;

import app.mobile.BK_Kindergarten.children.ChildrenRepository;
import app.mobile.BK_Kindergarten.feed.dto.createFeedDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedService {
    private final FeedRepository feedRepository;
    public FeedService(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public Feed craetFeed(createFeedDto createFeedDto)  {
        Feed feed = new Feed();
        feed.setTitle(createFeedDto.getTitle());
        feed.setContent(createFeedDto.getContent());
        feed.setCategory(createFeedDto.getCategory_feed());
        feed.setImageUrl(createFeedDto.getImage_urls());
        feed.setAuthor(createFeedDto.getAuthor());
        feed.setTextHtml(createFeedDto.getTextHtml());

        return this.feedRepository.save(feed);
    }

    public List<Feed> findAllFeed() {
        return this.feedRepository.findAll();
    }

    public List<Feed> findFeedByCategory(Feed.Category category) {
        return this.feedRepository.findFeedByCategory(category);
    }
}
