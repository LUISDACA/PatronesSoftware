import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = ReservationSystem.getInstance();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nWelcome to the Football Field Reservation System");
            System.out.println("1. View available time slots");
            System.out.println("2. Make a reservation");
            System.out.println("3. View all reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    // Show available slots
                    List<String> availableSlots = reservationSystem.getAvailableSlots();
                    if (availableSlots.isEmpty()) {
                        System.out.println("No available time slots.");
                    } else {
                        System.out.println("Available time slots:");
                        for (String slot : availableSlots) {
                            System.out.println(slot);
                        }
                    }
                    break;

                case 2:
                    // Make a reservation
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter your ID number: ");
                    String idNumber = scanner.nextLine();

                    System.out.print("Enter your phone number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter desired time slot (e.g., 8:00 - 9:00): ");
                    String timeSlot = scanner.nextLine();

                    Reservation reservation = new Reservation(name, idNumber, phone, timeSlot);
                    Reservation clonedReservation = reservation.clone(); // Prototype pattern

                    boolean success = reservationSystem.reserveSlot(timeSlot, clonedReservation);

                    if (success) {
                        System.out.println("Reservation successful!");
                    } else {
                        System.out.println("Time slot not available. Please choose another slot.");
                    }
                    break;

                case 3:
                    // Show all reservations
                    List<Reservation> reservations = reservationSystem.getReservations();
                    if (reservations.isEmpty()) {
                        System.out.println("No reservations have been made.");
                    } else {
                        System.out.println("All reservations:");
                        for (Reservation r : reservations) {
                            System.out.println(r);
                        }
                    }
                    break;

                case 4:
                    // Exit the application
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
