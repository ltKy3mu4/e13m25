package ru.mpei.lec2.inheritance;

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
}
