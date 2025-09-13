package ru.mpei.lec2;

public class Person {

    private String firstName;
    private String lastName;
    private int age = 20;
    private boolean male;

    public Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.male = true;
    }

    public Person(String firstName, String lastName, int age, boolean male) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.male = male;
    }

    public boolean isNeedToRetire(){
        if (male){
            return age >= 65;
        } else {
            return age >= 60;
        }
    }


    public String getInfo(){
        String result = firstName + " " + lastName;
        return result;
    }

    public void setFirstName(String val){
        firstName = val;
    }

    public void setLastName(String val){
        lastName = val;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return male;
    }
}
