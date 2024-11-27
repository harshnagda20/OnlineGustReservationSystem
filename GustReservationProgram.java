package program;
import java.util.Scanner;
import java.util.ArrayList;
class ReservationDetails {
    private int id;
    private String name;
    private String date;
    private int numberOfGuests;

    public ReservationDetails(int id, String name, String date, int numberOfGuests) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.numberOfGuests = numberOfGuests;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }
}

//MAIN IMPLEMENTATION
 class ReservationSystem 
 {
    private ArrayList<ReservationDetails> reservations = new ArrayList<>();
    private int nextId = 1;

    public ReservationDetails makeReservation(String name, String date, int numberOfGuests) 
    {
    	//UP-CLASS -OBJECT
        ReservationDetails ArrayListreservation = new ReservationDetails(nextId++, name, date, numberOfGuests);
        reservations.add(ArrayListreservation);
        return ArrayListreservation;
    }
    
    //GETTER METHOD FOR ARRAY LIST
    public ArrayList<ReservationDetails> getReservations()
    {
        return reservations;
    }

    public ReservationDetails getReservationById(int id) {
        for (ReservationDetails reservation : reservations) {
            if (reservation.getId() == id) {
                return reservation;
            }
        }
        return null;
    }

    public boolean cancelReservation(int id) {
        ReservationDetails reservation = getReservationById(id);
        if (reservation != null) {
            reservations.remove(reservation);
            return true;
        }
        return false;
    }
}


 class GustReservationProgram {
    private ReservationSystem reservationSystem = new ReservationSystem();

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Make a reservation");
            System.out.println("2. View all reservations");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Date: ");
                    String date = sc.nextLine();
                    System.out.print("Number of guests: ");
                    int numberOfGuests = sc.nextInt();
                    //sc.nextLine();

                    ReservationDetails reservation = reservationSystem.makeReservation(name, date, numberOfGuests);
                    System.out.println("Reservation made with ID " + reservation.getId());
                    break;
                case 2:
                    System.out.println("Reservations: ");
                    if(reservationSystem.getReservations().size()==0) {
                    	System.out.println("NO RESERVATIONS ARE MADE");
                    }
                    for (ReservationDetails r : reservationSystem.getReservations()) {
                        System.out.println(r.getId() + " - " + r.getName() + " - " + r.getDate() + " - " + r.getNumberOfGuests());
                    }
                    break;
                case 3:
                    System.out.print("Reservation ID to cancel: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (reservationSystem.cancelReservation(id)) {
                        System.out.println("Reservation canceled");
                    } else {
                        System.out.println("Reservation not found");
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }

            System.out.println();
            sc.close();
        }
        
    }

    public static void main(String[] args)
    {
    	GustReservationProgram obj = new GustReservationProgram();
        obj.start();
    }
   
}