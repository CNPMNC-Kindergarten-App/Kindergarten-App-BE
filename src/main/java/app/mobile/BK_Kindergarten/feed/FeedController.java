package app.mobile.BK_Kindergarten.feed;

import app.mobile.BK_Kindergarten.feed.dto.createFeedDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/feed")
public class FeedController {
    private FeedService feedService;
    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @PostMapping("/create")
    public Feed createFeed(@RequestBody createFeedDto createdto) {

//        List<String> imageUrls = new ArrayList<>();
//        String uploadDir = "./uploads/images/";
//        if (images != null && images.length > 0) {
//
//            for (MultipartFile file : images) {
//                if (file != null && !file.isEmpty()) {
//                    String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
//                    Path filePath = Paths.get(uploadDir + fileName);
//                    Files.createDirectories(filePath.getParent());
//                    Files.write(filePath, file.getBytes());
//                    imageUrls.add(fileName);
//                }
//            }
//        }

//        createFeedDto creatDto = new createFeedDto(title, content, imageUrls, category, author, textHtml, exerpt, date, featured);

        return this.feedService.craetFeed(createdto);
    }


    @GetMapping("/findAll")
    public List<Feed> findAllFeed() {
        try {
            return this.feedService.findAllFeed();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/findByCategory")
    public List<Feed> findByCategory(@RequestParam("category") Feed.Category category) {
        try {
            return this.feedService.findFeedByCategory(category);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
