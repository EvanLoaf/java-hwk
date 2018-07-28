package com.gmail.evanloafakahaitao.hwk26.sqltask.service;

import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.FlatDao;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.HouseDao;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.impl.FlatDaoImpl;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.impl.HouseDaoImpl;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.model.Flat;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.model.House;

import java.util.Random;

public class GeneratorSingletonService {
    
    private final Random rd = new Random();
    private static volatile GeneratorSingletonService instance = null;
    private static final FlatDao flatDao = new FlatDaoImpl();
    private static final HouseDao houseDao = new HouseDaoImpl();
    
    private GeneratorSingletonService() {
    }
    
    public synchronized static GeneratorSingletonService getInstance() {
        if (instance == null) {
            synchronized (GeneratorSingletonService.class) {
                if (instance == null) {
                    instance = new GeneratorSingletonService();
                }
            }
        }
        return instance;
    }
    
    public void generateAddHousesAndFlats(int housesToGenerate, int flatsPerHouse) {
        for (int i = 0; i < housesToGenerate; i++) {
            House house = new House(
                    "house_address" + rd.nextInt(1000)
            );
            Long generatedId = houseDao.save(house);
            house.setId(generatedId);
            System.out.println("House generated, setting up flats...");
            for (int j = 0; j < flatsPerHouse; j++) {
                Flat flat = Flat.newBuilder()
                        .withSize(String.valueOf(rd.nextInt(41) + 40))
                        .withCountOfRooms(rd.nextInt(3) + 1)
                        .withFloor(rd.nextInt(5) + 1)
                        .withIsPopulated(false)
                        .withHouse(house)
                        .build();
                flatDao.save(flat);
            }
        }
        System.out.println("All the flats and houses are generated");
    }
}
