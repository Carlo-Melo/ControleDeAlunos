package com.carlos.controleAlunos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @PostMapping
    public Classroom newClassroom(@RequestBody Classroom classroom) throws Exception {
        return this.classroomService.newClassroom(classroom);
    }

    @PostMapping("/{classroom}/student")
    public Student newStudent(@RequestBody Student student, @PathVariable String classroom) throws Exception {
        return this.classroomService.newStudent(classroom, student);
    }

    @PostMapping("/{classroom}/{registration}/grade")
    public Student recordGrades(@PathVariable String classroom,
                                @PathVariable Long registration,
                                @RequestBody double grade) throws Exception {
        return this.classroomService.recordGrade(classroom, registration, grade);
    }

    @GetMapping("/{classroom}/{registration}")
    public Double studentAverage(@PathVariable String classroom,
                                 @PathVariable Long registration) throws Exception {
        return this.classroomService.studentAverage(classroom, registration);
    }

    @GetMapping("/{classroom}")
    public List<Student> findStudentsByClassroom(@PathVariable String classroom) throws Exception {
        return this.classroomService.findStudentsByClassroom(classroom);
    }
}

