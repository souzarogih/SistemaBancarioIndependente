package domain;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CallResponseTransaction {

	private String pathResponse;
		
	public CallResponseTransaction(String pathResponse) {
		super();
		this.pathResponse = pathResponse;
	}
	
	public CallResponseTransaction() {
		super();
		this.pathResponse = pathResponse;
	}
	

	public String getPathResponse() {
		return pathResponse;
	}

	public void setPathResponse(String pathResponse) {
		this.pathResponse = pathResponse;
	}

	public boolean callResponseDeposit(Object porta_remota, Integer agencia, 
			Integer conta, 
			Double valor, 
			String validadorTransacao, 
			String dataTransaction, 
			Integer tipoTransacao) throws IOException{
		
		
		//WriteFileTransaction.ResponseDeposit(porta_remota, agencia, conta, valor, "00", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()), 2);
		
		//Nesta linha estou armezenando o retorno do método ResponseDeposit para retornar ao método anterior.
		//String retornoMethdoResponseDeposit = WriteFileTransaction.ResponseDeposit(porta_remota, agencia, conta, valor, validadorTransacao, dataTransaction, tipoTransacao);
		
		//setPathResponse(retornoMethdoResponseDeposit);
		
		System.out.println(getPathResponse());
		
		return true;
		
	}
	
}
