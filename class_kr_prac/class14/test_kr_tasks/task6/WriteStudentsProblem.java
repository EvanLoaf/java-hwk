package com.gmail.evanloafakahaitao.class_kr_prac.class14.test_kr_tasks.task6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WriteStudentsProblem {

    private List<Student> listOfStudents = new ArrayList<>();

    public void writeStudentsToFile(String path) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            Random rd = new Random();
            for (int i = 0; i < 10; i++) {

                int number = i + 1;
                Student stud = new Student(
                        number,
                        String.format("Mister Student, Name%d, Surname%d", number, number),
                        rd.nextInt(11),
                        rd.nextInt(11),
                        rd.nextInt(11)
                );
                listOfStudents.add(stud);

                bw.write(stud.toString());
                bw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readPrintFIle(String path) {

        String str = null;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            str = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Our students: \n%s", str);
    }

    public void changeStudent(String path) {

        Scanner in = new Scanner(System.in);
        System.out.println("Student number to change fio: ");
        int numOfStudToChange = in.nextInt();
        in.nextLine();
        System.out.println("Enter new fio: ");
        String newFio = in.nextLine();

        listOfStudents.get(numOfStudToChange - 1).setFio(newFio);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            for (int i = 0; i < listOfStudents.size(); i++) {

                bw.write(listOfStudents.get(i).toString());
                bw.write(System.lineSeparator());
                System.out.println(listOfStudents.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
