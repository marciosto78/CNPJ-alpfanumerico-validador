package br.com.cnpj.validador;

import br.com.cnpj.constants.Const;
import lombok.NonNull;

import java.util.HashMap;

public class ValidacaoCnpj {

    @NonNull
    private static final HashMap<String, Integer> caracterValor = new HashMap<>() {
        {
            for (char c = Const.N_48; c <= Const.N_90 ; c++) {
                if(c < Const.N_58 || c >Const.N_64){
                    put(String.valueOf(c), (int) c - Const.N_48);
                }
            }
        }
    };

    static int[] weight1 = {Const.N_5, Const.N_4, Const.N_3, Const.N_2, Const.N_9, Const.N_8, Const.N_7,
            Const.N_6, Const.N_5, Const.N_4, Const.N_3, Const.N_2};
    static int[] weight2 = {Const.N_6, Const.N_5, Const.N_4, Const.N_3, Const.N_2, Const.N_9, Const.N_8,
            Const.N_7, Const.N_6, Const.N_5, Const.N_4, Const.N_3, Const.N_2};

    public static boolean isValidCNPJ(String cnpjEntrada) {
        var cnpj = completeCnpj(cnpjEntrada, Const.N_14);
        int digit1 = calcularDigito(cnpj.substring(0, Const.N_12), weight1);
        int digit2 = calcularDigito(cnpj.substring(0, Const.N_12) + digit1, weight2);
        return cnpj.equals(cnpj.substring(0, Const.N_12) + digit1 + digit2);
    }

    public static String digitoCNPJ(String cnpjEntrada) {
        var cnpj = completeCnpj(cnpjEntrada, Const.N_12);
        int digit1 = calcularDigito(cnpj.substring(0, Const.N_12), weight1);
        int digit2 = calcularDigito(cnpj.substring(0, Const.N_12) + digit1, weight2);
        return String.valueOf(digit1).concat(String.valueOf(digit2));
    }

    private static int calcularDigito(String str, int[] weight) {
        int sum = 0;
        for (int i = str.length() - 1, digit; i >= 0; i--) {
            digit = caracterValor.get(str.substring(i, i + 1));
            sum += digit * weight[weight.length - str.length() + i];
        }
        sum = Const.N_11 - sum % Const.N_11;
        return sum > Const.N_9 ? 0 : sum;
    }

    private static String completeCnpj(String cnpjEntrada, int tamanho){
        var cnpj = cnpjEntrada.replaceAll("[./-]", "");
        while (cnpj.length()<tamanho){
            cnpj = "0".concat(cnpj);
        }
        return cnpj;
    }
}
