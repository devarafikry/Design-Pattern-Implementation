package creational;
import model.Booking;
import model.MeetingRoomBooking;
import model.BedroomBooking;

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
