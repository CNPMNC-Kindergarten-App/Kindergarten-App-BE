package app.mobile.BK_Kindergarten.absence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
    // Tìm đơn nghỉ theo ID học sinh
    List<Absence> findByChildId(Integer childId);
}