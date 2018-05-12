package com.ziizii.hallmanagementsystem.DataBaseManager;

public class Slot
{
    private int slot;
    private boolean isEmpty, Lecture;
    private String courseNumber;


    public Slot(int slotPosition, boolean empty, String courseCode, boolean lecture)
    {
        this.slot = slotPosition;
        this.isEmpty = empty;
        this.courseNumber = courseCode;
        this.Lecture = lecture;
    }

    public int getSlotPosition()
    {
        return this.slot;
    }

    public boolean isEmpty()
    {
        return isEmpty;
    }

    public boolean isLecture()
    {
        return Lecture;
    }

    public String getCourseCode()
    {
        return courseNumber;
    }
}
