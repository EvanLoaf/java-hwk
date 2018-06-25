package com.gmail.evanloafakahaitao.hwk12.task3;

public enum Volume {
    
    LOW("Can barely hear"),
    MEDIUM("Loud enough"),
    HIGH("Way too loud");
    
    private final String volumeDescription;
    
    Volume(String volumeDescr) {
        this.volumeDescription = volumeDescr;
    }
    
    public String getVolumeDescr() {
        return volumeDescription;
    }
}
