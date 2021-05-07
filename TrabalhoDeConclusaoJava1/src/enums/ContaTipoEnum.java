package enums;

public enum ContaTipoEnum {
	CORRENTE("ContaCorrente", 1),
	POUPANCA("ContaPoupanca", 2);
	
	private final String tipo;
	private final int id;
	
	ContaTipoEnum(String tipo, Integer id) {
		this.tipo = tipo;
		this.id = id;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	public int getId() {
		return this.id;
	}
}
