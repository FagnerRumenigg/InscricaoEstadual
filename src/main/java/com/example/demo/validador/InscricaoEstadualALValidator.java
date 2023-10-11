package com.example.demo.validador;

public class InscricaoEstadualALValidator {

    public static void isValidInscricaoEstadual(String inscricaoEstadual) throws Exception {
        String digits = inscricaoEstadual.replaceAll("\\D", "");

        if (inscricaoEstadual.length() != 9) {
            throw new Exception("Size Invalid"); // Tamanho inv�lido
        }

        if (!inscricaoEstadual.matches("^24[03578]\\d{6}$")) {
            throw new Exception("Format Invalid");// Formato inv�lido
        }

        int[] weights = { 9, 8, 7, 6, 5, 4, 3, 2 };
        int sum = 0;
        for (int i = 0; i < digits.length() - 1; i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            sum += digit * weights[i];

        }

        sum = sum * 10;

        Integer inteiro = sum / 11;
        Integer resto = 11 * inteiro;
        int remainder = sum - resto;
        int verifierDigit;

        if (remainder == 10) {
            verifierDigit = 0;
        } else {
            verifierDigit = remainder;
        }

        int lastDigit = Character.getNumericValue(inscricaoEstadual.charAt(inscricaoEstadual.length() - 1));
        if (verifierDigit != lastDigit) {
            throw new Exception("Digit Invalid");
        }
        ;
    }

    public static String generateDigit(String inscricaoEstadualNoDigit) throws Exception {

        int[] weights = { 9, 8, 7, 6, 5, 4, 3, 2 };
        int sum = 0;
        for (int i = 0; i < inscricaoEstadualNoDigit.length(); i++) {
            int digit = Character.getNumericValue(inscricaoEstadualNoDigit.charAt(i));
            sum += digit * weights[i];

        }

        sum = sum * 10;

        Integer inteiro = sum / 11;
        Integer resto = 11 * inteiro;
        int remainder = sum - resto;
        int verifierDigit;

        if (remainder == 10) {
            verifierDigit = 0;
        } else {
            verifierDigit = remainder;
        }
        String inscricaoEstadualWithDigit = inscricaoEstadualNoDigit.concat(String.valueOf(verifierDigit));
        return inscricaoEstadualWithDigit;
    }
}