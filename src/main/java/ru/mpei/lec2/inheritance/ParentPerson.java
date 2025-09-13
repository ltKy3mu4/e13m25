package ru.mpei.lec2.inheritance;

public class ParentPerson {
    protected String firstName;
    protected String lastName;
    protected int age;

    public ParentPerson() {
    }

    public ParentPerson(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String printInfo(){
        return firstName + " " + lastName + " " + age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
