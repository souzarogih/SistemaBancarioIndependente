package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import dataBase.DatabaseConnect;

public class ContaConnectDatabase {

public boolean validarContaDB(String specific_account_id, String server, String port, String database, String user, String passwd){		
		
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
            sql = "select * from dom_account where specific_account_id = '"+specific_account_id+"'";
      	            
            // Executa-se a consulta dos campos titulo,ano da tabela de filmes
            ResultSet res = stmt.executeQuery(sql);
                       
            String Vspecific_account_id = null;
            
            while (res.next()) {
            	            
            	Vspecific_account_id = res.getString("specific_account_id");
            	
            }
            
            // Esse if verifica se há resultado após executar a consulta, exibe a informação que está no println.
            if (Vspecific_account_id.equals(specific_account_id)){
            	System.out.println("Conta encontrada!\n");
            	
            }else 
            	throw new Exception("ContaConnectDatabase - Conta Inválida");
            //System.out.println("Conta não encontrada!");
            	           
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return true;
	
	}
	
}
