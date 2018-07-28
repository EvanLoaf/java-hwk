package com.gmail.evanloafakahaitao.hwk26.sqltask.dao;

import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.model.House;

import java.util.List;

public interface HouseDao {
    
    Long save(House house);
    
    List<House> getHouses();
}
