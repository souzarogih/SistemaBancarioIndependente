package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dataBase.DatabaseConnect;

public class ConnectionDeposit {
		
	public boolean consultBranchAndAccount(String specific_branch_id,
									String specific_account_id,
									double balance_value,
									String server,
									String port, 
									String database, 
									String user, 
									String passwd,
									int tipoTransacao){		
			
			DatabaseConnect cc = new DatabaseConnect();
			cc.CallConnect();
			
	        try { 	
	        		
	            String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;
	
	            String sql;
	            
	            // Abre-se a conexão com o Banco de Dados
	            Connection con = DriverManager.getConnection(url, user, passwd);
	
	            // Cria-se Statement com base na conexão con
	            Statement stmt = con.createStatement();
	
	            // Consulta para se executada
	            //sql = "select * from dom_branch where specific_branch_id = '"+specific_branch_id+"'";
	           /* sql = "select * from dom_account da,dom_branch db,dom_client dc "
	            		+ "where da.account_id = dc.account_id "
	            		+ "and db.branch_id = dc.branch_id "
	            		+ "and da.specific_account_id = '"+specific_account_id+"' "
	            		+ "and db.specific_branch_id = '"+specific_branch_id+"'";*/
	            
	            
	            
	            //sba.balance_id, da.account_id, db.branch_id
	            sql = "select * "
	            		+"from dom_account da,dom_branch db,dom_client dc,sbi_balance_account sba "
	            		+"where "
	            			+"da.account_id = dc.account_id "
	            			+"and db.branch_id = dc.branch_id "
	            			+"and sba.account_id = da.account_id "
	            			+"and da.specific_account_id = '"+specific_account_id+"'"
	            			+"and db.specific_branch_id = '"+specific_branch_id+"'";
	            			
	            		
	            
	            
	      	            
	            // Executa-se a consulta dos campos titulo,ano da tabela de filmes
	            ResultSet res = stmt.executeQuery(sql);
	            
	            String Vspecific_branch_id = null;
	            String Vspecific_account_id = null;
	            int Vbalance_id = 0;
	            int Vbranch_id = 0;
	            int Vaccount_id = 0;
	            double Vbalance_value = 0.0;
	            
	            while (res.next()) {
	            
	            	Vspecific_branch_id = res.getString("specific_branch_id");
	            	Vspecific_account_id = res.getString("specific_account_id");
	            	Vbranch_id = res.getInt("branch_id");
	            	Vaccount_id = res.getInt("account_id");
	            	Vbalance_id = res.getInt("balance_id");
	            	Vbalance_value = res.getDouble("balance_value");
	            	
	            	
	            	System.out.println("\n:"+Vspecific_branch_id+": "
	            							+Vspecific_account_id+": "
	            							+Vbalance_id+":"
	            							+Vbranch_id+":"
	            							+Vaccount_id+":"
	            							+Vbalance_value);
	            	
	            	Vbalance_value = Vbalance_value + balance_value;
	            	System.out.println(": "+Vbalance_value+'\n');
	            	
	            }
	            
	            //Esse if verifica se há resultado após executar a consulta, exibe a informação que está no println.
	            if (Vspecific_branch_id.equals(specific_branch_id) && Vspecific_account_id.equals(specific_account_id)){
	            	System.out.println("Agência e Conta encontrada!\n");
	            	
	            	DataBaseDeposit dbd = new DataBaseDeposit();
	            	dbd.insertDeposito(Vbalance_id, Vaccount_id,balance_value, Vbalance_value, server, port, database, user, passwd, tipoTransacao);
	            	
	            }else 
	            	throw new Exception("ConnectionDeposit - Agência ou Conta Inválidas");
	            	
	            	           
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return true;
		
		}

}
