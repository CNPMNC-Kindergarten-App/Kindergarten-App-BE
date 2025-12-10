package app.mobile.BK_Kindergarten.children;

import app.mobile.BK_Kindergarten.absence.Absence;
import app.mobile.BK_Kindergarten.absence.dto.AbsenceDto;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChildrenRepository extends JpaRepository<Children, Long> {
    List<Children> findAllByName(String name);

     @Query("SELECT c FROM Children c WHERE c.id = :childId")
     Children findChildrenById(@Param("childId") Long child_id);

    List<Children> findAllByParent_Id(Integer parentId);


    @EntityGraph(attributePaths = {"parent", "parent.user"})
    Optional<Children> findById(Long id);
}
