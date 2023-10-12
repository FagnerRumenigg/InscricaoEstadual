import enums.Estados;
import validador.InscricaoEstadualACValidator;
import validador.InscricaoEstadualALValidator;
import validador.InscricaoEstadualAMValidator;
import validador.InscricaoEstadualAPValidator;
import validador.InscricaoEstadualBAValidator;
import validador.InscricaoEstadualCEValidator;
import validador.InscricaoEstadualESValidator;
import validador.InscricaoEstadualGOValidator;
import validador.InscricaoEstadualMAValidator;
import validador.InscricaoEstadualMSValidator;
import validador.InscricaoEstadualMTValidator;
import validador.InscricaoEstadualPAValidator;

public class Main {

	public static void main(String[] args) {
		try {
			String estado = "PA";
			String inscricaoEstadual = "15-999999-5";

			switch (Estados.find(estado)) {
				case ACRE:
					InscricaoEstadualACValidator.isValidInscricaoEstadual(
							InscricaoEstadualACValidator.addMask(InscricaoEstadualACValidator.generateDigit(inscricaoEstadual)));
					break;
				case ALAGOAS:
					InscricaoEstadualALValidator
							.isValidInscricaoEstadual(InscricaoEstadualALValidator.generateDigit(inscricaoEstadual));
					break;
				case AMAPA:
					// Fazer depois
					InscricaoEstadualAPValidator.isValidInscricaoEstadual(inscricaoEstadual);
					break;
				case AMAZONAS:
					InscricaoEstadualAMValidator.isValidInscricaoEstadual(
							InscricaoEstadualAMValidator.addMask(InscricaoEstadualAMValidator.generateDigit(inscricaoEstadual)));
					break;
				case BAHIA:
					// Fazer depois
					InscricaoEstadualBAValidator.isValidInscricaoEstadualBA(inscricaoEstadual);
					break;
				case CEARA:
					InscricaoEstadualCEValidator
							.isValidInscricaoEstadualCE(
									InscricaoEstadualCEValidator.addMask(InscricaoEstadualCEValidator.generateDigit(inscricaoEstadual)));
					break;
				// Fazer depois
				case DISTRITO_FEDERAL:
					break;
				case GOIAS:
					InscricaoEstadualGOValidator.isValidInscricaoEstadual(
							InscricaoEstadualGOValidator.addMask(InscricaoEstadualGOValidator.generateDigit(inscricaoEstadual)));
					break;
				case ESPIRITO_SANTO:
					InscricaoEstadualESValidator
							.isValidInscricaoEstadualES(InscricaoEstadualESValidator.generateDigit(inscricaoEstadual));
					break;
				case MARANHAO:
					InscricaoEstadualMAValidator
							.isValidInscricaoEstadualMA(InscricaoEstadualMAValidator.generateDigit(inscricaoEstadual));
					break;
				case MATO_GROSSO:
					InscricaoEstadualMTValidator
							.isValidInscricaoEstadualMG(
									InscricaoEstadualMTValidator.addMask(InscricaoEstadualMTValidator.generateDigit(inscricaoEstadual)));
					break;
				case MATO_GROSSO_DO_SUL:
					InscricaoEstadualMSValidator
							.isValidInscricaoEstadualMS(InscricaoEstadualMSValidator.generateDigit(inscricaoEstadual));
					break;
				// Fazer depois
				case MINAS_GERAIS:
					break;
				case PARA:
					InscricaoEstadualPAValidator.isValidInscricaoEstadualPA(inscricaoEstadual);
					break;
				case PARAIBA:
					break;
				case PARANA:
					break;
				case PERNAMBUCO:
					break;
				case PIAUI:
					break;
				case RIO_DE_JANEIRO:
					break;
				case RIO_GRANDE_DO_NORTE:
					break;
				case RIO_GRANDE_DO_SUL:
					break;
				case RONDONIA:
					break;
				case RORAIMA:
					break;
				case SANTA_CATARINA:
					break;
				case SAO_PAULO:
					break;
				case SERGIPE:
					break;
				case TOCANTINS:
					break;
				default:
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
