package tahutelorhotel;

import iterator.BedroomBookingListIterator;
import iterator.MeetingroomBookingListIterator;
import iterator.Iterator;
import java.util.ArrayList;
import java.util.Scanner;
import creational.Receptionist;
import model.BedroomBooking;
import model.Booking;
import model.MeetingRoomBooking;
import model.Room;

public class TahuTelorHotel {

    static Scanner input = new Scanner(System.in);
    static Receptionist receptionist;
    static ArrayList<BedroomBooking> bedroomBookings = new ArrayList<BedroomBooking>();
    static ArrayList<MeetingRoomBooking> meetingRoomBookings = new ArrayList<MeetingRoomBooking>();
    static Room room, bed, meet, room1, room2, room3, room4, room5, room6, room7;
  
    public static void main(String[] args) { 
        createRoom();
        printWelcomeMenu();  
    }
    
    public static void createRoom(){
        room = new Room("HotelRoom",0, 0);
        bed = new Room("Bedroom",0, 0);
        meet = new Room("Meetingroom",1, 0);
      
        room1 = new Room("Suite Room", 1, 200000);
        room2 = new Room("Executive Room", 1, 400000);
        room3 = new Room("Deluxe Room",1, 600000);
        
        room4 = new Room("Regular Meeting Room",2, 1000000);
        room5 = new Room("Ivory Meeting Room",2, 2000000);
        room6 = new Room("Grand Ballroom",2, 5000000);
      
        room.add(bed);
        room.add(meet);

        bed.add(room1);
        bed.add(room2);
        bed.add(room3);

        meet.add(room4);
        meet.add(room5);
        meet.add(room6);
    }
    
    public static void printWelcomeMenu(){
        System.out.println("");
        System.out.println("Tahu Telor Hotel");
        System.out.println("1. Ring Bell to call Receptionist");
        System.out.println("2. Leave");
        System.out.println("==================================");
        System.out.print("Input your choice :  ");
//        System.out.println("");
        int options = input.nextInt();
        switch(options){
            case 1:
                receptionist = Receptionist.getInstance();
                receptionist.printMenu();
                break;
            case 2:
                System.out.println("You are leaving Tahu Telor Hotel");
                break;
            default:
                System.out.println("You are leaving Tahu Telor Hotel");
        }
    }
    
    public static void printReceptionistMenu(){
        System.out.println("");
        System.out.println("Welcome to Tahu Telor Hotel, what's your request?");
        System.out.println("1. Book a Bedroom");
        System.out.println("2. Book a Meeting Room");
        System.out.println("3. Manage My Booking");
        System.out.println("==================================");
        System.out.print("Input your choice :  ");
//        System.out.println("");
        int options = input.nextInt();
        printMenu(options);
    }
    
    public static void printMenu(int options){
        int userchoice = 77;
        int duration = 77;
        int i = 1;
        switch(options){
            case 1: // kamar
                System.out.println("\n============= Rooms ================");
                
                for (Room bedroom : bed.getSubordinates()) {
                    System.out.println(i+ ".  " + bedroom);
                    i++;
                }
                System.out.print("\nChoose your bedroom :");
                userchoice = input.nextInt();
                
                chooseRoom(0,userchoice,0);
                break;
                
             case 2: //Meeting room
                System.out.println("\n============= Rooms ================");
                for (Room meeting : meet.getSubordinates()) {
                    System.out.println(i+ ".  " + meeting);
                    i++;
                }
                System.out.print("\nChoose your meeting room :");
                userchoice = input.nextInt();

                chooseRoom(1,userchoice,0);
                break;   
                 
             case 3:
                System.out.println("");
                System.out.println("Choose Booking List :");

                
                Iterator bedroomBookingListIterator = new BedroomBookingListIterator(bedroomBookings);
                Iterator meetingRoomBookingListIterator = new MeetingroomBookingListIterator(meetingRoomBookings);
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
            if(!iterator.hasNext()){
                System.out.print("\nChoose your booking :   ");
                int in = input.nextInt();
                in = in-1;
                printBookingMenu(arr.get(in));
            }
        }
       
        
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
        String roomName = "" ;
        double roomPrice = -1;
        
        // Penggunaan Type room 0 = kamar 1 = meeting room
        if(options==0){ 
            roomName= bed.getSubordinates().get(userchoice).getNama();
            roomPrice= bed.getSubordinates().get(userchoice).getPrice();

            bedroomBookings.add((BedroomBooking)receptionist.createBooking(options,roomName, roomPrice, duration));
        } else{
            roomName= meet.getSubordinates().get(userchoice).getNama();
            roomPrice= meet.getSubordinates().get(userchoice).getPrice();
            
            meetingRoomBookings.add((MeetingRoomBooking)receptionist.createBooking(options,roomName, roomPrice, duration));
        }
        
        System.out.println("Thank you! Your reservation has been recorded.");
    }  
    
    
    
}
