package com.carlos.controleAlunos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements Serializable {

    private String name;
    private Long registration;
    private List<Double> grades = new ArrayList<>();

    public Student() {
    }

    public Student(String name, Long registration) {
        this.name = name;
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRegistration() {
        return registration;
    }

    public void setRegistration(Long registration) {
        this.registration = registration;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void addGrade(Double grade) {
        grades.add(grade);
    }

    public Double getAverageGrade(){
        return this.grades.isEmpty() ? 0 : this.calculateAverageGrade();
    }

    private Double calculateAverageGrade(){
        Double sum = 0D;

        for (Double grade : this.grades) {
            sum += grade;
        }

        return sum / this.grades.size();
    }

    public String getApprovalStatus(){
        return this.getAverageGrade() >= 6 ? "Aprovado" : "Reprovado";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(registration, student.registration) && Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, registration, grades);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "Nome='" + name + '\'' +
                ", Matricula='" + registration + '\'' +
                ", Notas=" + grades +
                '}';
    }
}

