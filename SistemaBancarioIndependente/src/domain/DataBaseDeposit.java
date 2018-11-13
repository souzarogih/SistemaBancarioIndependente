package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import client.DomEquipment;
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
		
		DomEquipment de = new DomEquipment();
		String serial_number = de.getSerial_number();
			
		DatabaseConnect cc = new DatabaseConnect();
		System.out.println("balance_id: "+balance_id+" : account_id: "+account_id+" balance_value: "+balance_value_current);//descomentar para manutenção.
		cc.CallConnect();
		
		//Update para atualizar o campo balance_value da tabela sbi_balance_account.
		try { 	
			
			String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;
			
			String sql;
			String sqlTwo;
			
			// Abre-se a conexão com o Banco de Dados
			Connection con = DriverManager.getConnection(url, user, passwd);
			
			// Cria-se Statement com base na conexão con
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
				
				// Abre-se a conexão com o Banco de Dados
				Connection con = DriverManager.getConnection(url, user, passwd);
				
				// Cria-se Statement com base na conexão con
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
			            
			        // Abre-se a conexão com o Banco de Dados
			        Connection con = DriverManager.getConnection(url, user, passwd);
			
			        // Cria-se Statement com base na conexão con
			        Statement stmt = con.createStatement();
			
			        // Consulta para se executada
			        sqlGetSequence = "select max(transaction_id) transaction_id, max(sequence_day) sequence from sbi_transaction "
			        		+ "where transaction_datetime >= TRUNC(SYSDATE)";
			      	            
			            // Executa-se a consulta dos campos titulo,ano da tabela de filmes
			            ResultSet res = stmt.executeQuery(sqlGetSequence);
			            
			            int VgetMaxTransactionId;
			            int VgetMaxSequence;
			            
			            while (res.next()) {
			            
			            	VgetMaxTransactionId = res.getInt("transaction_id");
			            	VgetMaxSequence = res.getInt("sequence");
	
			            	System.out.println("\nMax Sequence:"+VgetMaxSequence);
			            	System.out.println("\nMax Transaction:"+VgetMaxTransactionId);
							
			            	/*O primeiro insert do dia passa deve passar por aqui, pois o TransactionId não deve ser zerado, 
			            	 * tem que ser o da última transação. 
			            	 */
			            	if(VgetMaxTransactionId == 0){
			            		
			            		/*O fluxo só deve passar por aqui na primeira transação do dia*/
						        String sqlGetSequence2 = "select max(transaction_id) transaction_id from sbi_transaction";
						      	            
						        ResultSet ress = stmt.executeQuery(sqlGetSequence2);
 						            
						           while (ress.next()) {
						            
						        	   int VgetMaxTransactionId2;
						            	VgetMaxTransactionId2 = ress.getInt("transaction_id");
						            	
							           System.out.println("VgetMaxTransactionId2: "+VgetMaxTransactionId2);
							           String sqlInsertSbiTransaction;
							           
							           VgetMaxSequence = 1;
							           VgetMaxTransactionId2 = VgetMaxTransactionId2 + 1;
							           System.out.println("\nMax Sequence:"+VgetMaxSequence);
							           System.out.println("\nMax Transaction:"+VgetMaxTransactionId2); 
					            	
							           sqlInsertSbiTransaction = "insert into sbi_transaction values ('"+VgetMaxTransactionId2+"',current_timestamp,'"+VgetMaxSequence+"','2018-001-0001',"+tipoTransacao+","+balance_value_original+",100,100015,1000,212)";
									
							           stmt.executeUpdate(sqlInsertSbiTransaction);
							           con.commit();  
								
						            }
						            
			            	}else if(VgetMaxTransactionId != 0){
			            		
			            		/*A partir do segundo fluxo do dia, todos deverão passar por esse if*/
			            		VgetMaxSequence = VgetMaxSequence + 1;
				            	VgetMaxTransactionId = VgetMaxTransactionId + 1;
				            	System.out.println("\nMax Sequence:"+VgetMaxSequence);
				            	System.out.println("\nMax Transaction:"+VgetMaxTransactionId);      
				            	
			            		String sqlInsertSbiTransaction;
				            	
				            	sqlInsertSbiTransaction = "insert into sbi_transaction values ('"+VgetMaxTransactionId+"',current_timestamp,'"+VgetMaxSequence+"','"+serial_number+"',10,"+balance_value_original+",100,100015,1000,212)";
								
								stmt.executeUpdate(sqlInsertSbiTransaction);
								con.commit();
			            		
			            	}
			            	
			            }
			            
			            con.close();
			            return true;	   
			            
					} catch (Exception e) {
						
						e.printStackTrace();
						return false;
						
					}//Catch
					
		}//Método
			
}//Classe
