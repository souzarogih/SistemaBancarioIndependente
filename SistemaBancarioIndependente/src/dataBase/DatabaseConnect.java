package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {
	
public boolean CallConnect(){
		
        // Configura��o dos par�metros de conex�o
        String server = "127.0.0.1";			//IP do servidor de banco de dados
        String port = "1521";               	// Porta TCP padr�o do Oracle
        String database = "xe";					//Aqui deve usar o SID

        // Configura��o dos par�metros de autentica��o
        String user = "appclient";
        String passwd = "!@#123QWEqwe";

        try {
            String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;

            // Abre-se a conex�o com o Banco de Dados
            Connection con = DriverManager.getConnection(url, user, passwd);
            
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        System.out.println("DatabaseConnect - Connectado!!");
        return true;
	}

}
