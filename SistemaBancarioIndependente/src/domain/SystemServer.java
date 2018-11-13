package domain;

import client.DomEquipment;

public class SystemServer {

	public static void main(String[] args) throws Exception {
		
		//Método que deixa o servidor aguardando e conexão do cliente.
		ServerSocketTcp SST = new ServerSocketTcp();
		SST.serverSocketWait();
		

	}

}





/**
 * http://www.guj.com.br/t/pegando-valor-de-retorno-do-metodo-dentro-de-outro-metodo-resolvido/80853
 * https://www.youtube.com/watch?v=tBiYwv8KHG4 -> Integrar o Git com Eclipse.
 */
