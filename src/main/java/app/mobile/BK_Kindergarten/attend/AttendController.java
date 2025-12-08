package app.mobile.BK_Kindergarten.attend;

import app.mobile.BK_Kindergarten.attend.dto.CreateAttendRequest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attend")
public class AttendController {

    private final AttendService attendService;

    public AttendController(AttendService attendService) {
        this.attendService = attendService;
    }

    // API: Điểm danh
    // POST http://localhost:8080/api/attend
    @PostMapping
    public ResponseEntity<Attend> markAttendance(@RequestBody CreateAttendRequest request) {
        Attend savedAttend = attendService.markAttendance(request);
        return new ResponseEntity<>(savedAttend, HttpStatus.CREATED);
    }



    @GetMapping("/class")
    public ResponseEntity<List<Attend>> viewClassAttendance(
            @RequestParam Integer classId,
            @RequestParam(required = false) LocalDate date) {

        List<Attend> list = attendService.getClassAttendance(classId, date);
        return ResponseEntity.ok(list);
    }

    // ==========================================
    // API 2: Xem lịch sử của HỌC SINH (Cho Phụ huynh)
    // URL: GET http://localhost:8080/api/attend/child/1
    // ==========================================
    @GetMapping("/child/{childId}")
    public ResponseEntity<List<Attend>> viewChildHistory(@PathVariable Integer childId) {

        List<Attend> list = attendService.getChildHistory(childId);
        return ResponseEntity.ok(list);
    }
}