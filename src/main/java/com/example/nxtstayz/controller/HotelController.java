package com.example.nxtstayz.controller;


import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;
import com.example.nxtstayz.service.HotelJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelJpaService hotelService;

    @Autowired
    public HotelController(HotelJpaService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{hotelId}")
    public Hotel getHotelById(@PathVariable int hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/{hotelId}")
    public Hotel updateHotel(@PathVariable int hotelId, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(hotelId, hotel);
    }

    @DeleteMapping("/{hotelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHotel(@PathVariable int hotelId) {
        hotelService.deleteHotel(hotelId);
    }
}
