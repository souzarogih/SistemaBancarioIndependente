package domain;

import java.time.LocalDate;

public class TypeContas {
	
	//ATRIBUTOS DA CLASSE TypeContas
		private int idTypeConta;
		private String typeConta;
		private LocalDate dataCriacao;
		
		//CONTRUTORES DA CLASSE TypeContas
		public TypeContas(int idTypeConta, String typeConta, LocalDate dataCriacao) {
			super();
			this.idTypeConta = idTypeConta;
			this.typeConta = typeConta;
			this.dataCriacao = dataCriacao;
		}
		
		public TypeContas() {
		
		}
		
		//MÉTODOS GETs AND SETs DA CLASSE TypeContas
		public int getIdTypeConta() {
			return idTypeConta;
		}

		public void setIdTypeConta(int idTypeConta) {
			this.idTypeConta = idTypeConta;
		}

		public String getTypeConta() {
			return typeConta;
		}

		public void setTypeConta(String typeConta) {
			this.typeConta = typeConta;
		}

		public LocalDate getDataCriacao() {
			return dataCriacao;
		}

		public void setDataCriacao(LocalDate dataCriacao) {
			this.dataCriacao = dataCriacao;
		}
		
		//OUTROS MÉTODOS
		@Override
		public String toString() {
			return "TypeContas Conta: " + idTypeConta + ", Tipo: " + typeConta + ", Data da Criação: " + dataCriacao ;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
			result = prime * result + idTypeConta;
			result = prime * result + ((typeConta == null) ? 0 : typeConta.hashCode());
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
			TypeContas other = (TypeContas) obj;
			if (dataCriacao == null) {
				if (other.dataCriacao != null)
					return false;
			} else if (!dataCriacao.equals(other.dataCriacao))
				return false;
			if (idTypeConta != other.idTypeConta)
				return false;
			if (typeConta == null) {
				if (other.typeConta != null)
					return false;
			} else if (!typeConta.equals(other.typeConta))
				return false;
			return true;
		}
		
		/**
		 * Método que faz verificação da conta
		 * @param idType Parâmetros que recebe o tipo de ID que se quer verificar a existência.
		 * @return String (Retorna a descrição do tipo da conta criada.)
		 */
		public String typeConta(int idType) throws Exception{
				
			if(idType == 1){
				return "Conta Corrente";
			}
				if(idType == 2){
					return "Conta Poupança";
				}
					if(idType == 3){
						return "Conta Especial";
					}
						if(idType == 4){
							return "Conta Investimento";
						}
							if((idType != 1) || (idType != 2) || (idType != 3) || (idType != 4)){
								throw new Exception("Conta " + idType + "não identificada");
							}
							return typeConta;
		}

}
