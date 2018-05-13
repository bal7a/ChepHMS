package com.ziizii.hallmanagementsystem.DataBaseManager;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class Hall implements Parcelable
{
    private Slot[] slots = new Slot[12];
    private String hallName;
//    private void injectSlots(){
//        for (Slot slot:
//             slots) {
//            slot.injectHall(this);
//        }
//    }
    public Hall(String hallName)
    {
        this.hallName = hallName;
    }

    public Hall(){}

    protected Hall(Parcel in) {
        slots = in.createTypedArray(Slot.CREATOR);
        hallName = in.readString();
    }

    public static final Creator<Hall> CREATOR = new Creator<Hall>() {
        @Override
        public Hall createFromParcel(Parcel in) {
            return new Hall(in);
        }

        @Override
        public Hall[] newArray(int size) {
            return new Hall[size];
        }
    };

    public String getHallName()
    {
        return hallName;
    }

    public Slot[] getSlots()
    {
        return slots;
    }

    public void setHallName(String hallName)
    {
        this.hallName = hallName;
    }

    public void setSlots(Slot[] slots)
    {
        this.slots = slots;
//        injectSlots();
    }

    public void setSlot(int i, Slot slot)
    {
        this.slots[i] = slot;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(slots, i);
        parcel.writeString(hallName);
    }

    @Override
    public String toString() {
        return getHallName();
    }
}
