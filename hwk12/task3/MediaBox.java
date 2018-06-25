package com.gmail.evanloafakahaitao.hwk12.task3;

import com.gmail.evanloafakahaitao.util.InputService;

public class MediaBox {
    
    private InputService input = new InputService();
    private Volume currentVolume;
    
    public MediaBox(Volume currentVolume) {
        this.currentVolume = currentVolume;
    }
    
    public void changeVolume() {
        System.out.println("Please, type in \'+\' to increase volume, \'-\' to decrease volume or 0 to Exit.");
        String volumeChangeVector = input.getString();
        if (volumeChangeVector.equals("+")) {
            int index = this.currentVolume.ordinal();
            if (index < Volume.values().length - 1) {
                this.currentVolume = Volume.values()[index + 1];
                System.out.printf("Current volume: %s %s\n", currentVolume.name(), currentVolume.getVolumeDescr());
            } else {
                System.out.println("Its already at max volume!");
                System.out.printf("Current volume: %s %s\n", currentVolume.name(), currentVolume.getVolumeDescr());
            }
        } else if (volumeChangeVector.equals("-")) {
            int index = this.currentVolume.ordinal();
            if (index > 0) {
                this.currentVolume = Volume.values()[index - 1];
                System.out.printf("Current volume: %s %s\n", currentVolume.name(), currentVolume.getVolumeDescr());
            } else {
                System.out.println("Its already at min volume!");
                System.out.printf("Current volume: %s %s\n", currentVolume.name(), currentVolume.getVolumeDescr());
            }
        } else if (volumeChangeVector.equals("0")) {
            return;
        } else {
            changeVolume();
        }
        
    }
}
