package enums;

public enum Estados {

  ACRE("AC"),
  ALAGOAS("AL"),
  AMAPA("AP"),
  AMAZONAS("AM"),
  BAHIA("BA"),
  CEARA("CE"),
  DISTRITO_FEDERAL("DF"),
  ESPIRITO_SANTO("ES"),
  GOIAS("GO"),
  MARANHAO("MA"),
  MATO_GROSSO("MT"),
  MATO_GROSSO_DO_SUL("MS"),
  MINAS_GERAIS("MG"),
  PARA("PA"),
  PARAIBA("PB"),
  PARANA("PR"),
  PERNAMBUCO("PE"),
  PIAUI("PI"),
  RIO_DE_JANEIRO("RJ"),
  RIO_GRANDE_DO_NORTE("RN"),
  RIO_GRANDE_DO_SUL("RS"),
  RONDONIA("RO"),
  RORAIMA("RR"),
  SANTA_CATARINA("SC"),
  SAO_PAULO("SP"),
  SERGIPE("SE"),
  TOCANTINS("TO");

  private final String value;

  private Estados(final String value) {
    this.value = value;
  }

  public static Estados find(final String value) {
    for (final Estados type : values()) {
      if (type.value.equals(value)) {
        return type;
      }
    }
    return null;
  }

  public String value() {
    return this.value;
  }
}
