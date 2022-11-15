package Entity;

// Schema para Solicitação das Strings solicitadas.

public class Endereco {
	
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;	
	
	public Endereco(String cep, String logradouro, String bairro, String localidade, String uf) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}	

	@Override
	public String toString() {
		return "\n Resultado referente ao CEP: " + this.cep + "\n" +
				"Rua: " + this.logradouro + "\n" +
				"Bairro: " + this.bairro + "\n" +
				"Cidade: " + this.localidade + "\n" +
				"Estado: " + this.uf;
	}	
	
}
