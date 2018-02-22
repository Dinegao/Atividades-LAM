import java.util.Random;
import java.util.Scanner;

public class Acerto {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random gerador = new Random();
		gerador.nextInt(11);
		int tentativa;
		int numerotentativa = 3;
		do{
			System.out.printf("Digite um numero: ");
			tentativa = input.nextInt();
			if (tantativa == gerador){
				System.out.printf("Voce acertou Parabens vlw flw ");
				numerotentativa = 0;						
			}else {
				numerotentativa--;
			}
		} while(numerotentativa > 0);
	}
}
