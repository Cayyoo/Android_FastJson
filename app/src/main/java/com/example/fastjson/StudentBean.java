package com.example.fastjson;

/**
 * Created by Administrator on 2017/2/13.
 */
public class StudentBean {
    private int id;
    private String name;
    private int age;
    private boolean isMale;
    private int schoolId;

    public StudentBean() {
        super();
    }

    public StudentBean(int id, String name, int age, boolean isMale, int schoolId) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.schoolId = schoolId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "StudentBean [id=" + id + ", name=" + name + ", age=" + age
                + ", isMale=" + isMale + ", schoolId=" + schoolId + "]";
    }
}
