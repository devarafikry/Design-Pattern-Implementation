/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.state;

/**
 *
 * @author Fikry-PC
 */

public interface State {
    abstract void checkBooking();
    abstract void printBill();
    abstract void payBill();
    abstract void unlockRoom();
}
