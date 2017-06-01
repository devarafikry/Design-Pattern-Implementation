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
public abstract class Booking {
    String name;
    double price;
    int duration;
    boolean paid = false;

    
    public Booking(){
        
    }
    public Booking(String name,double price, int duration) {
        this.name = name;
        setPrice(duration*price);
        setDuration(duration);
    }
    
    protected void payBill(){
        setPaid(true);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public abstract void setDuration(int duration);

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
