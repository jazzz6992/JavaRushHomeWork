package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    String name;
    int age;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double avarageGrade) {
        for (Student st :
                students) {
            if (st.getAverageGrade() == avarageGrade) {
                return st;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double max = 0;
        for (Student st :
                students) {
            if (max < st.getAverageGrade()) {
                max = st.getAverageGrade();
            }
        }
        return getStudentWithAverageGrade(max);
    }

    public Student getStudentWithMinAverageGrade() {
        double min = students.get(0).getAverageGrade();
        for (Student st :
                students) {
            if (min > st.getAverageGrade()) {
                min = st.getAverageGrade();
            }
        }
        return getStudentWithAverageGrade(min);
    }

    public void expel(Student student) {
        students.remove(student);
    }
}
