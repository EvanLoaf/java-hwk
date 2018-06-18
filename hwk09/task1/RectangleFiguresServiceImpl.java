package com.gmail.evanloafakahaitao.hwk09.task1;

public class RectangleFiguresServiceImpl extends FiguresService {
    
    private double sideA;
    private double sideB;
    private double perimeter;
    private double area;
    
    public RectangleFiguresServiceImpl(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }
    
    @Override
    public double calcPerimeter() {
        this.perimeter = 2 * this.sideA + 2 * this.sideB;
        return this.perimeter;
    }
    
    @Override
    public double calcArea() {
        this.area = this.sideA * this.sideB;
        return this.area;
    }
}
