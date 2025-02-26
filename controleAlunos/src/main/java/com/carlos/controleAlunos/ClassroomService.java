package com.carlos.controleAlunos;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClassroomService {

    List<Classroom> classrooms = new ArrayList<>();
    AtomicLong registration = new AtomicLong(100);

    public Classroom newClassroom(Classroom classroom) throws Exception {
        if (this.isClassroomExists(classroom.getName())) {
            throw new Exception("Sala de aula já cadastrada");
        }
        classrooms.add(classroom);
        return classroom;
    }

    private Boolean isClassroomExists(String classroomName) {
        return this.classrooms.stream().anyMatch(c -> c.getName().equals(classroomName));
    }

    public Student newStudent(String classroomName, Student student) throws Exception {
        student.setRegistration(this.registration.incrementAndGet());
        for (Classroom cl : this.classrooms) {
            if (cl.getName().equals(classroomName)) {
                cl.addStudent(student);
                break;
            }
        }

        return student;
    }

    public Student recordGrade(String classroomName, Long registration, Double grade) throws Exception {
        Student studentAux = null;

        for (Classroom classroom : this.classrooms) {
            if (classroom.getName().equals(classroomName)) {
                for (Student student : classroom.getStudents()) {
                    if (student.getRegistration().equals(registration)) {
                        student.addGrade(grade);
                        studentAux = student;
                        break;
                    }
                }
                break;
            }
        }

        return studentAux;
    }

    public Double studentAverage(String classroomName, Long registration) throws Exception {
        Double average = 0.0;

        for (Classroom classroom : this.classrooms) {
            if (classroom.getName().equals(classroomName)) {
                for (Student student : classroom.getStudents()) {
                    if (student.getRegistration().equals(registration)) {
                        average = student.getAverageGrade();
                        break;
                    }
                }
                break;
            }
        }

        return average;
    }

    public List<Student> findStudentsByClassroom(String classroomName) throws Exception {
        return this.findByClassroom(classroomName).getStudents();
    }

    private Classroom findByClassroom(String classroomName) {
        return this.classrooms.stream().filter(c -> c.getName().equals(classroomName)).findFirst().get();
    }
}

