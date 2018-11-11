package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DepositTransaction {

	/*M�todo para tratar a transa��o de forma mais espe*/
	public static boolean doTransaction(Object porta_remota, Integer agencia, 
										Integer conta, 
										Double valor, 
										String validadorTransacao, 
										String dataTransaction, 
										Integer tipoTransacao) throws Exception{
	
		/**
		 * M�todo que envia resposta ap�s validar ag�ncia e conta.
		 * S� faz dep�sito quando receber a confirma��o do terminal.
		 */
		WriteFileTransaction.ResponseDeposit(porta_remota, agencia, conta, valor, "00", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()), 2);	
		
		return true;
		
	}
		
}
