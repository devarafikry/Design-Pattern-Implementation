/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahutelorhotel;

import tahutelorhotel.iterator.BedroomBookingListIterator;
import tahutelorhotel.iterator.MeetingroomBookingListIterator;
import tahutelorhotel.iterator.Iterator;
import java.util.ArrayList;
import java.util.Scanner;
import tahutelorhotel.creational.Receptionist;
import tahutelorhotel.model.BedroomBooking;
import tahutelorhotel.model.Booking;
import tahutelorhotel.model.MeetingRoomBooking;
import tahutelorhotel.model.Room;

/**
 *
 * @author Devara Fikry Akmal
 */
public class TahuTelorHotel {

    /**
     * @param args the command line arguments
     */
    static Room[][] room = new Room[2][3];
    static Scanner input = new Scanner(System.in);
    static Receptionist receptionist;
    static ArrayList<BedroomBooking> bedroomBookings = new ArrayList<BedroomBooking>();
    static ArrayList<MeetingRoomBooking> meetingRoomBookings = new ArrayList<MeetingRoomBooking>();
    
    public static void main(String[] args) { 
        room[0][0] = new Room("Regular Bedroom",0,300000);
        room[0][1] = new Room("VIP Bedroom",0,500000);
        room[0][2] = new Room("VVIP Bedroom",0,1000000);
        
        room[1][0] = new Room("Small Meeting Room",1,500000);
        room[1][1] = new Room("Medium Meeting Room",1,2500000);
        room[1][2] = new Room("Big Meeting Room",1,5000000);
        
        printWelcomeMenu();  
    }
    
    public static void printMenu(int options){
        int userchoice = 77;
        int duration = 77;
        switch(options){
            case 1:
                for(int i =0;i<room[0].length;i++){
                    System.out.println(i+1+". "+room[0][i].getNama()+" Rp. "+room[0][i].getPrice()+" ,00");
                }
                System.out.println("Choose your bedroom :");
                userchoice = input.nextInt();
                
                chooseRoom(0,userchoice,0);
                break;
             case 2:
                for(int i =0;i<room[1].length;i++){
                    System.out.println(i+1+". "+room[1][i].getNama()+" Rp. "+room[1][i].getPrice()+" ,00");
                }
                System.out.println("Choose your meeting room :");
                userchoice = input.nextInt();

                chooseRoom(1,userchoice,0);
                break;   
             case 3:
                System.out.println("");
                System.out.println("Choose Booking List :");
//                for (Booking booking: bookings) {
//                    System.out.println(booking.getName() +" selama "+booking.getDuration()+" hari, total "+booking.getPrice());
//                }
                Iterator bedroomBookingListIterator = new BedroomBookingListIterator(bedroomBookings);
                Iterator meetingRoomBookingListIterator = new MeetingroomBookingListIterator(meetingRoomBookings);
                 System.out.println("");
                 System.out.println("1. List of Bedroom Bookings");
                 System.out.println("2. List of Meeting Room Bookings");
                 System.out.println("Input your choice :");
                 int in = input.nextInt();
                 switch(in){
                     case 1:
                         printList(bedroomBookingListIterator);
                         break;
                     case 2:
                         printList(meetingRoomBookingListIterator);
                         break;
                     default:
                         printWelcomeMenu();
                 }
                                  
                   
        }      
        printWelcomeMenu();
    }
    
    public static void printList(Iterator iterator){
        ArrayList<Booking> arr = new ArrayList<Booking>();
        System.out.println("");
        System.out.println("Booking List :");
        int i=1;
        while(iterator.hasNext()){
            Booking booking = iterator.next();
            arr.add(booking);
            System.out.println(i+". "+booking.getName() +" for "+booking.getDuration()+" day, with total Rp "+booking.getPrice());
            i++;
        }
        System.out.println("Choose your booking :");
        int in = input.nextInt();
        in = in-1;
        printBookingMenu(arr.get(in));
    }
    
    public static void printBookingMenu(Booking booking){
        System.out.println("Choose Action :");
        System.out.println("1. Check Booking Details");
        System.out.println("2. Print Bill");
        System.out.println("3. Pay Bill");
        System.out.println("4. Unlock Room");
        System.out.println("99.Back to Menu");
        int in = input.nextInt();
        switch(in){
            case 1:
                booking.getState().checkBooking(); printBookingMenu(booking);
                break;
            case 2:
                booking.getState().printBill(); printBookingMenu(booking);
                break;
            case 3:
                booking.getState().payBill(); printBookingMenu(booking);
                break;
            case 4:
                booking.getState().unlockRoom(); printBookingMenu(booking);
                break;
            default:
                printWelcomeMenu();
                break;
        }
        
    }
    
    public static void chooseRoom(int options,int userchoice, int duration){
        userchoice = userchoice-1;
        if(options==0){
            bedroomBookings.add((BedroomBooking)receptionist.createBooking(options,room[options][userchoice].getNama(), room[options][userchoice].getPrice(), duration));
        } else{
            meetingRoomBookings.add((MeetingRoomBooking)receptionist.createBooking(options,room[options][userchoice].getNama(), room[options][userchoice].getPrice(), duration));
        }
//        switch(userchoice){
//            case 1:
//               
//                break;
//            case 2:
//                bookings.add(receptionist.createBooking(options,room[options][1].getNama(), room[options][1].getPrice(), duration));
//                break;
//            case 3:
//                bookings.add(receptionist.createBooking(options,room[options][2].getNama(), room[options][2].getPrice(), duration));
//                break;
//            case 99:
//                printWelcomeMenu();
//                break;
//        }
//        
        System.out.println("Thanks for booking! Your request has been recorded.");
    }
    
    public static void printWelcomeMenu(){
        System.out.println("");
        System.out.println("Tahu Telor Hotel");
        System.out.println("1. Ring Bell to call Receptionist");
        System.out.println("2. Leave");
        System.out.println("==================================");
        System.out.print("Input your choice :");
        System.out.println("");
        int options = input.nextInt();
        switch(options){
            case 1:
                receptionist = Receptionist.getInstance();
                receptionist.printMenu();
                break;
            case 2:
                System.out.println("You leaving Tahu Telor Hotel");
                break;
            default:
                System.out.println("You leaving Tahu Telor Hotel");
        }
    }
    
    public static void printReceptionistMenu(){
        System.out.println("");
        System.out.println("Welcome to Tahu Telor Hotel, what's your request?");
        System.out.println("1. Book a Bedroom");
        System.out.println("2. Book a Meeting Room");
        System.out.println("3. Manage My Booking");
        System.out.println("==================================");
        System.out.print("Input your choice :");
        System.out.println("");
        int options = input.nextInt();
        printMenu(options);
    }
    
}
