package app.mobile.BK_Kindergarten.absence;

import app.mobile.BK_Kindergarten.absence.dto.AbsenceDto;
import app.mobile.BK_Kindergarten.absence.dto.createAbsenceDto;
import app.mobile.BK_Kindergarten.children.Children;
import app.mobile.BK_Kindergarten.children.ChildrenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AbsenceService {
    private final AbsenceRepository absenceRepository;
    private final ChildrenService childrenService;

    public AbsenceService(AbsenceRepository absenceRepository, ChildrenService childrenService) {
        this.absenceRepository = absenceRepository;
        this.childrenService = childrenService;
    }

    public Absence createAbsence(createAbsenceDto createDto) {
        try {

            Children childrenEntity = this.childrenService.getChildrenBasicById(createDto.getChild_id());

            Absence absenceEntity = new Absence();
            absenceEntity.setStatus(Absence.statusAbsence.WAITING);
            absenceEntity.setReason(createDto.getReason());
            absenceEntity.setStart_date(createDto.getStart_date());
            absenceEntity.setEnd_date(createDto.getEnd_date());
            absenceEntity.setChildren(childrenEntity);

            return absenceRepository.save(absenceEntity);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<AbsenceDto> getAllAbsences() {
        try {
            return absenceRepository.findAllAbsence();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<AbsenceDto> getAbsencesByStatus(Absence.statusAbsence status) {
        try {
            return absenceRepository.findAbsenceByStatus(status);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<AbsenceDto> getAbsenceByChildId(Long childId) {
        try {
            return absenceRepository.findAbsenceByChildId(childId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public Absence acceptAbsence(Long absenceId) {
        try {

            Absence absence = absenceRepository.findById(absenceId).orElseThrow(() -> new RuntimeException("Absence with id " + absenceId + " not found"));
            absence.setStatus(Absence.statusAbsence.ACCEPTED);
            return absence;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
