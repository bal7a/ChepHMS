package com.ziizii.hallmanagementsystem.DataBaseManager;

public class Slot
{
    private int slotPosition;
    private boolean empty, lecture;
    private String courseCode;


    public Slot(int slotPosition, boolean empty, String courseCode, boolean lecture)
    {
        this.slotPosition = slotPosition;
        this.empty = empty;
        this.courseCode = courseCode;
        this.lecture = lecture;
    }

    public boolean isEmpty()
    {
        return empty;
    }

    public boolean isLecture()
    {
        return lecture;
    }

    public String getCourseCode()
    {
        return courseCode;
    }
}
