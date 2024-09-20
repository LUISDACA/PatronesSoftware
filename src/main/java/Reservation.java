public class Reservation implements Cloneable {
    private String name;
    private String idNumber;
    private String phone;
    private String timeSlot;

    public Reservation(String name, String idNumber, String phone, String timeSlot) {
        this.name = name;
        this.idNumber = idNumber;
        this.phone = phone;
        this.timeSlot = timeSlot;
    }

    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public Reservation clone() {
        try {
            return (Reservation) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Reservation for " + name + " at " + timeSlot + " (ID: " + idNumber + ", Phone: " + phone + ")";
    }
}
