package iterator;

import java.util.ArrayList;
import model.BedroomBooking;
import model.Booking;
import model.MeetingRoomBooking;

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

