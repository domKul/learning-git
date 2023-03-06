package com.example.sudoku;

import java.util.Scanner;

public class KamienPapierNozyce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"kamień", "papier", "nożyce"};

        while (true) {
            // Gracz wybiera opcję
            System.out.println("Wybierz opcję: 0 - kamień, 1 - papier, 2 - nożyce");
            int playerOption = scanner.nextInt();

            // Komputer wybiera losową opcję
            int computerOption = (int) (Math.random() * 3);

            // Wyświetlenie wyborów gracza i komputera
            System.out.println("Gracz wybrał: " + options[playerOption]);
            System.out.println("Komputer wybrał: " + options[computerOption]);

            // Sprawdzenie wyniku gry
            int result = (playerOption - computerOption + 3) % 3;
            if (result == 0) {
                System.out.println("Remis!");
            } else if (result == 1) {
                System.out.println("Wygrałeś!");
            } else {
                System.out.println("Przegrałeś!");
            }

            // Zapytanie o kontynuowanie gry
            System.out.println("Czy chcesz kontynuować grę? 0 - nie, 1 - tak");
            int continueOption = scanner.nextInt();
            if (continueOption == 0) {
                break;
            }
        }
    }
}