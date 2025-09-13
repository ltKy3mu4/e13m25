package ru.mpei.lec2.inheritance;

public class Student extends ParentPerson implements Educatable{

    private String group;
    private double averageMark;

    public Student(String firstName, String lastName, int age, String group) {
        super(firstName, lastName, age);
        this.group = group;
    }

    @Override
    public String printInfo(){
        return super.printInfo() + " "+group + " "+averageMark;
    }

    @Override
    public String getUni(){
        return "Default Uni";
    }

    public boolean isGoodYoungStudent(){
        return averageMark >= 4.5 && this.age <= 20;
    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
}
