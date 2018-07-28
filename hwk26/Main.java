package com.gmail.evanloafakahaitao.hwk26;

import com.gmail.evanloafakahaitao.hwk26.sqltask.CityApp;

/**
 * 1. Создать базу данных city
 * 2. Создать две таблицы Flat(id, size(40-80), countOfRooms(1-3), floor(1-5), isPopulated(false), house_id) и House(id, address). У Flat должно быть поле house_id, которое должно быть связано полем id
 * 2. Создать два класса
 * class Flat{
 * private Long id;
 * private String size;
 * private Integer countOfRooms;
 * private Integer floor;
 * private boolean isPopulated;
 * private House house;
 * }
 * class House{
 * private Long id;
 * private String address;
 * }
 * 2. Создать два интерфейса и их имплементации
 * interface FlatDao {
 * void save(Flat flat);
 * Flat getById(Long id);
 * }
 * interface HouseDao {
 * void save(House house);
 * List<House> getHouses();
 * }
 * 3. Написать метод в GeneratorService(должен быть singleton) который генерирует 3 дома по 20 квартир в каждом.
 * 4. Написать метод, который заселяет однокомнатные квартиры размером меньше 50 в каждом доме.
 * 6. Вывести количество заселенных квартир на экран в виде одного запроса, который достанет из базы данных все заселенные квартиры и выведет на экран.
 */

public class Main {
    
    public static void main(String[] args) {
        new CityApp().runApp();
    }
}
