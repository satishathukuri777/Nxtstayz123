import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByHotel_HotelId(int hotelId);
}
