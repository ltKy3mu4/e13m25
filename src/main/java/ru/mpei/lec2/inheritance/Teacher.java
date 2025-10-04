package ru.mpei.lec2.inheritance;

import java.util.Arrays;
import java.util.Objects;

public class Teacher extends ParentPerson implements Educatable {

    private String department;
    private String[] subjects;

    public Teacher(String firstName, String lastName, int age, String dep) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.department = dep;
    }

    @Override
    public String printInfo() {
        return age + " " + firstName + " " + lastName + " " + department;
    }

    @Override
    public String getUni(){
        return "Default Uni";
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(department, teacher.department) && Objects.deepEquals(subjects, teacher.subjects);
    }

    @Override
    public int hashCode() {
        int hashCode = super.lastName.hashCode()* 31 + firstName.hashCode() * 31 + super.age + 35 + department.hashCode() *12;
        for (String s: subjects){
            hashCode += s.hashCode() * 13;
        }
        return hashCode;
    }
}
