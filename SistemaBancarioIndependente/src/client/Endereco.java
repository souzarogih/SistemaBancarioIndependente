package client;

/**
 * Classe do endere�o das ag�ncias banc�rias
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
			this.rua = "Avenida Epit�cio Pessoa";
			this.CEP = "58060-300";
			this.numero = 3005;
			this.bairro = "Tamba�";
		}

		public Endereco() {
		}

		/**
		 * O m�todo toString deve ser usado para retornar o endere�o onde est� localizado a ag�ncia banc�ria.
		 * @return String
		 */
		@Override
		public String toString() {
			return "Endere�o \nrua: " + rua + " CEP: " + CEP + " Numero: " + numero + " Bairro:" + bairro;
		}
		
}
