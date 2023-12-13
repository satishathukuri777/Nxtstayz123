import javax.persistence.*;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;

    private String hotelName;
    private String location;
    private int rating;

    // Getters and setters
}
