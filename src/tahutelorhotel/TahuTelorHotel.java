/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahutelorhotel;

import Iterator.BedroomBookingListIterator;
import Iterator.MeetingroomBookingListIterator;
import Iterator.Iterator;
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
        room[0][0] = new Room("Kamar Tidur Regular",0,300000);
        room[0][1] = new Room("Kamar Tidur VIP",0,500000);
        room[0][2] = new Room("Kamar Tidur VVIP",0,1000000);
        
        room[1][0] = new Room("Ruang Pertemuan Kecil",1,500000);
        room[1][1] = new Room("Ruang Pertemuan Sedang",1,2500000);
        room[1][2] = new Room("Ruang Pertemuan Besar",1,5000000);
        
        printWelcomeMenu();
        printReceptionistMenu();
        System.out.print("Masukkan pilihan ruangan :");
        System.out.println("");
        //initializing factory
        
        
    }
    
    public static void printMenu(int options){
        int userchoice = 77;
        int duration = 77;
        switch(options){
            case 1:
                for(int i =0;i<room[0].length;i++){
                    System.out.println(i+1+". "+room[0][i].getNama()+" Rp. "+room[0][i].getPrice()+" ,00");
                }
                System.out.println("Pilih kamar tidur anda :");
                userchoice = input.nextInt();
                System.out.println("Masukkan durasi booking (hari) :");
                duration = input.nextInt();
                chooseRoom(0,userchoice,duration);
                break;
             case 2:
                for(int i =0;i<room[1].length;i++){
                    System.out.println(i+1+". "+room[1][i].getNama()+" Rp. "+room[1][i].getPrice()+" ,00");
                }
                System.out.println("Pilih ruang pertemuan anda :");
                userchoice = input.nextInt();
                System.out.println("Masukkan durasi booking (hari) :");
                duration = input.nextInt();
                chooseRoom(1,userchoice,duration);
                break;   
             case 3:
                System.out.println("");
                System.out.println("Ini Daftar Pesanan Anda :");
//                for (Booking booking: bookings) {
//                    System.out.println(booking.getName() +" selama "+booking.getDuration()+" hari, total "+booking.getPrice());
//                }
                Iterator bedroomBookingListIterator = new BedroomBookingListIterator(bedroomBookings);
                Iterator meetingRoomBookingListIterator = new MeetingroomBookingListIterator(meetingRoomBookings);
                 System.out.println("");
                 System.out.println("List of Bedroom Bookings :");
                 printList(bedroomBookingListIterator);
                 System.out.println("");
                 System.out.println("List of Meeting Room Bookings :");
                 printList(meetingRoomBookingListIterator);
                break;   
        }
        
           
        printWelcomeMenu();
        
        
        
    }
    
    public static void printList(Iterator iterator){
        while(iterator.hasNext()){
            Booking booking = iterator.next();
            System.out.println(booking.getName() +" selama "+booking.getDuration()+" hari, total "+booking.getPrice());
        }
    }
    
    public static void chooseRoom(int options,int userchoice, int duration){
        System.out.println("nihoptions "+options);
        userchoice = userchoice-1;
        if(options==0){
            bedroomBookings.add((BedroomBooking)receptionist.createBooking(options,room[options][0].getNama(), room[options][0].getPrice(), duration));
        } else{
            meetingRoomBookings.add((MeetingRoomBooking)receptionist.createBooking(options,room[options][0].getNama(), room[options][0].getPrice(), duration));
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
        System.out.println("Pesanan anda sudah tercatat");
    }
    
    public static void printWelcomeMenu(){
        System.out.println("");
        System.out.println("Tahu Telor Hotel");
        System.out.println("1. Bunyikan bel untuk memanggil resepsionis");
        System.out.println("2. Pergi");
        System.out.println("==================================");
        System.out.print("Masukkan pilihan anda :");
        System.out.println("");
        int options = input.nextInt();
        switch(options){
            case 1:
                receptionist = Receptionist.getInstance();
                printReceptionistMenu();
                break;
            case 2:
                System.out.println("Anda meninggalkan Tahu Telor Hotel");
                break;
            default:
                System.out.println("Anda meninggalkan Tahu Telor Hotel");
        }
    }
    
    public static void printReceptionistMenu(){
        System.out.println("");
        System.out.println("Selamat datang di Tahu Telor Hotel, ada yang bisa saya bantu?");
        System.out.println("1. Pesan Kamar Tidur");
        System.out.println("2. Pesan Ruangan Pertemuan");
        System.out.println("3. Lihat Daftar Pesanan Saya");
        System.out.println("==================================");
        System.out.print("Masukkan pilihan anda :");
        System.out.println("");
        int options = input.nextInt();
        printMenu(options);
    }
    
}
