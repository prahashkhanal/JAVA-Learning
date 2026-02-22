// Custom Exception
class NoSeatsAvailableException extends Exception {
    public NoSeatsAvailableException(String message) {
        super(message);
    }
}

// Flight Class
class Flight {
    private int availableSeats;

    public Flight(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void bookSeat(int seats) throws NoSeatsAvailableException {
        if (seats > availableSeats) {
            throw new NoSeatsAvailableException("No seats available!");
        }
        availableSeats -= seats;
        System.out.println(seats + " seats booked successfully.");
        System.out.println("Remaining seats: " + availableSeats);
    }
}

// Main Class
public class FlightTest {
    public static void main(String[] args) {
        Flight flight = new Flight(2);

        try {
            flight.bookSeat(1);
            flight.bookSeat(2); // Exception
        } catch (NoSeatsAvailableException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}