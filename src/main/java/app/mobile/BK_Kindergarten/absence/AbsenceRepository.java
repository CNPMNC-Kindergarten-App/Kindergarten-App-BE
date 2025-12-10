package app.mobile.BK_Kindergarten.absence;

import app.mobile.BK_Kindergarten.absence.dto.AbsenceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    @Query("SELECT new app.mobile.BK_Kindergarten.absence.dto.AbsenceDto(a.id, a.reason, c.name, a.status, a.start_date, a.end_date) " +
            "FROM Absence a JOIN a.children c " +
            "WHERE a.id = :absenceId")
    AbsenceDto findAbsenceById(@Param("absenceId") Long absenceId);


    @Query("SELECT new app.mobile.BK_Kindergarten.absence.dto.AbsenceDto(a.id, a.reason, c.name, a.status, a.start_date, a.end_date) " +
            "FROM Absence a JOIN a.children c ")
    List<AbsenceDto> findAllAbsence();


    @Query("SELECT new app.mobile.BK_Kindergarten.absence.dto.AbsenceDto(a.id, a.reason, c.name, a.status, a.start_date, a.end_date) " +
            "FROM Absence a JOIN a.children c WHERE a.status = :status")
    List<AbsenceDto> findAbsenceByStatus(@Param("status") Absence.statusAbsence status);

    @Query("""
        SELECT new app.mobile.BK_Kindergarten.absence.dto.AbsenceDto(
            a.id,
            a.reason,
            c.name,
            a.status,
            a.start_date,
            a.end_date
        )
        FROM Absence a
        JOIN a.children c
        WHERE c.id = :childId
    """)
    List<AbsenceDto> findAbsenceByChildId(@Param("childId") Long childId);

}
