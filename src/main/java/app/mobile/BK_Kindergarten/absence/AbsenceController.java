package app.mobile.BK_Kindergarten.absence;

import app.mobile.BK_Kindergarten.absence.dto.AbsenceDto;
import app.mobile.BK_Kindergarten.absence.dto.createAbsenceDto;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/absence")
public class AbsenceController {
    private final AbsenceService absenceService;
    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @PostMapping("/create")
    public Absence createAbsence(@RequestBody createAbsenceDto absenceCreateDto) {
        return this.absenceService.createAbsence(absenceCreateDto);
    }

    @GetMapping("/getAll")
    public List<AbsenceDto> getAllAbsences() {
        return  this.absenceService.getAllAbsences();
    }

    @GetMapping("/get/{absenceStatus}")
    public List<AbsenceDto> getAllAbsences(@PathVariable("absenceStatus") Absence.statusAbsence absenceStatus) {
        return  this.absenceService.getAbsencesByStatus(absenceStatus);
    }

    @GetMapping("/get")
    public List<AbsenceDto> getAllAbsences(@RequestParam(name = "child_id") Long childId) {
        return  this.absenceService.getAbsenceByChildId(childId);
    }

    @PutMapping("/accept/{id}")
    public Absence acceptAbsence(@PathVariable("id") Long absence_id) {

        return this.absenceService.acceptAbsence(absence_id);
    }


}
