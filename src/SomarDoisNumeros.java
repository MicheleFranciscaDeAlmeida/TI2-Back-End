import java.util.Scanner;


public class SomarDoisNumeros {

	public static void main(String[] args) {
		
		// Cria o Scanner para receber os valores digitados pelo usuário.
		Scanner scanner = new Scanner (System.in);
		
	System.out.print("Digite o primeiro numero: ");
	int numero1 = scanner.nextInt();
	
	System.out.print("Digite o segundo numero: ");
	int numero2 = scanner.nextInt();
	
	// Realiza a soma dos dois números informados.
	int soma = numero1 + numero2;
	
	System.out.println("Soma eh: " + soma);
	
	scanner.close();

	}

}
