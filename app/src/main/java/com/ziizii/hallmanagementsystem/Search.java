package com.ziizii.hallmanagementsystem;

import com.ziizii.hallmanagementsystem.DataBaseManager.Day;
import com.ziizii.hallmanagementsystem.DataBaseManager.Hall;
import com.ziizii.hallmanagementsystem.DataBaseManager.Slot;

import java.util.ArrayList;

public class Search {
    static Day[] days = new Day[7];
    static ArrayList<Hall> emptyHalls = new ArrayList<>();
    static ArrayList<Slot> emptySlots = new ArrayList<>();
    static ArrayList<Day> emptyDays = new ArrayList<>();
    static ArrayList<Slot> courseSlots = new ArrayList<>();


    public static void setDays(Day[] days) {
        Search.days = days;
    }

    public static void test(){
        Day day = new Day("Saturday");
        day.setHall(0,new Hall("914<3"));
        day.getHalls()[0].setSlot(0,new Slot(0,true,"CSE129",true));
        days[0]=day;

    }

    public static void searchByDay(int  dayNo) {
        ArrayList<Hall> halls = new ArrayList<>();
        ArrayList<Slot> slots = new ArrayList<>();
        for (Hall hall : days[dayNo].getHalls()) {
            for (Slot slot : hall.getSlots()) {
                if (slot.isEmpty()) {
                    slots.add(slot);
                    halls.add(hall);
                }
            }
        }
        setEmptySlots(slots);
        setEmptyHalls(halls);
    }

    public static void searchBySlot(int slotNo) {
        ArrayList<Hall> halls = new ArrayList<>();
        ArrayList<Day> days = new ArrayList<>();

        for (Day day : days) {
            for (Hall hall : day.getHalls()) {
                if (hall.getSlots()[slotNo].isEmpty()) {
                    halls.add(hall);
                    days.add(day);
                }
            }
        }
        setEmptyHalls(halls);
        setEmptyDays(days);
    }

    public static void searchByDayAndSlot(int dayNo,int slotNo) {
        ArrayList<Hall> halls = new ArrayList<>();
        ArrayList<Slot> slots = new ArrayList<>();

        for (Hall hall : days[0].getHalls()) {
            if (hall.getSlots()[slotNo].isEmpty()) {
                halls.add(hall);
                slots.add(hall.getSlots()[slotNo]);

            }
        }
        setEmptySlots(slots);
        setEmptyHalls(halls);
    }

    public static void searchByCourse(String courseCode) {
        ArrayList<Slot> slots = new ArrayList<>();
        ArrayList<Hall> halls = new ArrayList<>();


        for (Day day : days) {
            if(day==null)
                continue;
            for (Hall hall : day.getHalls()) {
                for (Slot slot: hall.getSlots()){
                    if(slot.getCourseCode().equals(courseCode)){
                        slots.add(slot);
                        halls.add(hall);
                    }
                }
            }
        }
        setEmptyHalls(halls);
        setCourseSlots(slots);
    }






    private static void setEmptyHalls(ArrayList<Hall> emptyHalls) {
        Search.emptyHalls = emptyHalls;
    }

    private static void setEmptySlots(ArrayList<Slot> emptySlots) {
        Search.emptySlots = emptySlots;
    }

    public static void setEmptyDays(ArrayList<Day> emptyDays) {
        Search.emptyDays = emptyDays;

    }
    public static void setCourseSlots(ArrayList<Slot> courseSlots) {
        Search.courseSlots = courseSlots;
    }

    public static ArrayList<Hall> getEmptyHalls() {
        return emptyHalls;
    }

    public static ArrayList<Slot> getEmptySlots() {
        return emptySlots;
    }

    public static ArrayList<Day> getEmptyDays() {
        return emptyDays;
    }

    public static ArrayList<Slot> getCourseSlots() {
        return courseSlots;
    }

}
