/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahutelorhotel.model.state;

import java.util.Scanner;
import tahutelorhotel.model.Booking;

/**
 *
 * @author Fikry-PC
 */
public class PaidState implements State {

    @Override
    public void checkBooking() {
        System.out.println("");
        System.out.println("Booking Details :");
        System.out.println("Name :"+booking.getName());
        System.out.println("Duration :"+booking.getDuration());
        System.out.println("Bill Status :"+"Paid");
        System.out.println("");
    }

    @Override
    public void payBill() {
        System.out.println("");
        System.out.println("You already paid this room.");
        System.out.println("");
    }

    @Override
    public void unlockRoom() {
        System.out.println("");
        System.out.println("You unlocked the room.");
        System.out.println("");
    }
    Booking booking;
    public PaidState(Booking booking){
        this.booking = booking;
    }
    
    public void printBill(){
        System.out.println("");
        System.out.println("Your bill of "+booking.getName()+" for "+booking.getDuration()+" days:");
        System.out.println("Rp "+booking.getPrice());
        System.out.println("");
    }
    
}
