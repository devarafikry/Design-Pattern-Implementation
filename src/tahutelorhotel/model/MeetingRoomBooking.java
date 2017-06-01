/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahutelorhotel.model;

/**
 *
 * @author Devara Fikry Akmal
 */
public class MeetingRoomBooking extends Booking{
    public MeetingRoomBooking(String name,double price, int duration) {
       super(name,price,duration);
    }

    @Override
    public void setDuration(int duration) {
        if(duration>7){
            super.duration = 7;
            System.out.println("Durasi telah di set ke nilai maksimal yaitu selama 7 hari");
        }
        else{
            super.duration = duration;
        }
    }
}
