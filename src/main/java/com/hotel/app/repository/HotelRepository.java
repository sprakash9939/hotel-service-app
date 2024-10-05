package com.hotel.app.repository;

import com.hotel.app.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    List<Hotel> findByUserId(Long userId);
}
