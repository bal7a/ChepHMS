package com.ziizii.hallmanagementsystem;

import com.ziizii.hallmanagementsystem.DataBaseManager.Day;
import com.ziizii.hallmanagementsystem.DataBaseManager.Hall;
import com.ziizii.hallmanagementsystem.DataBaseManager.Slot;

import java.util.ArrayList;

public class Search {
    static Day[] days = new Day[6];
    static ArrayList<Hall> emptyHalls = new ArrayList<>();
    static ArrayList<Slot> emptySlots = new ArrayList<>();
    static ArrayList<Day> emptyDays = new ArrayList<>();
    static ArrayList<Slot> courseSlots = new ArrayList<>();


    public static void setDays(Day[] days) {
        Search.days = days;
    }

    public static void searchByDay(Day day) {
        ArrayList<Hall> halls = new ArrayList<>();
        ArrayList<Slot> slots = new ArrayList<>();
        for (Hall hall : day.getHalls()) {
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

    public static void searchBySlot(Slot slot) {
        ArrayList<Hall> halls = new ArrayList<>();
        ArrayList<Day> days = new ArrayList<>();

        for (Day day : days) {
            for (Hall hall : day.getHalls()) {
                if (hall.getSlots()[slot.getSlotPosition() + 1].isEmpty()) {
                    halls.add(hall);
                    days.add(day);
                }
            }
        }
        setEmptyHalls(halls);
        setEmptyDays(days);
    }

    public static void searchByDayAndSlot(Day day,Slot slot) {
        ArrayList<Hall> halls = new ArrayList<>();

        for (Hall hall : day.getHalls()) {
            if (hall.getSlots()[slot.getSlotPosition() + 1].isEmpty()) {
                halls.add(hall);
            }
        }
        setEmptyHalls(halls);
    }

    public static void searchByCourse(String courseCode) {
        ArrayList<Slot> slots = new ArrayList<>();

        for (Day day : days) {
            for (Hall hall : day.getHalls()) {
                for (Slot slot: hall.getSlots()){
                    if(slot.getCourseCode().equals(courseCode)){
                        slots.add(slot);
                    }
                }
            }
        }
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
