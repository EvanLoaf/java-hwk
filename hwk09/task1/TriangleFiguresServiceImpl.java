package com.gmail.evanloafakahaitao.hwk09.task1;

public class TriangleFiguresServiceImpl extends FiguresService {
    
    // I'll use only one method of calculating S here
    private double sideA;
    private double sideB;
    private double sideC;
    private double perimeter;
    private double area;
    
    public TriangleFiguresServiceImpl(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    @Override
    public double calcPerimeter() {
        this.perimeter = this.sideA + this.sideB + this.sideC;
        return this.perimeter;
    }
    
    @Override
    public double calcArea() {
        this.area = Math.sqrt(this.perimeter / 2 * (this.perimeter / 2 - this.sideA) * (this.perimeter / 2 - this.sideB) * (this.perimeter / 2 - this.sideC));
        return this.area;
    }
}
