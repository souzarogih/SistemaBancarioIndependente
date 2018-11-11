package domain;

public class ProcessTransactions {

	 // Configura��o dos par�metros de conex�o
	String server = "127.0.0.1";			//IP do servidor de banco de dados
    String port = "1521";               	//Porta TCP padr�o do Oracle
    String database = "xe";					//Aqui deve usar o SID

    // Configura��o dos par�metros de autentica��o
    String user = "appclient";
    String passwd = "!@#123QWEqwe";
    
	/**
	 * M�todo para processar o dep�sito na conta.
	 */
	public boolean processDeposit(String specific_branch_id){
		
		
		
		
		
		
		
		return true;
	}
	

	public boolean identifyDeposit(String specific_branch_id, String specific_account_id, double valorTransacao, int tipoTransacao){
		/**
		 * Nesse m�todo ser� identificado se a ag�ncia e conta correspondem.
		 */
		
		/*
		  // Configura��o dos par�metros de conex�o
		  String server = "127.0.0.1";			//IP do servidor de banco de dados
	      String port = "1521";               	// Porta TCP padr�o do Oracle
	      String database = "xe";					//Aqui deve usar o SID

	      // Configura��o dos par�metros de autentica��o
	      String user = "appclient";
	      String passwd = "!@#123QWEqwe";
		*/
	      ConnectionDeposit cd = new ConnectionDeposit();
	      cd.consultBranchAndAccount(specific_branch_id, specific_account_id, valorTransacao, server, port, database, user, passwd, tipoTransacao);
		
		return true;
	}
	
}
