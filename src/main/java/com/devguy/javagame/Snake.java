package com.devguy.javagame;

import java.awt.Point;
import java.util.Scanner;

public class Snake {

    public static void main(String[] args) {
        //Objekte und Spielfeld erstellen
        Point spielerPosition = new Point(10, 9);
        Point snakePosition = new Point(30, 15);
        Point goldPosition = new Point(6, 6);
        Point doorPosition = new Point(2, 5);
        boolean goOn = true;
        boolean goldEingesammelt = false;

        //Spielfeld 10x40
        while (goOn) {
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 40; x++) {
                    Point p = new Point(x, y);
                    if (p.equals(spielerPosition))
                        System.out.print("P");
                    else if (p.equals(snakePosition))
                        System.out.print("S");
                    else if (p.equals(goldPosition))
                        System.out.print("G");
                    else if (p.equals(doorPosition))
                        System.out.print("D");
                        //vertical lines
                    else System.out.print(" . ");
                }
                //horizontal lines
                System.out.println();
            }
            //Spiellogik
            if (snakePosition.equals(spielerPosition)) {
                goOn = false;
                System.out.println("Zzz... Die Schlange hat dich.");
            }
            if (spielerPosition.equals(goldPosition)) {
                goldEingesammelt = true;
                goldPosition = new Point(-1, -1);
            }
            if (spielerPosition.equals(doorPosition) && goldEingesammelt) {
                goOn = false;
                System.out.println("Gewonnen!");
            }
            movePlayer(spielerPosition);
            moveSnake(snakePosition, spielerPosition);
        }
    }

    private static void moveSnake(Point snakePosition, Point spielerPosition) {
        if (spielerPosition.x < snakePosition.x)
            snakePosition.x--;
        else if (spielerPosition.x > snakePosition.x)
            snakePosition.x++;
        if (spielerPosition.y < snakePosition.y)
            snakePosition.y--;
        else if (spielerPosition.y > snakePosition.y)
            snakePosition.y++;
    }


    private static void movePlayer(Point spielerPosition) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        if (input.equals("hoch")) {
            if (spielerPosition.y > 0)
                spielerPosition.y--;
        } else if (input.equals("runter")) {
            if (spielerPosition.y < 9)
                spielerPosition.y++;
        } else if (input.equals("links")) {
            if (spielerPosition.x > 0)
                spielerPosition.x--;
        } else if (input.equals("rechts")) {
            if (spielerPosition.x < 39)
                spielerPosition.x++;
        }
    }
}

