package com.company;

public class Principal {
    public static void main(String[] args) {
        MegaSena megaSena = new MegaSena();

        //SETAR QUANTIDADE DE NUMEROS
        megaSena.setQuantidadeDeNumeros(MegaSena.setarQuantidadeDeNumeros());
        megaSena.validarQuantidadeDeNumeros();

        //SETAR QUANTIDADE DE RODADAS
        megaSena.setQuantidadeDeRodadas(MegaSena.setarQuantidadeDeRodadas());
        megaSena.validarQuantidadeDeRodadas();

        //INFORMAR NUMEROS DA SORTE
        int[] numerosDaSorte = new int[megaSena.getQuantidadeDeNumeros()];
        megaSena.setarNumerosDaSorte(numerosDaSorte);
        megaSena.validarNumerosDaSorte(numerosDaSorte);

        //GERAR NUMEROS ALEATORIOS (PARA CADA RODADA)
        long[][] numerosGerados = new long[megaSena.getQuantidadeDeRodadas()][megaSena.getQuantidadeDeNumeros()];
        megaSena.gerarNumerosAleatorios(numerosGerados);
        megaSena.verificarNumerosGeradosIguais(numerosGerados);

        //MOSTRAR NUMEROS (DA SORTE, E GERADOS)
        megaSena.mostrarSeusNumerosDaSorte(numerosDaSorte);
        imprimirTraco();
        megaSena.mostrarNumerosGeradosNasRodadas(numerosGerados);

    }

    private static void imprimirTraco() {
        System.out.println("\n\n===========================================================================================================================================");
    }
}

