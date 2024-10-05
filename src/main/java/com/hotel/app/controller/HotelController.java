package com.hotel.app.controller;

import com.hotel.app.model.HotelModel;
import com.hotel.app.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping(value = "/save-hotel")
    public ResponseEntity<?> saveHotel(@RequestBody HotelModel hotelModel){
        HotelModel result= hotelService.saveHotel(hotelModel);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/update-by-hotelId/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable(value = "id") Integer hotelId,@RequestBody HotelModel hotelModel){
        HotelModel result=hotelService.updateHotelbyId(hotelId,hotelModel);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "find-all")
    public ResponseEntity<?> getAllHotel(){
        List<HotelModel> hotelModelList=hotelService.findAll();
        return ResponseEntity.ok(hotelModelList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable(value = "id") Integer hotelId){
        HotelModel hotelModel=hotelService.findByHotelId(hotelId);
        return ResponseEntity.ok(hotelModel);
    }

    @GetMapping(value = "/find-hotel-by-user-id/{user-id}")
    public ResponseEntity<?> getHotelByUserId(@PathVariable(value = "user-id") Long userId){
        List<HotelModel> hotelModelList=hotelService.findHotelByUserId(userId);
        return ResponseEntity.ok(hotelModelList);
    }
}
