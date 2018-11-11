package client;

/**
 * Classe do endereço das agências bancárias
 * @author Higor Souza
 *
 */

public class Endereco {

	//Atributos
		private String rua;
		private String CEP;
		private int numero;
		private String bairro;
		
		//Construtores
		public Endereco(String rua, String cEP, int numero, String bairro) {
			super();
			this.rua = "Avenida Epitácio Pessoa";
			this.CEP = "58060-300";
			this.numero = 3005;
			this.bairro = "Tambaú";
		}

		public Endereco() {
		}

		/**
		 * O método toString deve ser usado para retornar o endereço onde está localizado a agência bancária.
		 * @return String
		 */
		@Override
		public String toString() {
			return "Endereço \nrua: " + rua + " CEP: " + CEP + " Numero: " + numero + " Bairro:" + bairro;
		}
		
}
