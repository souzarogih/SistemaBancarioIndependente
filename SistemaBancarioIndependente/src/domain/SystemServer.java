package domain;

public class SystemServer {

	public static void main(String[] args) throws Exception {

		//M�todo que deixa o servidor aguardando e conex�o do cliente.
		ServerSocketTcp SST = new ServerSocketTcp();
		SST.serverSocketWait();
		

	}

}




//http://www.guj.com.br/t/pegando-valor-de-retorno-do-metodo-dentro-de-outro-metodo-resolvido/80853
