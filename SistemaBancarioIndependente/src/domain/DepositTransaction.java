package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DepositTransaction {

	/*Método para tratar a transação de forma mais espe*/
	public static boolean doTransaction(Object porta_remota, Integer agencia, 
										Integer conta, 
										Double valor, 
										String validadorTransacao, 
										String dataTransaction, 
										Integer tipoTransacao) throws Exception{
	
		/**
		 * Método que envia resposta após validar agência e conta.
		 * Só faz depósito quando receber a confirmação do terminal.
		 */
		WriteFileTransaction.ResponseDeposit(porta_remota, agencia, conta, valor, "00", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()), 2);	
		
		return true;
		
	}
		
}
