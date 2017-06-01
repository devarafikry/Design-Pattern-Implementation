/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahutelorhotel.creational;
import tahutelorhotel.model.Booking;
import tahutelorhotel.model.MeetingRoomBooking;
import tahutelorhotel.model.BedroomBooking;
/**
 *
 * @author Fikry-PC
 */
public abstract class BookingFactory {
//    protected Booking orderBooking(int type,String name, double price, int duration){
//        Booking booking;
//        booking = createBooking(type,name, price, duration);
//        System.out.println("Kamu memberi uang...");
//        booking.setPaid(true);
//        return booking;
//    }
    protected abstract Booking createBooking(int type,String name, double price, int duration);
    
}
