package model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String nama;
    private int type;
    private double price;
    private List<Room> subordinates;


    public Room(String nama, int type, double price) {
        this.nama = nama;
        this.type = type;
        this.price = price;
        subordinates = new ArrayList<Room>();
    }
    public void add(Room e) {
      subordinates.add(e);
   }

   public void remove(Room e) {
      subordinates.remove(e);
   }

   public List<Room> getSubordinates(){
     return subordinates;
   }

   public String toString(){
        return (nama + "\t\t Rp. " + price + "0");
   }    
    public String getNama() {
        return nama;
    }

    public int getSize(){
        return subordinates.size();
    }
    
    public int getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    
}
