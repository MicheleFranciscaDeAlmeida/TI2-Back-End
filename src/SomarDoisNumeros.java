import java.util.Scanner;

public class SomarDoisNumeros {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
	System.out.print("Digite o primeiro numero: ");
	int numero1 = scanner.nextInt();
	
	System.out.print("Digite o segundo numero: ");
	int numero2 = scanner.nextInt();
	
	int soma = numero1 + numero2;
	
	System.out.println("Soma eh: " + soma);
	
	scanner.close();

	}

}
