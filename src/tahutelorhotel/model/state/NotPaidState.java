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
public class NotPaidState implements State {

    @Override
    public void checkBooking() {
        System.out.println("");
        System.out.println("Booking Details :");
        System.out.println("Name :"+booking.getName());
        System.out.println("Duration :"+booking.getDuration());
        System.out.println("Bill Status :"+"Not Paid");
        System.out.println("");
    }

    @Override
    public void payBill() {
        System.out.println("");
        System.out.println("Pay the bill? (y/n)");
        Scanner input = new Scanner(System.in);
        String s = input.next();
        if(s.equalsIgnoreCase("y")){           
            booking.setPaid(true);
            booking.setState(booking.getPaidState());
        } 
    }

    @Override
    public void unlockRoom() {
        System.out.println("");
        System.out.println("You have no key!");
        System.out.println("You can't unlock this room.");
        System.out.println("");
    }
    Booking booking;
    public NotPaidState(Booking booking){
        this.booking = booking;
    }
    
    public void printBill(){
        System.out.println("");
        System.out.println("Your bill of "+booking.getName()+" for "+booking.getDuration()+" days:");
        System.out.println("Rp "+booking.getPrice());
        System.out.println("");
    }

}
