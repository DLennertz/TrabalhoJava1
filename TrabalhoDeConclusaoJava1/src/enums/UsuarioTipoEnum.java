package enums;

public enum UsuarioTipoEnum {
	CLIENTE("Cliente",1),
	DIRETOR("Diretor",2),
	GERENTE("Gerente",3),
	PRESIDENTE("Presidente",3);
	
	private final String tipo;
	private final int id;

	UsuarioTipoEnum(String tipo, Integer id) {
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
