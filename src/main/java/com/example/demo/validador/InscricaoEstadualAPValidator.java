package com.example.demo.validador;

public class InscricaoEstadualAPValidator {

	public static void isValidInscricaoEstadual(String inscricaoEstadual) throws Exception {
		String digits = inscricaoEstadual.replaceAll("\\D", "");

		if (digits.length() != 9) {
			throw new Exception("Size Invalid");
		}

		if (!inscricaoEstadual.matches("^03\\.\\d{3}\\.\\d{3}-\\d")) {
			throw new Exception("Format Invalid");
		}

		int[] weights = { 9, 8, 7, 6, 5, 4, 3, 2 };

		int sum = 0;

		for (int i = 0; i < digits.length() - 1; i++) {
			int digit = Character.getNumericValue(digits.charAt(i));
			sum += digit * weights[i];
		}

		int remainder = sum % 11;
		int verifierDigit;

		if (remainder <= 1) {
			verifierDigit = 0;
		} else {
			verifierDigit = 11 - remainder;
		}

		System.out.println(verifierDigit);
		int lastDigit = Character.getNumericValue(digits.charAt(digits.length() - 1));
		if (verifierDigit != lastDigit) {
			throw new Exception("Digit Invalid");
		}
		;
	}

	public static String generateDigit(String inscricaoEstadualNoDigit) throws Exception {

		if (inscricaoEstadualNoDigit.length() != 8) {
			throw new Exception("Size Invalid"); // Tamanho inv�lido
		}

		int[] weights = { 9, 8, 7, 6, 5, 4, 3, 2 };
		int sum = 0;
		for (int i = 0; i < inscricaoEstadualNoDigit.length(); i++) {
			int digit = Character.getNumericValue(inscricaoEstadualNoDigit.charAt(i));
			sum += digit * weights[i];
		}

		int remainder = sum % 11;
		int verifierDigit;
		if (remainder <= 1) {
			verifierDigit = 0;
		} else {
			verifierDigit = 11 - remainder;
		}
		String inscricaoEstadualWithDigit = inscricaoEstadualNoDigit.concat(String.valueOf(verifierDigit));
		return inscricaoEstadualWithDigit;
	}

}