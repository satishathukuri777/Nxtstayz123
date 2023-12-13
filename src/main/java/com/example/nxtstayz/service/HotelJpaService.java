import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class HotelJpaService {
    private final HotelJpaRepository hotelRepository;

    @Autowired
    public HotelJpaService(HotelJpaRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(int hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found"));
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(int hotelId, Hotel hotel) {
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(int hotelId) {
        hotelRepository.deleteById(hotelId);
    }
}
