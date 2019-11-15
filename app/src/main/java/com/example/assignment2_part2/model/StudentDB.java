package com.example.assignment2_part2.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    private ArrayList<Student> mStudentList;

    public static StudentDB getInstance() {
        return ourInstance;
    }

    private StudentDB(){
        createStudentObjects();
    }

    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    public void addToStudentList(Student student)
    {
        StudentDB.getInstance().mStudentList.add(student);
    }

    protected void createStudentObjects() {

        Student student = new Student("Tony", "Do", "890507555");
        ArrayList<course> courses = new ArrayList<>();
        courses.add(new course("CPSC411", "A"));
        courses.add(new course("CPSC481", "B"));
        courses.add(new course("CPSC471", "A"));
        courses.add(new course("CPSC483", "B"));
        student.setCourses(courses);
        mStudentList = new ArrayList<Student>();
        mStudentList.add(student);


        student = new Student("Some", "Body", "890523128");
        courses = new ArrayList<>();
        courses.add(new course("BIO101", "A"));
        courses.add(new course("ECS275", "B"));
        student.setCourses(courses);
        mStudentList.add(student);



    }
}
