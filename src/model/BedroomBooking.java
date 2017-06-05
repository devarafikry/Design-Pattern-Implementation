/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Devara Fikry Akmal
 */
public class BedroomBooking extends Booking{

    public BedroomBooking(String name, double price, int duration) {
       super(name,price,duration);
    }

    @Override
    public void setDuration(int duration) {
        super.duration = duration;
    }
    
    
}
