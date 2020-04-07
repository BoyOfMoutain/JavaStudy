package com.boye.foundation;

public class Student {
    private String stuName;
    private int stuId;
    private String stuNumber;

    public Student() {
    }

    public Student(String stuName, int stuId, String stuNumber) {
        this.stuName = stuName;
        this.stuId = stuId;
        this.stuNumber = stuNumber;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", stuId=" + stuId +
                ", stuNumber='" + stuNumber + '\'' +
                '}';
    }
}
