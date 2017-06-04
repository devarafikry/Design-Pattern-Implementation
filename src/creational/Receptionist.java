/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational;

import tahutelorhotel.TahuTelorHotel;
import static tahutelorhotel.TahuTelorHotel.printReceptionistMenu;
import model.BedroomBooking;
import model.Booking;
import model.MeetingRoomBooking;

/**
 *
 * @author Devara Fikry Akmal
 */
public class Receptionist extends BookingFactory {
    private static Receptionist instance= null;
    public static Receptionist getInstance(){
        if(instance == null) {
         instance = new Receptionist();
            System.out.println("");
            System.out.println("Kring..kring..kring.. (Calling receptionist)");
             try {
                    Thread.sleep(1000);               
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                } 
            System.out.println("-- Receptionist has come --");
      }
        else{
            System.out.println("");
            System.out.println("We're sorry, Your receptionist is here. May I help you?");
        }
      return instance;
    }
    
    public void printMenu(){
        TahuTelorHotel.printReceptionistMenu();
    }

    public Receptionist() {
    }
    
    
    public Booking createBooking(int options,String name, double price, int duration){
        Booking booking = null;
        switch(options){
            case 0:
                booking = new BedroomBooking(name,price,duration); break;
            case 1:
                booking = new MeetingRoomBooking(name,price,duration); break;
            default:
                booking = null;
        }
        booking.bookingProcedure();
        return booking;
    }
    
}
