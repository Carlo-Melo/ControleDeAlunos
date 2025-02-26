package com.carlos.controleAlunos;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Classroom {

    private String name;
    private List<Student> students = new ArrayList<>();

    public Classroom() {
    }

    public Classroom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return Objects.equals(name, classroom.name) && Objects.equals(students, classroom.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, students);
    }

    @Override
    public String toString() {
        return "Sala{" +
                "Nome='" + name + '\'' +
                ", Alunos=" + students +
                '}';
    }
}

