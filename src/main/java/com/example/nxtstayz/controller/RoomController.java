package com.example.nxtstayz.controller;


import com.example.nxtstayz.model.Room;
import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.service.RoomJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class RoomController {
    private final RoomJpaService roomService;

    @Autowired
    public RoomController(RoomJpaService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{roomId}")
    public Room getRoomById(@PathVariable int roomId) {
        return roomService.getRoomById(roomId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @PutMapping("/{roomId}")
    public Room updateRoom(@PathVariable int roomId, @RequestBody Room room) {
        return roomService.updateRoom(roomId, room);
    }

    @DeleteMapping("/{roomId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable int roomId) {
        roomService.deleteRoom(roomId);
    }
}
