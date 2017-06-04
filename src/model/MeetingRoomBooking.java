/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author Devara Fikry Akmal
 */
public class MeetingRoomBooking extends Booking{
    Scanner input = new Scanner(System.in);
    public MeetingRoomBooking(String name,double price, int duration) {
       super(name,price,duration);
    }

    @Override
    public void setDuration(int duration) {
        while(duration>=7){
            System.out.println("You can't reserve a meeting room for more than 7 days!");
            System.out.println("Please reinput your duration :");
            duration = input.nextInt();
        }
        super.duration = duration;
    }
}
