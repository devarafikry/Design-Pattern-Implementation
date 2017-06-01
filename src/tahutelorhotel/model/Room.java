/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahutelorhotel.model;

/**
 *
 * @author Devara Fikry Akmal
 */
public class Room {
    String nama;
    int type;
    double price;

    public Room(String nama, int type, double price) {
        this.nama = nama;
        this.type = type;
        this.price = price;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
