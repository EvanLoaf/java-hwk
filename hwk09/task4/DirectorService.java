package com.gmail.evanloafakahaitao.hwk09.task4;

public class DirectorService implements PositionOutput {
    
    private String className;
    private int lastDotIndex = -1;
    
    @Override
    public void printPosition() {
        String cl = this.getClass().toString();
        for (int i = 0; i < cl.length(); ++i) {
            if (cl.charAt(i) == '.') {
                lastDotIndex = i;
            }
        }
        className = cl.substring(lastDotIndex + 1);
        switch (className) {
            case "DirectorService":
                System.out.print("Position: ");
                System.out.println(this.POSITIONS[0]);
                break;
            case "AccountantService":
                System.out.print("Position: ");
                System.out.println(this.POSITIONS[1]);
                break;
            case "WorkerService":
                System.out.print("Position: ");
                System.out.println(this.POSITIONS[2]);
                break;
            default:
                System.out.println("Error, no such position in database.");
        }
    }
}
