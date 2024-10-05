package com.hotel.app.service;

import com.hotel.app.model.HotelModel;

import java.util.List;

public interface HotelService {

    public HotelModel saveHotel(HotelModel hotelModel);

    public HotelModel updateHotelbyId(Integer hotelId,HotelModel hotelModel);

    public HotelModel findByHotelId(Integer hotelId);

    public List<HotelModel> findAll();

    public List<HotelModel> findHotelByUserId(Long userId);

    public boolean deleteByHotelId(Integer hotelId);
}
