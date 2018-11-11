package domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class WriteFileTransaction{
	
	//ATRIBUTOS
	private static String pathReponseDeposit;
	
	//CONSTRUTORES
	public WriteFileTransaction(String pathReponseDeposit) {
		WriteFileTransaction.pathReponseDeposit = pathReponseDeposit;
	}
	public WriteFileTransaction() {
		
	}

	//MÉTODOS
	public String getPathReponseDeposit() {
		return pathReponseDeposit;
	}

	public void setPathReponseDeposit(String pathReponseDeposit) {
		WriteFileTransaction.pathReponseDeposit = pathReponseDeposit;
	}

	public static boolean ResponseDeposit(Object porta_remota, Integer agencia, 
			Integer conta, 
			Double valor, 
			String validadorTransacao, 
			String dataTransaction, 
			Integer tipoTransacao ) throws Exception{

		LocalDate date = LocalDate.now();
		LocalDateTime time = LocalDateTime.now();

		final String pathDepositoResposta = "C:/Users/User/workspace/SistemaBancario/operacoes/A 0012 T 1500 ResponseDeposit "+date+ " " 
																						+time.getHour()+"h" 
																						+time.getMinute()+"min" 
																						+time.getSecond()+"s" 
																						+ " OUT.txt";
		//System.out.println(pathDepositoResposta);//Descomentar apenas para manutenção.

		File file = new File(pathDepositoResposta);

		long begin = System.currentTimeMillis();
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		
		int type_transactinon_id = 10;
		
		writer.write(agencia+";"+conta+";"+valor+";"+type_transactinon_id+";"//Tipo de transação e status [transação].[status] Transações:10 Depo 14 Saq 3 Tran 4 Cons
		+new SimpleDateFormat("dd/MM/yyy hh:mm:ss").format(new Date())+";"
		+"32;"//Validador da transação, implementar um hash para validar cada arquivo de transação
		+"00"+";"//Status da transação 00 Confirmada 10 Solicitação 99 Negada 
		);
		
		System.out.println("Path Response: "+pathDepositoResposta+"/n");
				
		WriteFileTransaction wft = new WriteFileTransaction(pathReponseDeposit);
		wft.setPathReponseDeposit(pathDepositoResposta);
				
		writer.newLine();
		writer.flush();
		writer.close();

		return true;
		}

}
