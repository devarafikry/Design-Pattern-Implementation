Design Pattern Implementation for Simple Program.

This program is made to complete our final project of Design Pattern Courses.

Tahu Telor Hotel 
===================
Spesification : This program will print menu on console. First, you can call receptionist to fulfill your request. Then, you can create booking for 2 type of Room, it is Bedroom and Meetingroom. But, meeting room can only reserved up to 7 days. After you create booking, you can request to manage your booking to your receptionist. Your booking list will be printed by receptionist, and you can also get the details. There are 4 action that you can do with your bookings :
1. Check Booking Details, this will print your details of your booking included name, duration, and payment status.
2. Print Bill, this will only print your bill.
3. Pay Bill, this will ask you to pay the bill if you haven't paid the bill.
4. Unlock Room, you can try to unlock your room. If you have paid the bill, you can unlock your room.

Main class : TahuTelorHotel.java

PATTERN
===================
1. Singleton Pattern

Definition :
This pattern involves a single class which is responsible to create an object while making sure that only single object gets created. This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class. (https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm)

Implementation :
In this program, we have Receptionist.java as a class that processing the user's request. Receptionist is a singleton class that only called once. In main class, is called in printWelcomeMenu(). Then, it will call getInstance method from Receptionist class. In getInstance method, there are selection to decide to instantiate the object or not, if its already instantiated then it will not instantiate another object.

2. Composite Pattern
Definition :
Composite pattern is used where we need to treat a group of objects in similar way as a single object. Composite pattern composes objects in term of a tree structure to represent part as well as whole hierarchy. This type of design pattern comes under structural pattern as this pattern creates a tree structure of group of objects. (https://www.tutorialspoint.com/design_pattern/composite_pattern.htm)

Implementation :
Room.java is act as node, so the room list will be treated as a tree. We can see in Room class have subordinates that return the current branch.

3. Factory Method Pattern
Definition :
Factory method pattern is a creational pattern that uses factory methods to deal with the problem of creating objects without having to specify the exact class of the object that will be created. This is done by creating objects by calling a factory method—either specified in an interface and implemented by child classes, or implemented in a base class and optionally overridden by derived classes—rather than by calling a constructor. (https://sourcemaking.com/design_patterns/factory_method/java/1)

Implementation :
Factory method will be constructed with this structure :
a. Abstract Creator Class
b. Concrete Creator Class
c. Abstract Product Class
d. Concrete Product Class

a. Abstract Creator Class
BookingFactory is an abstract creator class. It has abstract method createBooking that will return Booking object. This method is the Factory Method.
b. Concrete Creator Class
Receptionist extended BookingFactory class, so it is a concrete creator class. This class also overriding the Factory Method from its parent. In this method, Receptionist instantiate new Object by parameter.
c. Abstract Product Class
Booking is the abstract product class.
d. Concrete Product Class
There are 2 concrete product class, MeetingroomBooking and BedroomBooking. This 2 concrete product class is created from factory method in Concrete Creator Class.

4. Template Pattern
Definition :
Define the skeleton of an algorithm in an operation, deferring some steps to client subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure. (https://sourcemaking.com/design_patterns/template_method)

Implementation :
Template Pattern will be constructed with this structure :
a. Framework Class
b. Application Class

a. Framework Class
This class is an abstract class with template method. It also has method that will be called by template method. Booking is a framework class that has bookingProcedure() final method as template method. This template method consist of 3 steps :
- createBooking()
- printBill()
- payBill()
It defined as final so its children cant change this template method.
b. Application Class
This class extending the framework class and will always call the template method. MeetingroomBooking and BedroomBooking is an application class. In MeetingroomBooking, its overriding setDuration() method so it can limit the duration for meeting room reservation.

5. Iterator Pattern
Definition :
This pattern is used to get a way to access the elements of a collection object in sequential manner without any need to know its underlying representation. (https://www.tutorialspoint.com/design_pattern/iterator_pattern.htm)

Implementation :
Iterator.java is an Iterator interface to iterate our collection. BedroomBookingListIterator and MeetingroomBookingListIterator are Concrete Iterator that implements Iterator. Then, we called the Iterator in main, in printMenu() method. After we specified the proper Iterator, printList() method will called to Iterate the Iterator.

6. State Pattern
Definition :
In State pattern, we create objects which represent various states and a context object whose behavior varies as its state object changes. (https://www.tutorialspoint.com/design_pattern/state_pattern.htm)

Implementation :
State pattern will be constructed with this structure :
a. State Interface Class
b. Concrete State Class
c. Context

a. State Interface Class
This class will defines an interface for encapsulating the behavior associated with a particular state of the Context. State class has 4 behaviour :
- checkBooking()
- printBill()
- payBill()
- unlockRoom()

b. Concrete State Class
There 2 concrete state class extended State class, PaidState and NotPaidState class. This 2 concrete class override all behaviour from State class differently. In NotPaidState class, checkBooking() will showing that room is not paid, you can pay your bill to change your booking state, and you can't unlock the room. And in PaidState class, checkBooking() will showing that room is paid, you can't pay your billm and you can unlock the room. 

c. Context
Booking is treated as context in this pattern. Booking will change its state according to user's payment choice. 

I hope this will become another example for implementation of design pattern on java, this may not be perfect so sorry if anything wrong.


