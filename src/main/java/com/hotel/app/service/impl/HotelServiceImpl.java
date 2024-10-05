package com.hotel.app.service.impl;

import com.hotel.app.entity.Hotel;
import com.hotel.app.model.HotelModel;
import com.hotel.app.repository.HotelRepository;
import com.hotel.app.service.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HotelModel saveHotel(HotelModel hotelModel) {
        Hotel hotel= hotelRepository.save(modelMapper.map(hotelModel, Hotel.class));
        return modelMapper.map(hotel,HotelModel.class);
    }

    @Override
    public HotelModel updateHotelbyId(Integer hotelId, HotelModel hotelModel) {
        Hotel hotel=hotelRepository.findById(hotelId).orElseThrow(()->new NoSuchElementException("Record not availble for hotel id: "+hotelId));
        modelMapper.map(hotelModel,hotel);
        var result=hotelRepository.save(hotel);
        return modelMapper.map(result,HotelModel.class);

    }

    @Override
    public HotelModel findByHotelId(Integer hotelId) {

        Hotel hotel= hotelRepository.findById(hotelId).orElseThrow(()->new NoSuchElementException("Record not availble for hotel id: "+hotelId));
        return modelMapper.map(hotel,HotelModel.class);
    }

    @Override
    public List<HotelModel> findAll() {
        List<HotelModel> hotelModelList=new ArrayList<>();
        List<Hotel> hotels=hotelRepository.findAll();
        for(Hotel hotel:hotels){
            hotelModelList.add(modelMapper.map(hotel,HotelModel.class));
        }
        return hotelModelList;
    }

    @Override
    public List<HotelModel> findHotelByUserId(Long userId) {
        List<HotelModel> hotelModelList=new ArrayList<>();
        List<Hotel> hotels=hotelRepository.findByUserId(userId);
        for(Hotel hotel:hotels){
            hotelModelList.add(modelMapper.map(hotel,HotelModel.class));
        }
        return hotelModelList;
    }

    @Override
    public boolean deleteByHotelId(Integer hotelId) {
        return false;
    }
}
