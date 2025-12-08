package app.mobile.BK_Kindergarten.children;

import app.mobile.BK_Kindergarten.absence.Absence;
import app.mobile.BK_Kindergarten.absence.dto.AbsenceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildrenRepository extends JpaRepository<Children, Integer> {
    List<Children> findAllByName(String name);
}
