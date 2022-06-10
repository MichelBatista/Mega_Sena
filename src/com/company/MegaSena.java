package com.company;

import java.util.Scanner;

public class MegaSena {
    public int getQuantidadeDeNumeros() {
        return quantidadeDeNumeros;
    }

    public void setQuantidadeDeNumeros(int quantidadeDeNumeros) {
        this.quantidadeDeNumeros = quantidadeDeNumeros;
    }

    public int getQuantidadeDeRodadas() {
        return quantidadeDeRodadas;
    }

    public void setQuantidadeDeRodadas(int quantidadeDeRodadas) {
        this.quantidadeDeRodadas = quantidadeDeRodadas;
    }

    public int quantidadeDeNumeros;
    private int quantidadeDeRodadas;

    public static int setarQuantidadeDeNumeros() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos numeros (6 a ****): ");
        return scanner.nextInt();
    }

    public void validarQuantidadeDeNumeros() {
        if (this.getQuantidadeDeNumeros() < 6) {
            System.out.println("--------------------\nQuantidade de numeros invalido.");
            System.exit(0);
        }
    }

    public static int setarQuantidadeDeRodadas() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantas rodadas (1 a ****): ");
        return scanner.nextInt();
    }

    public void validarQuantidadeDeRodadas() {
        Scanner scanner = new Scanner(System.in);
        if (this.getQuantidadeDeRodadas() < 1) {
            System.out.println("--------------------\nQuantidade de rodadas invalida.");
            System.exit(0);
        }
    }

    public void setarNumerosDaSorte(int[] numerosDaSorte) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < getQuantidadeDeNumeros(); i++) {
            System.out.print("Digite o " + (i + 1) + " numero (1 a 60): ");
            numerosDaSorte[i] = scanner.nextInt();
        }
    }

    public void validarNumerosDaSorte(int[] numerosDaSorte) {
        for (int i = 0; i < getQuantidadeDeNumeros(); i++) {
            if (numerosDaSorte[i] < 0 || numerosDaSorte[i] > 60) {
                System.out.println("--------------------\nVocê digitou algum numero invalido.");
                System.exit(0);
            }
        }
    }

    public void mostrarSeusNumerosDaSorte(int[] numerosDaSorte) {
        System.out.print("\nSeus numeros foram: ");
        for (int i = 0; i < getQuantidadeDeNumeros(); i++) {
            System.out.print("[" + numerosDaSorte[i] + "] - ");
        }
    }

    public void gerarNumerosAleatorios(long[][] numerosGerados) {
        for (int i = 0; i < this.getQuantidadeDeRodadas(); i++) {
            for (int j = 0; j < this.getQuantidadeDeNumeros(); j++) {
                numerosGerados[i][j] = (long) gerarNumerosAleatorios();
            }
        }
    }

    public void verificarNumerosGeradosIguais(long[][] numerosGerados) {
        for (int i = 0; i < this.getQuantidadeDeRodadas(); i++) {
            for (int j = 0; j < this.getQuantidadeDeNumeros(); j++) {
                for (int x = 0; x < j; x++) {
                    if (numerosGerados[i][j] == numerosGerados[i][x]) {
                        numerosGerados[i][j] = (long) gerarNumerosAleatorios();
                    }
                }
            }
        }
    }

    public void mostrarNumerosGeradosNasRodadas(long[][] numerosGerados) {
        for (int i = 0; i < this.getQuantidadeDeRodadas(); i++) {
            System.out.print("\nRodada " + (i + 1) + ": ");
            for (int j = 0; j < this.getQuantidadeDeNumeros(); j++) {
                System.out.print("[" + numerosGerados[i][j] + "] - ");
            }
        }
    }

    public double gerarNumerosAleatorios() {
        double numerosAleatorios = Math.random() * 60;
        if (Math.round(numerosAleatorios) == 0) {
            while (Math.round(numerosAleatorios) == 0) {
                numerosAleatorios = Math.random() * 60;
            }
        }
        return Math.round(numerosAleatorios);
    }
}