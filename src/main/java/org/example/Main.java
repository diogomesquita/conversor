package org.example;

import javax.swing.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###,###.00");
        int continua = 13;
        do{
            String opcao = JOptionPane.showInputDialog(null, "Selecione a Opção desejada", "Menu", JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Selecione uma Opção", "Conversor de Moedas", "Conversor de medidas"}, "Escolha").toString();
            if(opcao.equals("Conversor de Moedas")) {
                String entrada = JOptionPane.showInputDialog(null, "Selecione a Moeda de Origem", "Menu", JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Selecione uma Opção", "Real", "Dolar", "Euro"}, "Escolha").toString();
                String saida = JOptionPane.showInputDialog(null, "Selecione a Moeda de Destino", "Menu", JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Selecione uma Opção", "Real", "Dolar", "Euro"}, "Escolha").toString();
                String valor = JOptionPane.showInputDialog("Insira um valor:");
                ConversorDeMoedas(Double.parseDouble(valor), entrada, saida);
                JOptionPane.showMessageDialog(null, "Equivale a: " + df.format(ConversorDeMoedas(Double.parseDouble(valor), entrada, saida)) + " " + saida);

            } else if (opcao.equals("Conversor de Distâncias")) {
                String entrada = JOptionPane.showInputDialog(null, "Selecione a Medida de Origem", "Menu", JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Selecione uma Opção", "Metros", "Centímetros", "Quilometros"}, "Escolha").toString();
                String saida = JOptionPane.showInputDialog(null, "Selecione a Medida de Destino", "Menu", JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Selecione uma Opção", "Pés", "Polegadas", "Milhas, Jardas"}, "Escolha").toString();
                String valor = JOptionPane.showInputDialog("Insira um valor:");
                JOptionPane.showMessageDialog(null, "Equivale a: " + ConversorDistancias(Double.parseDouble(valor), entrada, saida) + " " + saida);
            }

            continua = JOptionPane.showConfirmDialog(null, "Deseja Continuar?", "Selecione a Opção desejada:", JOptionPane.YES_NO_OPTION);
        }
        while(continua == 0);

    }

    public static Double ConversorDeMoedas(Double valor, String entrada, String saida) {
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
        //1 polegada = 0,0254 metro
        //1 pé = 0,3048 metro
        //1 jarda = 0,9144 metro
        //1 milha = 1609,34 metros
        Double polegada = 2.54;
        Double pe = 0.3048;
        Double milha = 1609.34;
        Double jarda = 0.9144;

        switch (entrada+saida) {
            case "MetroPolegada":
                return valor / polegada;
            default:
                return null;
        }
    }
}