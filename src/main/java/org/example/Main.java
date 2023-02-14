package org.example;

import javax.swing.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###,###.00");
        int continua = 13;
        do{
            String opcao = JOptionPane.showInputDialog(null, "Selecione a Opção desejada", "Menu", JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Selecione uma Opção", "Conversor de Moedas", "Conversor de Medidas BR para US"}, "Escolha").toString();
            if(opcao.equals("Conversor de Moedas")) {
                String entrada = JOptionPane.showInputDialog(null, "Selecione a Moeda de Origem", "Menu", JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Selecione uma Opção", "Real", "Dolar", "Euro"}, "Escolha").toString();
                String saida = JOptionPane.showInputDialog(null, "Selecione a Moeda de Destino", "Menu", JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Selecione uma Opção", "Real", "Dolar", "Euro"}, "Escolha").toString();
                String valor = JOptionPane.showInputDialog("Insira um valor:");
                ConversorDeMoedas(Double.parseDouble(valor), entrada, saida);
                JOptionPane.showMessageDialog(null, "Equivale a: " + df.format(ConversorDeMoedas(Double.parseDouble(valor), entrada, saida)) + " " + saida);

            } else if (opcao.equals("Conversor de Medidas BR para US")) {
                String entrada = JOptionPane.showInputDialog(null, "Selecione a Medida de Origem", "Menu", JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Selecione uma Opção", "Metros", "Centimetros"}, "Escolha").toString();
                String saida = JOptionPane.showInputDialog(null, "Selecione a Medida de Destino", "Menu", JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Selecione uma Opção", "Pes", "Polegadas", "Jardas"}, "Escolha").toString();
                String valor = JOptionPane.showInputDialog("Insira um valor:");
                JOptionPane.showMessageDialog(null, "Equivale a: " + ConversorDistancias(Double.parseDouble(valor), entrada, saida) + " " + saida);
            }

            continua = JOptionPane.showConfirmDialog(null, "Deseja Continuar?", "Selecione a Opção desejada:", JOptionPane.YES_NO_OPTION);
        }
        while(continua == 0);

    }

    public static Double ConversorDeMoedas(Double valor, String entrada, String saida) {
        //the base coins used are Real and American Dollar;
        Double dolarReal = 5.16;
        Double euroReal = 5.53;
        Double euroDolar = 0.93;

        switch (entrada+saida) {
            case "RealDolar":
                return valor/dolarReal;
            case "RealEuro":
                return valor/euroReal;
            case "DolarReal":
                return valor * dolarReal;
            case "DolarEuro":
                return valor * euroDolar;
            case "EuroReal":
                return valor * euroReal;
            case "EuroDolar":
                return valor / euroDolar;
            default:
                return null;
        }
    }

    public static Double ConversorDistancias(Double valor, String entrada, String saida) {
        //the base used to convertions is the meter.
        Double polegada = 0.0254;
        Double pe = 0.3048;
        Double jarda = 0.9144;

        switch (entrada+saida) {
            case "MetrosPolegadas":
                return valor / polegada;
            case "MetrosPes":
                return valor / pe;
            case "MetrosJardas":
                return valor / jarda;
            case "CentimetrosPolegadas":
                return valor / polegada / 100;
            case "CentimetrosPes":
                return valor / pe / 100;
            case "CentimetrosJardas":
                return valor / jarda / 100;
            default:
                return null;
        }
    }
}