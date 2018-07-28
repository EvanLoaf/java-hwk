package com.gmail.evanloafakahaitao.hwk26.sqltask.dao.model;

public class Flat {

    private Long id;
    private String size;
    private Integer countOfRooms;
    private Integer floor;
    private boolean isPopulated;
    private House house;

    public Flat(Builder builder) {
        this.id = builder.id;
        this.size = builder.size;
        this.countOfRooms = builder.countOfRooms;
        this.floor = builder.floor;
        this.isPopulated = builder.isPopulated;
        this.house = builder.house;
    }

    public Flat(Long id, String size, Integer countOfRooms, Integer floor, boolean isPopulated) {
        this.size = size;
        this.countOfRooms = countOfRooms;
        this.floor = floor;
        this.isPopulated = isPopulated;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getCountOfRooms() {
        return countOfRooms;
    }

    public void setCountOfRooms(Integer countOfRooms) {
        this.countOfRooms = countOfRooms;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public boolean isPopulated() {
        return isPopulated;
    }

    public void setPopulated(boolean populated) {
        isPopulated = populated;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", countOfRooms=" + countOfRooms +
                ", floor=" + floor +
                ", isPopulated=" + isPopulated +
                ", house=" + house +
                '}';
    }
    
    public static class Builder {
    
        private Long id;
        private String size;
        private Integer countOfRooms;
        private Integer floor;
        private boolean isPopulated;
        private House house;
        
        private Builder() {}
        
        public Builder withId(Long val) {
            id = val;
            return this;
        }
    
        public Builder withSize(String val) {
            size = val;
            return this;
        }
    
        public Builder withCountOfRooms(Integer val) {
            countOfRooms = val;
            return this;
        }
    
        public Builder withFloor(Integer val) {
            floor = val;
            return this;
        }
    
        public Builder withIsPopulated(boolean val) {
            isPopulated = val;
            return this;
        }
    
        public Builder withHouse(Long houseId, String address) {
            House newHouse = new House(
                    houseId,
                    address
            );
            house = newHouse;
            return this;
        }
        
        public Builder withHouse(House house) {
            this.house = house;
            return this;
        }
        
        public Flat build() {
            return new Flat(this);
        }
    }
    
    public static Builder newBuilder() {
        return new Builder();
    }
}
