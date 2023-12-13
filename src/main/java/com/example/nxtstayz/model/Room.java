import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    private String roomNumber;
    private String type;
    private double price;

    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    // Getters and setters
}
