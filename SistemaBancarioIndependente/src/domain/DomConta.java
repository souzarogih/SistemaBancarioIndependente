package domain;

import java.time.LocalDate;

public class DomConta extends TypeContas {
	
	//ATRIBUTOS DA CLASSE DomConta
		private int numeroConta;
		private double saldoConta;
			
		//CONSTRUTORES DA CLASSE DomConta
		public DomConta(int idTypeConta, String typeConta, LocalDate dataCriacao, int numeroConta, double saldoConta) {
			super(idTypeConta, typeConta, dataCriacao);
			this.numeroConta = numeroConta;
			this.saldoConta = saldoConta;
		}
		
		public DomConta(int numeroConta, double saldoConta) {
			this.numeroConta = numeroConta;
			this.saldoConta = saldoConta;
		}
		
		public DomConta() {
		
		}

		//M�TODOS POJO GETs E SETs DA CLASSE DomConta
		public int getNumeroConta() {
			return numeroConta;
		}	

		public void setNumeroConta(int numeroConta) {
			this.numeroConta = numeroConta;
		}

		public double getSaldoConta() {
			return saldoConta;
		}

		public void setSaldoConta(double saldoConta) {
			this.saldoConta = saldoConta;
		}
		
		//OUTROS M�TODOS
		/**
		 * M�todo usado para validar a exist�ncia de uma conta.
		 * @param newNumeroConta
		 * @return boolean
		 * @throws Exception
		 */
		public boolean validarConta(int newNumeroConta)throws Exception{
			
			if(newNumeroConta != getNumeroConta()){
				throw new Exception("DomConta - Conta Inv�lida");
			}
			return true;		
			
		}
		
		
		/**
		 * Validar conta
		 */
		
		public boolean valConta(int newNumeroConta)throws Exception{
			
			if(newNumeroConta != 222){
				throw new Exception("DomConta - Conta Inv�lida");
			}
			System.out.println("Conta ok");
			return true;		
			
		}
		
		public boolean valSaldo(double valor)throws Exception{
			
			if(valor > 100 ){
				throw new Exception("DomConta - Saldo Insuficiente");
			}
			System.out.println("Saldo ok");
			return true;		
			
		}
		
		/**
		 * M�todo que retorna o saldo da conta.
		 * @param newValorConsulta
		 * @return boolean
		 */
		public double consultarSaldo(int newConta)throws Exception{
			
			if(getNumeroConta() != newConta){
				throw new Exception("DomConta - Conta inv�lida");
			}
			
			return getSaldoConta();
			
		}
		
		/**
		 * M�todo que altera o saldo da conta.
		 * @param newValorSaldo
		 * @return boolean
		 */
		public boolean alterarSaldo(double newValorSaldo){
			
			double novoSaldo = newValorSaldo + getSaldoConta();
			setSaldoConta(novoSaldo);
			
			return true;
			
		}
		
		/**
		 * Consulta ag�ncia no banco de dados
		 * M�todo verifica se existe a conta informada.
		 */
		public boolean validarConta(String specific_account_id){
			
			
			  String server = "127.0.0.1";			//IP do servidor de banco de dados
		      String port = "1521";               	// Porta TCP padr�o do Oracle
		      String database = "xe";					//Aqui deve usar o SID

		      // Configura��o dos par�metros de autentica��o
		      String user = "appclient";
		      String passwd = "!@#123QWEqwe";
		        
			//DatabaseConnect dtbc = new DatabaseConnect();
			//dtbc.CallConnect();
			//dtbc.connect();
			
			ContaConnectDatabase ccd = new ContaConnectDatabase();
			ccd.validarContaDB(specific_account_id, server, port, database, user, passwd);
			
			//System.out.println("validar - higor"); //Usa para fazer manuten��o.
			
			return true;
		}
		
		
		

		//OUTROS M�TODO DA CLASSE DomConta
		
		/**
		 * M�todo que retorna uma conta e saldo.
		 */
		@Override
		public String toString() {
			return "Conta: " + numeroConta + " Saldo: " + saldoConta;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + numeroConta;
			long temp;
			temp = Double.doubleToLongBits(saldoConta);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DomConta other = (DomConta) obj;
			if (numeroConta != other.numeroConta)
				return false;
			if (Double.doubleToLongBits(saldoConta) != Double.doubleToLongBits(other.saldoConta))
				return false;
			return true;
		}

}
