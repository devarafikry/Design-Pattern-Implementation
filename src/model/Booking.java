package model;

import java.util.Scanner;
import model.state.NotPaidState;
import model.state.PaidState;
import model.state.State;

public abstract class Booking {
    String name;
    double price;
    int duration;
    boolean paid = false;
    State state;
    
    State paidState;
    State notPaidState;

    public State getPaidState() {
        return paidState;
    }

    public void setPaidState(State paidState) {
        this.paidState = paidState;
    }

    public State getNotPaidState() {
        return notPaidState;
    }

    public void setNotPaidState(State notPaidState) {
        this.notPaidState = notPaidState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    //template method
    final public void bookingProcedure(){
        createBooking();
        printBill();
        payBill();
    }
    
    public void createBooking(){
        System.out.println("\n--- Processing Your Reservation... --- \n");
        
        System.out.print("Input duration for booking (day) :  ");
        Scanner input = new Scanner(System.in);
        duration = input.nextInt();
        setDuration(duration);
        setPrice(duration*price);
        state.checkBooking();
    }
    
    public void printBill(){
        state.printBill();
    }
    
    public void payBill(){
        state.payBill();
    }
    
    public Booking(){
        
    }
    public Booking(String name,double price, int duration) {
        this.name = name;
        setPrice(price);
        setDuration(duration);
        
        paidState = new PaidState(this);
        notPaidState = new NotPaidState(this);
        setState(notPaidState);
    }
    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public abstract void setDuration(int duration);

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
    
}
