package com.gmail.evanloafakahaitao.hwk09;

import com.gmail.evanloafakahaitao.hwk09.task1.CircleFiguresServiceImpl;
import com.gmail.evanloafakahaitao.hwk09.task1.FiguresService;
import com.gmail.evanloafakahaitao.hwk09.task1.RectangleFiguresServiceImpl;
import com.gmail.evanloafakahaitao.hwk09.task1.TriangleFiguresServiceImpl;
import com.gmail.evanloafakahaitao.hwk09.task2.EnglandAutomobileServiceImpl;
import com.gmail.evanloafakahaitao.hwk09.task2.GermanyAutomobileServiceImpl;
import com.gmail.evanloafakahaitao.hwk09.task2.RussiaAutomobileServiceImpl;
import com.gmail.evanloafakahaitao.hwk09.task3.employees.LawyersPaymentEmployeesServiceAndMonthlySalaryImpl;
import com.gmail.evanloafakahaitao.hwk09.task3.employees.LoadersPaymentEmployeesServiceAndHourlyPaymentImpl;
import com.gmail.evanloafakahaitao.hwk09.task3.employees.SalesManagerPaymentEmployeesServiceAndBaseSalaryPlusPercentageOfSalesImpl;
import com.gmail.evanloafakahaitao.hwk09.task3.employees.SalesPersonPaymentEmployeesServiceAndPercOfSalesPaymentImpl;
import com.gmail.evanloafakahaitao.hwk09.task4.AccountantService;
import com.gmail.evanloafakahaitao.hwk09.task4.DirectorService;
import com.gmail.evanloafakahaitao.hwk09.task4.WorkerService;

import java.text.DecimalFormat;

/**
 * 1. Написать иерархию классов «Фигуры». Фигура -> Треугольник -> Прямоугольник -> Круг. Реализовать ф-ю подсчета площади для каждого типа фигуры и подсчет периметра. Создать массив из 5 фигур. Вывести на экран сумму периметра всех фигур в массиве.
 * 2. Создать класс Automobile. Сделать его абстрактным. Добавить в класс абстрактный метод  int getRate(). Добавить в класс метод String getDescription(), который возвращает строку "Automobile: ". Создать класс RussianAutomobile, который наследуется от Automobile. Создать класс GermanyAutomobile, который наследуется от Automobile. Cоздать класс EnglandAutomobile, который наследуется от Automobile. В каждом из классов написать свою реализацию метода getRate. Метод должен возвращать рейтинг автомобиля в зависимости от типа. В каждом из классов написать свою реализацию метода getDescription. Методы должны возвращать строку вида: <getDescription() родительского класса>  + <" Моя страна - Sssss. Рейтинг автомобиля N">, где Sssss - название страны, где N - рейтинг автомобиля
 * 3. Разработать программу для формирования платежной ведомости на предприятии.
 * a)Предусмотреть 4 типа сотрудников в зависимости от варианта расчета заработной платы:
 * месячная ставка
 * почасовая оплата
 * % от объема продаж
 * базовая месячная ставка + % от объема продаж
 * b)Для каждого сотрудника хранить имя, фамилию, информацию о должности (наименование,отдел)
 * 4. Создать классы "Директор", "Рабочий", "Бухгалтер". Реализовать интерфейс с методом, который печатает название должности и имплементировать этот метод в созданные классы.
 */

public class Main {
    
    public static void main(String[] args) {
        
        DecimalFormat numFormat = new DecimalFormat("#.##");
        
        // Task1
        System.out.println("\nTask1");
        FiguresService[] arrayOfFigures = new FiguresService[5];
        int radius1 = 115;
        FiguresService circle1 = new CircleFiguresServiceImpl(radius1);
        int rectSideA = 15;
        int rectSideB = 25;
        FiguresService rectangle = new RectangleFiguresServiceImpl(rectSideA, rectSideB);
        int triSideA = 8;
        int triSideB = 9;
        int triSideC = 10;
        FiguresService triangle = new TriangleFiguresServiceImpl(triSideA, triSideB, triSideC);
        arrayOfFigures[0] = circle1;
        arrayOfFigures[1] = rectangle;
        arrayOfFigures[2] = triangle;
        System.out.println("\nCircle perimeter: " + numFormat.format(circle1.calcPerimeter()) + "\narea: " + numFormat.format(circle1.calcArea()));
        System.out.println("\nRectangle perimeter: " + rectangle.calcPerimeter() + "\narea: " + rectangle.calcArea());
        System.out.println("\nTriangle perimeter: " + triangle.calcPerimeter() + "\narea: " + triangle.calcArea());
        // Calculating the sum of perimeters of figures in ArrayOfFigures
        int radius2 = 125;
        FiguresService circle2 = new CircleFiguresServiceImpl(radius2);
        arrayOfFigures[3] = circle2;
        int radius3 = 135;
        FiguresService circle3 = new CircleFiguresServiceImpl(radius3);
        arrayOfFigures[4] = circle3;
        // If my abstract class didnt have an abstract calcPerimeter method, I would use
        // Something like *((CircleFiguresServiceImpl)arrayOfFigures[0]).calcPerimeter()* below
        double sumOfPerimeters = arrayOfFigures[0].calcPerimeter() + arrayOfFigures[1].calcPerimeter() +
                arrayOfFigures[2].calcPerimeter() + arrayOfFigures[3].calcPerimeter() +
                arrayOfFigures[4].calcPerimeter();
        System.out.println("Perimeter of all five figures in my array: " + sumOfPerimeters);
        System.out.println("--------------------");
        
        // Task2
        System.out.println("\nTask2");
        // Hope I did this task correctly, code seems too short compared to the task..
        RussiaAutomobileServiceImpl rusCar = new RussiaAutomobileServiceImpl();
        System.out.println(rusCar.getDescription());
        GermanyAutomobileServiceImpl gerCar = new GermanyAutomobileServiceImpl();
        System.out.println(gerCar.getDescription());
        EnglandAutomobileServiceImpl engCar = new EnglandAutomobileServiceImpl();
        System.out.println(engCar.getDescription());
        System.out.println("--------------------");
        
        // Task3
        // Not the most universal method, but the task is not too specific either I guess
        System.out.println("\nTask3");
        LawyersPaymentEmployeesServiceAndMonthlySalaryImpl lawyer = new LawyersPaymentEmployeesServiceAndMonthlySalaryImpl("Alexey", "Ivanov", "Legal department", "Junior lawyer", 24);
        System.out.println(lawyer.getEmployeeInfo());
        System.out.println("--- Payment type: " + lawyer.TYPE);
        System.out.println("Salary: " + lawyer.calcPayment(lawyer.getLeaveHours()));
        LoadersPaymentEmployeesServiceAndHourlyPaymentImpl loader = new LoadersPaymentEmployeesServiceAndHourlyPaymentImpl("Vasiliy", "qweqwe", "sklad", "gruzchik", 144);
        System.out.println(loader.getEmployeeInfo());
        System.out.println("--- Payment type: " + loader.TYPE);
        System.out.println("Salary: " + loader.calcPayment(loader.getWorkingHours()));
        SalesPersonPaymentEmployeesServiceAndPercOfSalesPaymentImpl seller = new SalesPersonPaymentEmployeesServiceAndPercOfSalesPaymentImpl("Victoria", "abcde", "Sales dept", "Salesperson", 500);
        System.out.println(seller.getEmployeeInfo());
        System.out.println("--- Payment type: " + seller.TYPE);
        System.out.println("Salary: " + seller.calcPayment(seller.getSales()));
        SalesManagerPaymentEmployeesServiceAndBaseSalaryPlusPercentageOfSalesImpl salesManager = new SalesManagerPaymentEmployeesServiceAndBaseSalaryPlusPercentageOfSalesImpl("Nikolay", "asdasdasd", "Sales dept", "Manager", 2500);
        System.out.println(salesManager.getEmployeeInfo());
        System.out.println("--- Payment type: " + salesManager.TYPE);
        System.out.println("Salary: " + salesManager.calcPayment(salesManager.getDepartmentSales()));
        System.out.println("--------------------");
        
        // Task4
        // Немного усложнил по сравнению с условием, хотелось проверить, можно ли, например, в абстрактном классе
        // как-то задать общий не абстрактный метод, который бы внутри класса-наследника
        // смог хоть какую-то проверку провести - где же этот метод оказался и что с этим делать
        System.out.println("\nTask4");
        DirectorService dir = new DirectorService();
        dir.printPosition();
        WorkerService worker = new WorkerService();
        worker.printPosition();
        AccountantService accountant = new AccountantService();
        accountant.printPosition();
        System.out.println("--------------------");
    }
}
