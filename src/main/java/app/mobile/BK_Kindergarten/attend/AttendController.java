package app.mobile.BK_Kindergarten.attend;

import app.mobile.BK_Kindergarten.attend.dto.CreateAttendRequest;
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
}