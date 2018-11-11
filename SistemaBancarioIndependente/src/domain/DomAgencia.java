package domain;

import java.util.ArrayList;
//import com.thoughtworks.xstream.annotations.XStreamAlias;
import client.Endereco;

public class DomAgencia {
	
	//ATRIBUTOS
		private int numeroAgencia;
		private Endereco enderecoAgencia;
		private ArrayList<DomAgencia> agencia;
		
		//CONTRUTORES
		public DomAgencia(int numeroAgencia, Endereco enderecoAgencia) {
			this.numeroAgencia = numeroAgencia;
			this.enderecoAgencia = enderecoAgencia;
		}

		public DomAgencia() {
			
		}
		
		public DomAgencia(int numeroAgencia){
			this.numeroAgencia = numeroAgencia;
		}

		
		//MÉTODOS GETs AND SETs

		public int getNumeroAgencia() {
			return numeroAgencia;
		}

		public void setNumeroAgencia(int numeroAgencia) {
			this.numeroAgencia = numeroAgencia;
		}

		public Endereco getEnderecoAgencia() {
			return enderecoAgencia;
		}

		public void setEnderecoAgencia(Endereco enderecoAgencia) {
			this.enderecoAgencia = enderecoAgencia;
		}
		
		//OUTROS MÉTODOS

		//Usado para validar agencia temporariamente enquanto não faz conexão com o banco de dados
		public boolean valAgencia(int newNumeroAgencia)throws Exception{//NÃO ESTÁ EM USO
			
			if(newNumeroAgencia != 111){
				throw new Exception("DomAgencia - Agência Inválida");
			}
			System.out.println("Agência ok");
			return true;		
			
		}
		
		/**
		 * Consulta agência no banco de dados
		 * Método verifica se existe a agência informada.
		 */
		public boolean validarAgencia(String specific_branch_id){
			
			  // Configuração dos parâmetros de conexão
			  String server = "127.0.0.1";			//IP do servidor de banco de dados
		      String port = "1521";               	// Porta TCP padrão do Oracle
		      String database = "xe";					//Aqui deve usar o SID

		      // Configuração dos parâmetros de autenticação
		      String user = "appclient";
		      String passwd = "!@#123QWEqwe";
			
		      AgenciaConnectDatabase acd = new AgenciaConnectDatabase();
		      acd.validarAgenciaDB(specific_branch_id, server, port, database, user, passwd);
			
		      //System.out.println("validar - higor"); //Usa para fazer manutenção.
			
			return true;
		}
		
		/**
		 * Método retorna uma agência.
		 */
		@Override
		public String toString() {
			return "Agencia=" + numeroAgencia;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
			result = prime * result + ((enderecoAgencia == null) ? 0 : enderecoAgencia.hashCode());
			result = prime * result + numeroAgencia;
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
			DomAgencia other = (DomAgencia) obj;
			if (agencia == null) {
				if (other.agencia != null)
					return false;
			} else if (!agencia.equals(other.agencia))
				return false;
			if (enderecoAgencia == null) {
				if (other.enderecoAgencia != null)
					return false;
			} else if (!enderecoAgencia.equals(other.enderecoAgencia))
				return false;
			if (numeroAgencia != other.numeroAgencia)
				return false;
			return true;
		}
	
	
	

}
