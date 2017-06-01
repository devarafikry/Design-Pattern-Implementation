/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahutelorhotel.iterator;

import java.util.ArrayList;
import tahutelorhotel.creational.Receptionist;
import tahutelorhotel.model.BedroomBooking;
import tahutelorhotel.model.Booking;

/**
 *
 * @author Devara Fikry Akmal
 */
public class BedroomBookingListIterator implements Iterator {

    ArrayList<BedroomBooking> bookings = new ArrayList<BedroomBooking>();
    int index =0;

    public BedroomBookingListIterator(ArrayList<BedroomBooking> bookings) {
        this.bookings = bookings;
    }
    
    
      @Override
      public boolean hasNext() {
         if(index < bookings.size()){
            return true;
         }
         return false;
      }

      @Override
      public Booking next() {
         if(this.hasNext()){
            Booking booking = bookings.get(index);
            index++;
            return booking;
         }
         return null;
      }	
    
}
