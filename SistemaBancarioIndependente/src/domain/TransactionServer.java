package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionServer {
	
	public static boolean Deposit(int agencia, int conta, double valorTransacao, Object porta_remota) throws Exception{
			
			DomAgencia da = new DomAgencia();
			DomConta dc = new DomConta();
			//ColectionConta cc = new ColectionConta();
			//ColectionAgencia ca = new ColectionAgencia();
			
			System.out.println(".:Sistema Banc�rio:. - :Dep�sito:\n");
			
			//Validar o n�mero da ag�ncia.
			String strAgencia = Integer.toString(agencia);//Converte o inteiro em String.
			try{
				da.validarAgencia(strAgencia);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			//Validar o n�mero da conta.	
			String strConta = Integer.toString(conta);//Converte o inteiro em String.
			try {
				dc.validarConta(strConta);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			/**
			 * M�todo que envia resposta ap�s validar ag�ncia e conta.
			 * S� faz dep�sito quando receber a confirma��o do terminal.
			 */
			//criar os m�todos de saque / deposito / consulta
			
			DepositTransaction.doTransaction(porta_remota, agencia, conta, valorTransacao, "00", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()), 2);
			
			return true;
			
			
		}
	
	
	
	
	
	public static boolean makeDeposit(int agencia, int conta, double valorTransacao, int tipoTransacao) throws Exception{
		
		ProcessTransactions pt = new ProcessTransactions();
		//DomConta dc = new DomConta();
		
		System.out.println(".:Sistema Banc�rio:. - :Dep�sito:\n");
		
		//Validar o n�mero da ag�ncia.
		String strBranch = Integer.toString(agencia);//Converte o inteiro em String.
		String strAccount = Integer.toString(conta);//Converte o inteiro em String.
		
		try{
			pt.identifyDeposit(strBranch, strAccount, valorTransacao, tipoTransacao);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Aqui dever� ser chamado o m�todo para inserir o dep�sito em banco de dados.
		//DepositTransaction.doTransaction( agencia, conta, valorTransacao, "00", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()), 2);
		
		return true;
		
		
	}
		

}
