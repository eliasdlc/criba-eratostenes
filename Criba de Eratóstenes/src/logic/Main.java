package logic;


import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.print("Ingrese el valor de n: ");
		n = scan.nextInt();
		scan.close();
		
		boolean[] cribaEratostenes = criba(n);
		/*System.out.println("Los números primos entre 2 y "+n+" son: ");
		for(int i = 2; i < n; i++) {
			if(cribaEratostenes[i]) {
				System.out.println(i);
			}
		}*/
	}

	private static boolean[] criba(int n) {
		
		long startTime = System.nanoTime();
		System.out.println("Tiempo antes del procesamiento: "+startTime);
		boolean[] primos = new boolean[n];
		
		for (int i = 0; i < primos.length; i++) 
			primos[i] = true;
		
		for(int i = 2; i*i < n; i++) {
			if(primos[i]) {
				for(int j = i*i; j < n; j+= i) {
					primos[j] = false;
				}
			}
		}
		long endTime = System.nanoTime();
		System.out.println("Tiempo después del procesamiento: "+endTime);
		
		System.out.println("Tiempo total: "+(endTime-startTime));
		return primos;
	}

}
