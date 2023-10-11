package com.example.demo.validador;

public class InscricaoEstadualACValidator {

    public static void isValidInscricaoEstadual(String inscricaoEstadual) throws Exception {
        String digits = inscricaoEstadual.replaceAll("\\D", "");

        if (digits.length() != 13) {
            throw new Exception("Size Invalid");
        }

        if (!inscricaoEstadual.matches("(01)\\.\\d{3}\\.\\d{3}/\\d{3}-\\d{2}")) {
            throw new Exception("Format Invalid");
        }

        int[] weights = { 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int sum = 0;

        for (int i = 0; i < digits.length() - 2; i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            sum += digit * weights[i];

        }
        int remainder = sum % 11;
        int verifierDigit;

        if (remainder == 10 || remainder == 11) {
            verifierDigit = 0;
        } else {
            verifierDigit = 11 - remainder;
        }

        digits.concat(String.valueOf(verifierDigit));

        int[] secondWeights = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        sum = 0;

        for (int i = 0; i < digits.length() - 1; i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            sum += digit * secondWeights[i];

        }

        remainder = sum % 11;

        int secondVerifierDigit;

        if (remainder == 10 || remainder == 11) {
            secondVerifierDigit = 0;
        } else {
            secondVerifierDigit = 11 - remainder;
        }

        int firstLastDigit = Character.getNumericValue(digits.charAt(digits.length() - 2));
        int secondLastDigit = Character.getNumericValue(digits.charAt(digits.length() - 1));

        if (verifierDigit != firstLastDigit || secondVerifierDigit != secondLastDigit) {
            throw new Exception("Digit Invalid");
        }
        ;
    }

    public static String addMask(String inscricaoEstadualNoMask) throws Exception {
        if (inscricaoEstadualNoMask.length() != 13) {
            throw new Exception("Size Invalid");
        }

        String parteUm = inscricaoEstadualNoMask.substring(0, 2);
        String parteDois = inscricaoEstadualNoMask.substring(2, 5);
        String parteTres = inscricaoEstadualNoMask.substring(5, 8);
        String parteQuatro = inscricaoEstadualNoMask.substring(8, 11);

        String digitos = inscricaoEstadualNoMask.substring(11, 13);

        String inscricaoEstadualWithMask = String.format("%s.%s.%s/%s-%s", parteUm, parteDois, parteTres, parteQuatro,
                digitos);
        return inscricaoEstadualWithMask;
    }

    public static String generateDigit(String inscricaoEstadualNoDigit) throws Exception {
        String digits = inscricaoEstadualNoDigit.replaceAll("\\D", "");

        int[] weights = { 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int sum = 0;

        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            sum += digit * weights[i];

        }
        int remainder = sum % 11;
        int verifierDigit;

        if (remainder == 10 || remainder == 11) {
            verifierDigit = 0;
        } else {
            verifierDigit = 11 - remainder;
        }

        digits.concat(String.valueOf(verifierDigit));

        int[] secondWeights = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        sum = 0;

        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            sum += digit * secondWeights[i];

        }

        remainder = sum % 11;

        int secondVerifierDigit;

        if (remainder == 10 || remainder == 11) {
            secondVerifierDigit = 0;
        } else {
            secondVerifierDigit = 11 - remainder;
        }

        return inscricaoEstadualNoDigit.concat(String.valueOf(verifierDigit))
                .concat(String.valueOf(secondVerifierDigit));
    }
}