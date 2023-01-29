package com.example.projectsamsung;

public class Station {
   public int[] connected = new int[6];
    public int name;
    public int count_passenger;
    public double x;
    public double y;

    public Station(int name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
}
