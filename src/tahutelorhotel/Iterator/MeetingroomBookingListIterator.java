/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import java.util.ArrayList;
import tahutelorhotel.model.BedroomBooking;
import tahutelorhotel.model.Booking;
import tahutelorhotel.model.MeetingRoomBooking;

/**
 *
 * @author Devara Fikry Akmal
 */
public class MeetingroomBookingListIterator implements Iterator {

    static ArrayList<MeetingRoomBooking> bookings = new ArrayList<MeetingRoomBooking>();
    int index =0;
    
      public MeetingroomBookingListIterator(ArrayList<MeetingRoomBooking> bookings) {
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

