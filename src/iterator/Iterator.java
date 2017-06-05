package iterator;

import model.Booking;

public interface Iterator {
    boolean hasNext();
    Booking next();
    
}