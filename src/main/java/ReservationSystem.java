import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {
    private static ReservationSystem instance;
    private List<String> availableSlots;
    private List<Reservation> reservations;

    private ReservationSystem() {
        reservations = new ArrayList<>();
        availableSlots = new ArrayList<>();
        initializeSlots();
    }

    // Singleton implementation
    public static synchronized ReservationSystem getInstance() {
        if (instance == null) {
            instance = new ReservationSystem();
        }
        return instance;
    }

    // Initialize available slots from 8 AM to 10 PM (22:00)
    private void initializeSlots() {
        for (int i = 8; i < 22; i++) {
            availableSlots.add(i + ":00 - " + (i + 1) + ":00");
        }
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    // Reserve a slot if it's available
    public boolean reserveSlot(String slot, Reservation reservation) {
        if (availableSlots.contains(slot)) {
            availableSlots.remove(slot); // Remove the slot once it's reserved
            reservations.add(reservation); // Add reservation to the list
            return true;
        }
        return false; // Return false if the slot is already taken
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
