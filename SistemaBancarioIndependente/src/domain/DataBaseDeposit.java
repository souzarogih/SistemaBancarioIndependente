package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dataBase.DatabaseConnect;

public class DataBaseDeposit {

		public boolean insertDeposito(int balance_id,
										int account_id,
										double balance_value_original,
										double balance_value_current,
										String server,
										String port, 
										String database, 
										String user, 
										String passwd,
										int tipoTransacao){		
		
		DatabaseConnect cc = new DatabaseConnect();
		System.out.println("balance_id: "+balance_id+" : account_id"+account_id+" balance_value: "+balance_value_current);//descomentar para manuten��o.
		cc.CallConnect();
		
		//Update para atualizar o campo balance_value da tabela sbi_balance_account.
		try { 	
			
			String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;
			
			String sql;
			String sqlTwo;
			
			// Abre-se a conex�o com o Banco de Dados
			Connection con = DriverManager.getConnection(url, user, passwd);
			
			// Cria-se Statement com base na conex�o con
			Statement stmt = con.createStatement();
			
			// Update para se executada
			sql = "UPDATE sbi_balance_account set balance_value = "
					+balance_value_current+" where balance_id = '"
					+balance_id+"' and account_id = '"
					+account_id+"'";
			
			//con.commit();
			stmt.executeUpdate(sql);
						
			con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
			
			}
				
		//Update para atualizar o campo date_last_update da tabela sbi_balance_account.
		try { 	
				
				String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;
				
				String sqlTwo;
				
				// Abre-se a conex�o com o Banco de Dados
				Connection con = DriverManager.getConnection(url, user, passwd);
				
				// Cria-se Statement com base na conex�o con
				Statement stmt = con.createStatement();
				
				// Update para se executada				
				sqlTwo = "update sbi_balance_account set date_last_update = current_timestamp where balance_id = '"+balance_id+"' and account_id = '"+account_id+"'";
				
				stmt.executeUpdate(sqlTwo);
				con.commit();
				
				con.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
				
				}
		
		
			//colocar aqui a outra tabela
			//Update para atualizar o campo date_last_update da tabela sbi_balance_account.
			try { 	
					
					String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;
						
			        String sqlGetSequence;
			            
			        // Abre-se a conex�o com o Banco de Dados
			        Connection con = DriverManager.getConnection(url, user, passwd);
			
			        // Cria-se Statement com base na conex�o con
			        Statement stmt = con.createStatement();
			
			        // Consulta para se executada
			        sqlGetSequence = "select max(transaction_id) transaction_id, max(sequence_day) sequence from sbi_transaction "
			        		+ "where transaction_datetime >= TRUNC(SYSDATE)";
			      	            
			            // Executa-se a consulta dos campos titulo,ano da tabela de filmes
			            ResultSet res = stmt.executeQuery(sqlGetSequence);
			            
			            int VgetMaxTransactionId = 0;
			            int VgetMaxSequence = 0;
			            
			            while (res.next()) {
			            
			            	VgetMaxTransactionId = res.getInt("transaction_id");
			            	VgetMaxSequence = res.getInt("sequence");
			            	
			            	System.out.println("\nMax Sequence:"+VgetMaxSequence+":");
			            	System.out.println("\nMax Transaction:"+VgetMaxTransactionId+":");
			            	VgetMaxSequence = VgetMaxSequence + 1;
			            	VgetMaxTransactionId = VgetMaxTransactionId + 1;
			            	System.out.println("\nMax Sequence:"+VgetMaxSequence+":");
			            	System.out.println("\nMax Transaction:"+VgetMaxTransactionId+":");
			            	
			            	
			            	//Vai at� aqui o select
			            	//A partir daqui come�a o insert
			            	
							
							String sqlInsertSbiTransaction;
			            	
			            	sqlInsertSbiTransaction = "insert into sbi_transaction values ('"+VgetMaxTransactionId+"',current_timestamp,'"+VgetMaxSequence+"','2018-001-0001',10,"+balance_value_original+",100,100015,1000,212)";
							
							stmt.executeUpdate(sqlInsertSbiTransaction);
							con.commit();
							
							
			            	
			            }
			            
			            con.close();
			            return true;	   
			      
						
					} catch (Exception e) {
						
						e.printStackTrace();
						return false;
						
						}
		
		
		
		
		
		
		
	
	
	}

	
}
