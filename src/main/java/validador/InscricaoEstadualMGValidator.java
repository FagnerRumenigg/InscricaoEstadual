package validador;

public class InscricaoEstadualMGValidator {

	public static void isValidInscricaoEstadualMG(String inscricaoEstadual) throws Exception {
		String digits = inscricaoEstadual.replaceAll("\\D", "");

		if (digits.length() != 11) {
			throw new Exception("Size Invalid");
		}

		if (!inscricaoEstadual.matches("\\d{10}-\\d{1}")) {
			throw new Exception("Format Invalid");
		}

		int[] weights = { 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
		int sum = 0;

		for (int i = 0; i < digits.length() - 1; i++) {
			int digit = Character.getNumericValue(digits.charAt(i));
			sum += digit * weights[i];
		}
		System.out.println(sum);
		int remainder = sum % 11;
		int verifierDigit;
		System.out.println(remainder);
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
	}

	public static String addMask(String inscricaoEstadualNoMask) throws Exception {
		if (inscricaoEstadualNoMask.length() != 11) {
			throw new Exception("Size Invalid");
		}

		String parteUm = inscricaoEstadualNoMask.substring(0, 10);
		String digito = inscricaoEstadualNoMask.substring(inscricaoEstadualNoMask.length() - 1);

		return String.format("%s-%s", parteUm, digito);
	}

	public static String generateDigit(String inscricaoEstadualNoDigit) throws Exception {

		if (inscricaoEstadualNoDigit.length() != 10) {
			throw new Exception("Size Invalid");
		}

		int[] weights = { 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
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

		return inscricaoEstadualNoDigit.concat(String.valueOf(verifierDigit));
	}

}