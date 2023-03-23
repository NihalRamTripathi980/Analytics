package com.nihalramtripathi.analytics.recyclarStudents;

public class PositionModel {
    String StudentName , StudentPosition;

    public PositionModel() {
    }

    public PositionModel(String studentName, String studentPosition) {
        StudentName = studentName;
        StudentPosition = studentPosition;
    }


    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentPosition() {
        return StudentPosition;
    }

    public void setStudentPosition(String studentPosition) {
        StudentPosition = studentPosition;
    }
}
