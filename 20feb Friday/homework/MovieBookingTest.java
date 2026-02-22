// Custom Exception
class SeatNotAvailableException extends Exception {
    public SeatNotAvailableException(String message) {
        super(message);
    }
}

// Movie Class
class Movie {
    private String movieName;
    private int availableSeats;

    public Movie(String movieName, int availableSeats) {
        this.movieName = movieName;
        this.availableSeats = availableSeats;
    }

    public void bookTicket(int seats) throws SeatNotAvailableException {
        if (seats > availableSeats) {
            throw new SeatNotAvailableException("Not enough seats available!");
        }
        availableSeats -= seats;
        System.out.println(seats + " seats booked successfully for " + movieName);
        System.out.println("Remaining seats: " + availableSeats);
    }
}

// Main Class
public class MovieBookingTest {
    public static void main(String[] args) {
        Movie movie = new Movie("Avengers", 5);

        try {
            movie.bookTicket(3);
            movie.bookTicket(4); // This will throw exception
        } catch (SeatNotAvailableException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}