package service;

import entity.Cat;

import java.util.List;

public class Service {
    public static void print(List<Cat> cats) {
        System.out.println("---+-----------+---------+--------+--------+---------+---------+");
        System.out.println(" # |    Name   |   Age   | Health |  Mood  | Satiety | Average |");
        System.out.println("---+-----------+---------+--------+--------+---------+---------+");
        for (int i = 0; i < cats.size(); i++) {
            System.out.print(" ");
            System.out.print(i + 1);
            System.out.print(" |");
            System.out.print(cats.get(i));
            System.out.printf("%6s   |", cats.get(i).getAverage());
            System.out.println();
        }
        System.out.println("---+-----------+---------+--------+--------+---------+---------+");
    }
}
