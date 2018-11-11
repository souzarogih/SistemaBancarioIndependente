package domain;

public class ProcessTransactions {

	 // Configuração dos parâmetros de conexão
	String server = "127.0.0.1";			//IP do servidor de banco de dados
    String port = "1521";               	//Porta TCP padrão do Oracle
    String database = "xe";					//Aqui deve usar o SID

    // Configuração dos parâmetros de autenticação
    String user = "appclient";
    String passwd = "!@#123QWEqwe";
    
	/**
	 * Método para processar o depósito na conta.
	 */
	public boolean processDeposit(String specific_branch_id){
		
		
		
		
		
		
		
		return true;
	}
	

	public boolean identifyDeposit(String specific_branch_id, String specific_account_id, double valorTransacao, int tipoTransacao){
		/**
		 * Nesse método será identificado se a agência e conta correspondem.
		 */
		
		/*
		  // Configuração dos parâmetros de conexão
		  String server = "127.0.0.1";			//IP do servidor de banco de dados
	      String port = "1521";               	// Porta TCP padrão do Oracle
	      String database = "xe";					//Aqui deve usar o SID

	      // Configuração dos parâmetros de autenticação
	      String user = "appclient";
	      String passwd = "!@#123QWEqwe";
		*/
	      ConnectionDeposit cd = new ConnectionDeposit();
	      cd.consultBranchAndAccount(specific_branch_id, specific_account_id, valorTransacao, server, port, database, user, passwd, tipoTransacao);
		
		return true;
	}
	
}
