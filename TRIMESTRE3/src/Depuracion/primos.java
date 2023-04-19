package Depuracion;
import java.util.Scanner;

public class primos {

	
	public static void main(String [] args){
	int num;
	boolean  resultado = true;
	
	
	Scanner S = new Scanner(System.in);
	try {
	System.out.print("Introduce un número para comprobar si es primo: ");
	num = S.nextInt();
	for(int i=2; i<num; i++){
	if(num % i == 0){
	resultado = false;
	}
	
	}
	if (resultado){
	System.out.println("El número es primo.");
	}
	else{
	System.out.println("El número NO es primo");
	}}catch(Exception e) {
		System.out.println("Introduce un numero valido");
	}
	
	}

}
