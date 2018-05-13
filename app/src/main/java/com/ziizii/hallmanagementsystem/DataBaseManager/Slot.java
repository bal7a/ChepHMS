package com.ziizii.hallmanagementsystem.DataBaseManager;

import android.os.Parcel;
import android.os.Parcelable;

public class Slot implements Parcelable
{
    private int slot;
    private boolean isEmpty, Lecture;
    private String courseNumber;
    private Hall hall;


    public Slot(int slotPosition, boolean empty, String courseCode, boolean lecture)
    {
        this.slot = slotPosition;
        this.isEmpty = empty;
        this.courseNumber = courseCode;
        this.Lecture = lecture;
    }

    public void reserveSlot(String courseCode,boolean lecture)
    {
        if(isEmpty) {
            this.courseNumber = courseCode;
            this.Lecture = lecture;
            this.isEmpty = false;
        }
    }

    protected Slot(Parcel in) {
        slot = in.readInt();
        isEmpty = in.readByte() != 0;
        Lecture = in.readByte() != 0;
        courseNumber = in.readString();
    }

    public static final Creator<Slot> CREATOR = new Creator<Slot>() {
        @Override
        public Slot createFromParcel(Parcel in) {
            return new Slot(in);
        }

        @Override
        public Slot[] newArray(int size) {
            return new Slot[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(slot);
        parcel.writeByte((byte) (isEmpty ? 1 : 0));
        parcel.writeByte((byte) (Lecture ? 1 : 0));
        parcel.writeString(courseNumber);
    }

    @Override
    public String toString() {
        return "Hall "+"914";
    }

//    public void injectHall(Hall hall) {
//        this.hall = hall;
//    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
