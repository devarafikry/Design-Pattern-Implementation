package tahutelorhotel;

<<<<<<< HEAD
import tahutelorhotel.iterator.BedroomBookingListIterator;
import tahutelorhotel.iterator.MeetingroomBookingListIterator;
import tahutelorhotel.iterator.Iterator;
=======
import iterator.BedroomBookingListIterator;
import iterator.MeetingroomBookingListIterator;
import iterator.Iterator;
>>>>>>> 1460c079404934f9d14ef5807e62cd121c4e21fc
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
<<<<<<< HEAD
        room[0][0] = new Room("Regular Bedroom",0,300000);
        room[0][1] = new Room("VIP Bedroom",0,500000);
        room[0][2] = new Room("VVIP Bedroom",0,1000000);
        
        room[1][0] = new Room("Small Meeting Room",1,500000);
        room[1][1] = new Room("Medium Meeting Room",1,2500000);
        room[1][2] = new Room("Big Meeting Room",1,5000000);
        
        printWelcomeMenu();  
=======
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
>>>>>>> 1460c079404934f9d14ef5807e62cd121c4e21fc
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
<<<<<<< HEAD
                System.out.println("Choose your bedroom :");
=======
                System.out.print("\nChoose your bedroom :");
>>>>>>> 1460c079404934f9d14ef5807e62cd121c4e21fc
                userchoice = input.nextInt();
                
                chooseRoom(0,userchoice,0);
                break;
                
             case 2: //Meeting room
                System.out.println("\n============= Rooms ================");
                for (Room meeting : meet.getSubordinates()) {
                    System.out.println(i+ ".  " + meeting);
                    i++;
                }
<<<<<<< HEAD
                System.out.println("Choose your meeting room :");
=======
                System.out.print("\nChoose your meeting room :");
>>>>>>> 1460c079404934f9d14ef5807e62cd121c4e21fc
                userchoice = input.nextInt();

                chooseRoom(1,userchoice,0);
                break;   
                 
             case 3:
                System.out.println("");
                System.out.println("Choose Booking List :");
<<<<<<< HEAD
//                for (Booking booking: bookings) {
//                    System.out.println(booking.getName() +" selama "+booking.getDuration()+" hari, total "+booking.getPrice());
//                }
                Iterator bedroomBookingListIterator = new BedroomBookingListIterator(bedroomBookings);
                Iterator meetingRoomBookingListIterator = new MeetingroomBookingListIterator(meetingRoomBookings);
                 System.out.println("");
=======

                
                Iterator bedroomBookingListIterator = new BedroomBookingListIterator(bedroomBookings);
                Iterator meetingRoomBookingListIterator = new MeetingroomBookingListIterator(meetingRoomBookings);
>>>>>>> 1460c079404934f9d14ef5807e62cd121c4e21fc
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
<<<<<<< HEAD
                                  
=======
>>>>>>> 1460c079404934f9d14ef5807e62cd121c4e21fc
                   
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
<<<<<<< HEAD
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
=======
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
>>>>>>> 1460c079404934f9d14ef5807e62cd121c4e21fc
        }
        
    }
    
<<<<<<< HEAD
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
=======
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
    
    
>>>>>>> 1460c079404934f9d14ef5807e62cd121c4e21fc
    
}
