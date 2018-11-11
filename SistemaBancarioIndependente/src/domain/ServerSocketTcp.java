package domain;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTcp {

	/**
	 * Classe socket para uso do servidor
	 * @author User
	 */
		
		private final static int DEFAULT_PORT = 5555 ;
		
		/**
		 * O Método serverSocketWait deve ser usado para manter o server escutando na porta aguardando a solicitação.
		 * @throws Exception
		 */
		public void serverSocketWait()throws Exception{
			
			int porta = DEFAULT_PORT;
			
			ServerSocket skt = new ServerSocket(porta, 5);
			System.out.println("-----------------------------------------------");		
			System.out.println("Servidor criado na porta "+ porta);
			Socket conexao = null;
			int qtdConexoes = 0;
			
			while(true){
				
				InetAddress endereco_remoto;
				int porta_remota;
				Object outputFile;
				
				
					System.out.println("Servidor esperando conexão na porta "+ porta);
					conexao = skt.accept();
					qtdConexoes++;//Incrementa o número de conexões.
					ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
					Thread.sleep(5000);
					
					ObjectOutputStream saida1 = new ObjectOutputStream(conexao.getOutputStream());
					String retornoMethdoReadFileTransaction = null;
					
					for (int i=1; i<=1; i++){
						System.out.println("Servidor recebeu conexão. Número da conexão: "+qtdConexoes);
						
						endereco_remoto = conexao.getInetAddress();
						porta_remota = conexao.getPort();
						outputFile = entrada.readObject();
						
						System.out.println("Nome da maquina remota: "+ endereco_remoto.getHostName());
						System.out.println("IP da máquina remota: "+ endereco_remoto.getHostAddress());
						System.out.println("Porta maquina remota: "+ porta_remota);
						System.out.println("Path Request: "+outputFile);
						
						ReadFileTransaction.readFileTransaction(outputFile, porta_remota);//Método que lê o arquivo gerado pelo terminal.					
											
						WriteFileTransaction wft = new WriteFileTransaction();
						retornoMethdoReadFileTransaction = wft.getPathReponseDeposit();
						
				//System.out.println((String)entrada.readObject());//Se descomentar essa linha, não permitirá o terminal fazer solicitações seguidas.
				
					}//Fim do for
					
						//ObjectOutputStream saida1 = new ObjectOutputStream(conexao.getOutputStream());
						
					
						//System.out.println("Path Response: ");
						saida1.writeObject(retornoMethdoReadFileTransaction);
						
						outputFile = entrada.readObject();
						System.out.println("Path Confirm: "+outputFile);
						
						ReadFileTransaction.readFileConfirmation(outputFile);
						
						saida1.writeObject("Servidor: estou localizado na máquina: "+ skt.getInetAddress());
						saida1.flush();
												
						conexao.close();
					
			}//Fim do while
			
		}//Fim método serverSocketWait.

		private Socket accept() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	

