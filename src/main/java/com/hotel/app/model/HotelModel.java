package com.hotel.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelModel {
    private Integer hotelId;

    private String name;

    private String location;

    private String about;

    private Long userId;

}
