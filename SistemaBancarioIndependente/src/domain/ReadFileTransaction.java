package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ReadFileTransaction {

public static boolean readFileTransaction(Object file, Object porta_remota) throws Exception{
		
		BufferedReader br = null;
		
		try{
			String line;
			
			br = new BufferedReader(new FileReader((String) file));		
			
			while((line = br.readLine()) != null){
				System.out.println(line/*+"-----------------------------"*/);
					     
				
				StringTokenizer stringTokenizer = new StringTokenizer(line, ";");
				
				while (stringTokenizer.hasMoreElements()){
					
					Integer agencia = Integer.parseInt(stringTokenizer.nextElement().toString());
					Integer conta = Integer.parseInt(stringTokenizer.nextElement().toString());
					Double valorTransacao = Double.parseDouble(stringTokenizer.nextElement().toString());
					Integer tipoTransacao = Integer.parseInt(stringTokenizer.nextElement().toString());
					String dataTransaction = stringTokenizer.nextElement().toString();
					String validadorTransacao = stringTokenizer.nextElement().toString();
					
					StringBuilder sb = new StringBuilder();
					sb.append("\nAgencia: "+agencia);
					sb.append("\nConta: "+conta);
					sb.append("\nValor: "+valorTransacao);
					sb.append("\nTipo Transacao: "+tipoTransacao);
					sb.append("\nData Transa��o: "+dataTransaction);
					sb.append("\nValidador: "+validadorTransacao);
					
					if (tipoTransacao == 10){//Chamando o m�todo de depositos.
						
						TransactionServer.Deposit(agencia, conta, valorTransacao, porta_remota);
						
						//String retornoMethdoDeposit = TransactionServer.Deposit(agencia, conta, valorTransacao, porta_remota);
				
						System.out.print("\n:Leitura do Arquivo enviado pelo terminal 2 :");//mais a baixo est� comentado
						System.out.println(sb.toString()+"\n");//mais a baixo est� comentado
						
						//return retornoMethdoDeposit;
						return false;
						
					}else if (tipoTransacao == 14){
					
						System.out.println("chamar o met�do statico do saque aqui");
					}			
					
					//System.out.print("\n:Leitura do Arquivo enviado pelo terminal:");
					//System.out.println(sb.toString()+"\n");
					
					return false;
				}
				
			}
			
			System.out.println("Done");
		}catch (IOException e){
			e.printStackTrace();
		}finally {
			try{
				if(br != null)
					br.close();
			
			}catch (IOException ex){
				ex.printStackTrace();
			}
	
		}
			
		return false;
		
	}






public static boolean readFileConfirmation(Object file) throws Exception{
	
	BufferedReader br = null;
	
	try{
		String line;
		
		br = new BufferedReader(new FileReader((String) file));		
		
		while((line = br.readLine()) != null){
			System.out.println(line/*+"-----------------------------"*/);
				     
			
			StringTokenizer stringTokenizer = new StringTokenizer(line, ";");
			
			while (stringTokenizer.hasMoreElements()){
				
				Integer agencia = Integer.parseInt(stringTokenizer.nextElement().toString());
				Integer conta = Integer.parseInt(stringTokenizer.nextElement().toString());
				Double valorTransacao = Double.parseDouble(stringTokenizer.nextElement().toString());
				Integer tipoTransacao = Integer.parseInt(stringTokenizer.nextElement().toString());
				String dataTransaction = stringTokenizer.nextElement().toString();
				String validadorTransacao = stringTokenizer.nextElement().toString();
				String gitValidator = stringTokenizer.nextElement().toString();
				String responseTransaction = stringTokenizer.nextElement().toString();
				
				StringBuilder sb = new StringBuilder();
				sb.append("\nAgencia: "+agencia);
				sb.append("\nConta: "+conta);
				sb.append("\nValor: "+valorTransacao);
				sb.append("\nTipo Transacao: "+tipoTransacao);
				sb.append("\nData Transa��o: "+dataTransaction);
				sb.append("\nValidador: "+validadorTransacao);
				sb.append("\nGit Validator: "+validadorTransacao);
				sb.append("\nStatusResposta: "+responseTransaction);
				
				if ((tipoTransacao == 10) && (responseTransaction.equals("000"))){//Chamando o m�todo de depositos.
					
					System.out.println("Transa��o confirmada");
					//transa��o de dep�sito
					TransactionServer.makeDeposit(agencia, conta, valorTransacao,tipoTransacao);
					
								
					System.out.print("\n:Leitura do Arquivo enviado pelo terminal 2 :");//mais a baixo est� comentado
					System.out.println(sb.toString()+"\n");//mais a baixo est� comentado
					
					//return retornoMethdoDeposit;
					return false;
					
				}else if (tipoTransacao == 14){
				
					System.out.println("chamar o met�do statico do saque aqui");
				}			
				
				//System.out.print("\n:Leitura do Arquivo enviado pelo terminal:");
				//System.out.println(sb.toString()+"\n");
				
				return false;
			}
			
		}
		
		System.out.println("Done");
	}catch (IOException e){
		e.printStackTrace();
	}finally {
		try{
			if(br != null)
				br.close();
		
		}catch (IOException ex){
			ex.printStackTrace();
		}

	}
		
	return false;
	
}



	
}
