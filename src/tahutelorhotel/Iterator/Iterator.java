/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahutelorhotel.iterator;

import tahutelorhotel.model.Booking;

/**
 *
 * @author Devara Fikry Akmal
 */
public interface Iterator {
    boolean hasNext();
    Booking next();
    
}


