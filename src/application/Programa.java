/*Um site de internet registra um log de acessos dos usu�rios. Um
registro de log consiste no nome de usu�rio (apenas uma palavra) e o
instante em que o usu�rio acessou o site no padr�o ISO 8601,
separados por espa�o, conforme exemplo. Fazer um programa que leia
o log de acessos a partir de um arquivo, e da� informe quantos usu�rios
distintos acessaram o site.*/
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entidades.LogEntry;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o caminho completo do arquivo: ");
		String pacote = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(pacote))){
			
			Set<LogEntry> set = new HashSet<>();
			String linha = br.readLine();
			while(linha != null) {
				
				String[] campos = linha.split(" ");
				String usuario = campos[0];
				Date momento = Date.from(Instant.parse(campos[1]));
				
				set.add(new LogEntry(usuario, momento));
				
				linha = br.readLine();
			}
			
			System.out.println("Total de usu�rios: " + set.size() );
			
		}catch(IOException e) {
			System.out.println("Erro :" + e.getMessage());
		}
		
		sc.close();

	}

}
