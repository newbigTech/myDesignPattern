package com.ytc.testStr;

/**
 * Created by Administrator on 2017/9/6.
 */
public class Student {
    private Address address;

    private String stuName;

    private Integer age;

    public Address getAddress() {
        return address;
    }

    public Student() {
    }

    public Student(Student student) {
        this.address = (Address)student.address.clone();
        this.stuName = student.stuName;
        this.age = student.age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (address != null ? !address.equals(student.address) : student.address != null) return false;
        if (stuName != null ? !stuName.equals(student.stuName) : student.stuName != null) return false;
        return age != null ? age.equals(student.age) : student.age == null;
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (stuName != null ? stuName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}
