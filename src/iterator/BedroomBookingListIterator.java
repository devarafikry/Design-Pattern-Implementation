package iterator;

import java.util.ArrayList;
import creational.Receptionist;
import model.BedroomBooking;
import model.Booking;


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
