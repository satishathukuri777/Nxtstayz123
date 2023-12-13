import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class RoomJpaService {
    private final RoomJpaRepository roomRepository;

    @Autowired
    public RoomJpaService(RoomJpaRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(int roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(int roomId, Room room) {
        room.setRoomId(roomId);
        return roomRepository.save(room);
    }

    public void deleteRoom(int roomId) {
        roomRepository.deleteById(roomId);
    }
}
