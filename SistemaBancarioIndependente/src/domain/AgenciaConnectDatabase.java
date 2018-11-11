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
            
            // Abre-se a conex�o com o Banco de Dados
            Connection con = DriverManager.getConnection(url, user, passwd);

            // Cria-se Statement com base na conex�o con
            Statement stmt = con.createStatement();//ESSA LINHA PODE DAR PROBLEMA

            // Consulta para se executada
            sql = "select * from dom_branch where specific_branch_id = '"+specific_branch_id+"'";
      	            
            // Executa-se a consulta dos campos titulo,ano da tabela de filmes
            ResultSet res = stmt.executeQuery(sql);//ESSA LINHA PODE DAR PROBLEMA
            
            String Vspecific_branch_id = null;
            
            while (res.next()) {
            
            	Vspecific_branch_id = res.getString("specific_branch_id");
            		            	
            }
            
            //Esse if verifica se h� resultado ap�s executar a consulta, exibe a informa��o que est� no println.
            if (Vspecific_branch_id.equals(specific_branch_id)){
            	System.out.println("Ag�ncia encontrada!\n");
            	
            }else 
            	throw new Exception("AgenciaConnectDatabase - Ag�ncia Inv�lida");
            	//System.out.println("Ag�ncia n�o encontrada!");
            	           
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return true;
	
	}

}
