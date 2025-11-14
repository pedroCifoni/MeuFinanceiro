package application;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.google.gson.reflect.TypeToken;


import entities.Carteira;
import entities.Transacao;
import services.JsonUtil;


public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		boolean agir = true;
		Carteira c = new Carteira();
		Type tipoLista = new TypeToken<List<Transacao>>(){}.getType();
		while(agir == true) {
			System.out.println("Escolha o que você deseja fazer: ");
			
			System.out.println("1 - Registrar nova transacao");
			System.out.println("2 - Ver saldo atual");
			System.out.println("3 - Listar transacoes");
			System.out.println("4 - Relatorio Mensal");
			System.out.println("5 - Salvar Dados");
			System.out.println("6 - sair");
			int opcaoInicial = sc.nextInt();

			switch(opcaoInicial) {
			case 1:
				System.out.println("Insira o valor da transacao: ");
				double valor = sc.nextDouble();
				sc.nextLine();
				System.out.println("Insira o tipo da transacao: (Tipo 1 - Entrada / Tipo 2 - Saída");
				int tipo = sc.nextInt();
				sc.nextLine();
				System.out.println("Insira a data da transacao:  (dd/MM/yyy)");
				String data = sc.next();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dataF = LocalDate.parse(data, formato);
				System.out.println("Insira a descricao dessa transacao: ");
				String desc = sc.next();
				
				Transacao t = new Transacao(valor, tipo, dataF, desc);
				
				c.adicionarTransacao(t);
				break;
			case 2:
				System.out.println("O seu saldo atual é: " + c.calcularSaldo());
				break;
			case 3:
				c.listarTransacoes();
				break;
			case 4:
				System.out.println("Digite o mês que voce deseja buscar: ");
				int numMes = sc.nextInt();
				
				c.relatorioMensal(numMes);
				break;
			case 5:
				JsonUtil.salvarLista("transacoes.json", c.getTransacoes());
				System.out.println("Dados salvos!");
				break;
			case 6:
				System.out.println("Programa encerrado! Até mais!");
				agir = false;
				break;
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();
		
	}
}
