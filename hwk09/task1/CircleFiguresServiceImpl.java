package com.gmail.evanloafakahaitao.hwk09.task1;

public class CircleFiguresServiceImpl extends FiguresService {
    
    private double radius;
    private double perimeter;
    private double area;
    
    public CircleFiguresServiceImpl(int radius) {
        this.radius = radius;
    }
    
    @Override
    public double calcPerimeter() {
        this.perimeter = 2 * Math.PI * this.radius;
        return this.perimeter;
    }
    
    @Override
    public double calcArea() {
        this.area = Math.PI * this.radius * this.radius;
        return this.area;
    }
}
