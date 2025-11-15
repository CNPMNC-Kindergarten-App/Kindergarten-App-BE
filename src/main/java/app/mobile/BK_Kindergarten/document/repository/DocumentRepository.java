package app.mobile.BK_Kindergarten.document.repository;

import app.mobile.BK_Kindergarten.document.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByUploadedByUserId(Long userId);
    List<Document> findByCategoryCategoryId(Long categoryId);
    List<Document> findByIsApproved(Boolean isApproved);
    List<Document> findByTitleContainingIgnoreCase(String title);
    List<Document> findByFileType(Document.FileType fileType);
}