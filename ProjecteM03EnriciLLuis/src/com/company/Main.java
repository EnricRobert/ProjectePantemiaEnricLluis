package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = 1;
        int x = 0;
        int y = 0;
        int[][] twoDimArrray = new int[0][0];
        while (option != 0) {
            System.out.println("MENÚ");
            System.out.println("1. Crear taulell random");
            System.out.println("2. Crear taulell manual");
            System.out.println("3. Introduir malalts");
            System.out.println("4. Transmetre virus");
            System.out.println("5. Curar malalts");
            System.out.println("6. Desplaçar malats");
            System.out.println("7. Mostrar informació");
            System.out.println("0. Sortir");
            option = in.nextInt();
            if (option == 1) { //Crear un taulell random
                x = (int) ((float) Math.random() * 10);
                y = (int) ((float) Math.random() * 10);
                twoDimArrray = new int[x][y];
                for (x = 0; x < twoDimArrray.length; x++) {
                    for (y = 0; y < twoDimArrray[x].length; y++) {
                        twoDimArrray[x][y] = (int) ((float) Math.random() * 10);
                        System.out.print(twoDimArrray[x][y]);

                    }
                    System.out.println();
                }
            }
            if (option == 2) { //Crear taulell manual
                System.out.println("Has seleccionat crear el teu propi taulell");
                System.out.println("Escriu les files desitjades del taulell");
                x = in.nextInt();
                System.out.println("Escriu les columnes desitjades del taulell");
                y = in.nextInt();
                twoDimArrray = new int[x][y];
                for (x = 0; x < twoDimArrray.length; x++) {
                    System.out.println();
                    for (y = 0; y < twoDimArrray[x].length; y++) {
                        System.out.print(twoDimArrray[x][y]);
                    }
                }
                System.out.println();
            }
            if (option == 3) { //Introduir malalts
                int next = 0;
                while (next == 0) {
                    int x2 = 0;
                    while (x2 == 0 || x2 > x) {
                        System.out.println("Introdueix la fila");
                        x2 = in.nextInt();
                    }
                    int y2 = 0;
                    while ((y2 == 0 || y2 > y) && x2 != 0) {
                        System.out.println("Introdueix la columna");
                        y2 = in.nextInt();
                    }
                    if (x2 != 0 && y2 != 0) {
                        System.out.println("Introdueix el número de persones infectades a la casella");
                        twoDimArrray[x2 - 1][y2 - 1] = in.nextInt();
                        for (x = 0; x < twoDimArrray.length; x++) {
                            System.out.println();
                            for (y = 0; y < twoDimArrray[x].length; y++) {
                                System.out.print(twoDimArrray[x][y]);
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("Vols introduir nous malalts o modificar una casella?\nPrem 0 en cas afirmatiu\nPrem 1 en cas negatiu");
                    next = in.nextInt();
                }
            }
            if (option == 4) { //Transmetre virus
                System.out.println("Introdueix el ratio de transmisió");
                float rt = in.nextFloat();
                for (int i = 0; i < twoDimArrray.length; i++) {
                    for (int j = 0; j < twoDimArrray[0].length; j++) {
                        twoDimArrray[i][j] = (int) (twoDimArrray[i][j] * rt) + twoDimArrray[i][j];
                    }
                    System.out.println(Arrays.toString(twoDimArrray[i]));
                }

            }
            if (option == 5) { //Curar malalts
                float percentage = 0;
                int valor = 0;
                System.out.println("Vols curar-los globalment o concretament?");
                String deicition1 = in.next();
                System.out.println("Percentatge o valor?");
                String deicition2 = in.next().toLowerCase();
                if (deicition2.equals("percentatge")) {
                    System.out.println("Quin %?");
                    percentage = in.nextFloat();
                }
                if (deicition2.equals("concretament")) {
                    System.out.println("Quin valor?");
                    valor = in.nextInt();
                }
                if (deicition1.equals("globalment")) {
                    int healMalalts = 0;
                    float healMalaltsx = 0;
                    if (valor == 0) {
                        healMalaltsx = percentage;
                    } else {
                        healMalalts = valor;
                    }
                    for (int i = 0; i < twoDimArrray.length; i++) {
                        for (int j = 0; j < twoDimArrray[0].length; j++) {
                            if (twoDimArrray[i][j] >= healMalalts) {
                                if (valor == 0) {
                                    int valortotal = (int) ((twoDimArrray[i][j] * healMalaltsx) / 100);
                                    twoDimArrray[i][j] = twoDimArrray[i][j] - valortotal;
                                } else {
                                    twoDimArrray[i][j] = twoDimArrray[i][j] - healMalalts;
                                }

                            }

                        }
                        System.out.println(Arrays.toString(twoDimArrray[i]));
                    }
                }
                if (deicition1.equals("concretament")) {
                    int x2 = 0;
                    while (x2 == 0 || x2 > x) {
                        System.out.println("Introdueix la fila");
                        x2 = in.nextInt();
                    }
                    int y2 = 0;
                    while ((y2 == 0 || y2 > y) && x2 != 0) {
                        System.out.println("Introdueix columna");
                        y2 = in.nextInt();
                    }
                    if (x2 != 0 && y2 != 0) {
                        System.out.println("Quantitat de malalts a curar");
                        int healMalalts = in.nextInt();
                        if (twoDimArrray[x2 - 1][y2 - 1] >= healMalalts) {
                            twoDimArrray[x2 - 1][y2 - 1] = twoDimArrray[x2 - 1][y2 - 1] - healMalalts;
                        }
                    }
                    System.out.println(Arrays.toString(twoDimArrray[x]));
                }
            }
            if (option == 6) { //Desplaçar malalts
                int x2 = 0;
                while (x2 == 0 || x2 > x) {
                    System.out.println("Introdueix la fila");
                    x2 = in.nextInt();
                }
                int y2 = 0;
                while ((y2 == 0 || y2 > y) && x2 != 0) {
                    System.out.println("Introdueix la columna");
                    y2 = in.nextInt();
                }
                System.out.println("Introdueix el número de malalts que es volen desplaçar");
                int numMalalts = in.nextInt();
                System.out.println("En quina direcció?\nq(dalt esquerra)\nw(endavant)\ne(dalt dreta)\na(esquerra)\nd(dreta)\nz(baix esquerra)\nx(baix)\nc(baix dreta)");
                String direction = in.next();
                switch (direction) {
                    case "q":
                        twoDimArrray[x2][y2] = twoDimArrray[x2][y2] - numMalalts;
                        twoDimArrray[x2 - 1][y2 - 1] = twoDimArrray[x2 - 1][y2 - 1] + numMalalts;
                        break;
                    case "w":
                        twoDimArrray[x2][y2] = twoDimArrray[x2][y2] - numMalalts;
                        twoDimArrray[x2 - 1][y2] = twoDimArrray[x2 - 1][y2] + numMalalts;
                        break;
                    case "e":
                        twoDimArrray[x2][y2] = twoDimArrray[x2][y2] - numMalalts;
                        twoDimArrray[x2 - 1][y2 + 1] = twoDimArrray[x2 - 1][y2 + 1] + numMalalts;
                        break;
                    case "a":
                        twoDimArrray[x2][y2] = twoDimArrray[x2][y2] - numMalalts;
                        twoDimArrray[x2][y2 - 1] = twoDimArrray[x2][y2 - 1] + numMalalts;
                        break;
                    case "d":
                        twoDimArrray[x2][y2] = twoDimArrray[x2][y2] - numMalalts;
                        twoDimArrray[x2][y2 + 1] = twoDimArrray[x2][y2 + 1] + numMalalts;
                        break;
                    case "z":
                        twoDimArrray[x2][y2] = twoDimArrray[x2][y2] - numMalalts;
                        twoDimArrray[x2 + 1][y2 - 1] = twoDimArrray[x2 + 1][y2 - 1] + numMalalts;
                        break;
                    case "x":
                        twoDimArrray[x2][y2] = twoDimArrray[x2][y2] - numMalalts;
                        twoDimArrray[x2 + 1][y2] = twoDimArrray[x2 + 1][y2] + numMalalts;
                        break;
                    case "c":
                        twoDimArrray[x2][y2] = twoDimArrray[x2][y2] - numMalalts;
                        twoDimArrray[x2 + 1][y2 + 1] = twoDimArrray[x2 + 1][y2 + 1] + numMalalts;
                        break;
                }
                if (x2 != 0 && y2 != 0) {
                    for (x = 0; x < twoDimArrray.length; x++) {
                        System.out.println();
                        for (y = 0; y < twoDimArrray[x].length; y++) {
                            System.out.print(twoDimArrray[x][y]);
                        }
                    }
                    System.out.println();
                }
            }
            if (option == 7) {
                for (x = 0; x < twoDimArrray.length; x++) {
                    System.out.println();
                    for (y = 0; y < twoDimArrray[x].length; y++) {
                        System.out.print(twoDimArrray[x][y]);
                    }
                }
                System.out.println();
            }
        }
        System.out.println("GAME OVER");
    }
}