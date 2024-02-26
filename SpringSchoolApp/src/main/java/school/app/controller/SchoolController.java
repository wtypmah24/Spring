package school.app.controller;

import org.springframework.web.bind.annotation.*;
import school.app.dto.SchoolKidDto;
import school.app.service.SchoolService;

import java.util.List;

@RestController
@RequestMapping(path = "/school")
public class SchoolController {
    private final SchoolService service;

    public SchoolController(SchoolService service) {
        this.service = service;
    }

    @PostMapping("/students")
    public SchoolKidDto addSchoolkid(@RequestBody SchoolKidDto schoolKidDto) {
        return service.addSchoolkid(schoolKidDto);
    }

    @GetMapping("/students_by_name")
    public List<SchoolKidDto> getSchoolkid(
            @RequestParam(value = "full_name", required = false) String fullName,
            @RequestParam(value = "school_class", required = false) String schoolClass) {
        return service.read(fullName, schoolClass);
    }

    @GetMapping("/students")
    public List<SchoolKidDto> getAllSchoolKids() {
        return service.readAll();
    }

    @GetMapping("/students_by_class")
    public List<SchoolKidDto> getStudentsByClass(
            @RequestParam(value = "school_class", required = false) String schoolClass) {
        return service.readByClass(schoolClass);
    }
}
