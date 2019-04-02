package teste;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class RedeNeural {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.ENGLISH);
		
		int x[][] = {{1,1,1,1,0,0,0,0},//x1
					 {1,1,0,0,1,1,0,0},//x2
					 {1,0,1,0,1,0,1,0},//x3
					 {1,1,1,1,1,1,1,1}};//1
		int  t[] = {1,0,0,0,0,0,0,0};
		int w[]  = {0,0,0,0,}; //pesos j� zerados
		int wa[] = {0,0,0,0,}; //pesos antigos j� zerados
		double n=0; //taxa de aprendizado (entre 0 e 1) ENTRADA PELO USUARIO
		Random gerador = new Random();
		int b[] = {0,0,0,0,}; // � bias  (peso que indica o vi�s do neur�nio)
		int o=0; //LINEAR - ENTRADA PELO USUARIO
		int yent[] ={0,0,0,0,0,0,0,0}; //vari�veis de c�lculo
		int fyent[]={1,0,0,0,0,0,0,0};
		int wcontrol; //contador para saber se w � diferente de wa (ou seja, se houve variacao de w)
		double limiar=0.0;//� o T�TA
		//int[][] x = new int[8][4];
		System.out.print("Fornce�a Teta: ");
		limiar = in.nextDouble();

		do {
			wcontrol=0;
			//Yent =  somatorio (X . W)  +  b
			for (int j=0 ; j<8 ; j++) {
				for (int i=0 ; i<4 ; i++) {
					//System.out.print(" " + x[i][j]);
					yent[j] = x[i][j] * w[i] + b[i];
					//System.out.print(" " + yent);
					
					////c�lculo da sa�da do neur�nio
					//f(Yent)  = 
					// 1 se Yent >  0
					if(yent[j]>limiar)  fyent[j]=1;
					// 0 se -0 <= Yent <=0
					if(yent[j]==limiar) fyent[j]=0;
					//-1 se Yent < -0
					if(yent[j]<limiar)  fyent[j]=-1;
					//System.out.print(" " + fyent[j]);
	
				}
				//System.out.println();
			}
	
			for (int k=0 ; k<8 ; k++) {
				for (int l=0 ; l<4 ; l++) {
					//atualiza��o dos pesos do neur�nio
					//Se (fYent != t)
					if(fyent[k] != t[k]) {
						n=gerador.nextDouble();
						//System.out.println(n);
						//ent�o: W = n * (T � fYent) * X
						w[l] = (int) Math.round (n * (t[k] - fyent[k]) * x[l][k]);
						//b = n * (T - fYent)
						b[l] = (int) Math.round (n * (t[k] - fyent[k]));
						
					}
				}
			}
			
			for (int y=0 ; y<4 ; y++) {
				System.out.print("Peso: " + w[y] + " ");
				if(wa[y] != w[y]) {
					wa[y]=w[y];
					wcontrol++;
				}
			}
			System.out.println();
		} while(wcontrol!=0);
	}
}
