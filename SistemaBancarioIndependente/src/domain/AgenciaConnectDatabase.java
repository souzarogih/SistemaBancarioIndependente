package domain;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import dataBase.DatabaseConnect;

public class AgenciaConnectDatabase {
	
	public boolean validarAgenciaDB(String specific_branch_id, String server, String port, String database, String user, String passwd){		
		
		DatabaseConnect cc = new DatabaseConnect();
		cc.CallConnect();
	
        try { 	
        		
            String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;

            String sql;
            
            // Abre-se a conexão com o Banco de Dados
            Connection con = DriverManager.getConnection(url, user, passwd);

            // Cria-se Statement com base na conexão con
            Statement stmt = con.createStatement();//ESSA LINHA PODE DAR PROBLEMA

            // Consulta para se executada
            sql = "select * from dom_branch where specific_branch_id = '"+specific_branch_id+"'";
      	            
            // Executa-se a consulta dos campos titulo,ano da tabela de filmes
            ResultSet res = stmt.executeQuery(sql);//ESSA LINHA PODE DAR PROBLEMA
            
            String Vspecific_branch_id = null;
            
            while (res.next()) {
            
            	Vspecific_branch_id = res.getString("specific_branch_id");
            		            	
            }
            
            //Esse if verifica se há resultado após executar a consulta, exibe a informação que está no println.
            if (Vspecific_branch_id.equals(specific_branch_id)){
            	System.out.println("Agência encontrada!\n");
            	
            }else 
            	throw new Exception("AgenciaConnectDatabase - Agência Inválida");
            	//System.out.println("Agência não encontrada!");
            	           
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return true;
	
	}

}
