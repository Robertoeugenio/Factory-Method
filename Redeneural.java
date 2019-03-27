package teste;

import java.util.Random;
import java.util.Scanner;

public class Redeneural {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x[][] = {{1,1,1,1,0,0,0,0},//x1
					 {1,1,0,0,1,1,0,0},//x2
					 {1,0,1,0,1,0,1,0},//x3
					 {1,1,1,1,1,1,1,1}};//1
		int  t[] = {1,0,0,0,0,0,0,0};
		int w[]  = {0,0,0,0,}; //pesos já zerados
		int wa[] = {0,0,0,0,}; //pesos antigos já zerados
		double n=0; //taxa de aprendizado (entre 0 e 1) ENTRADA PELO USUARIO
		Random gerador = new Random();
		int b[] = {0,0,0,0,}; // é bias  (peso que indica o viés do neurônio)
		int o=0; //LINEAR - ENTRADA PELO USUARIO
		int yent[] ={0,0,0,0,0,0,0,0}; //variáveis de cálculo
		int fyent[]={1,0,0,0,0,0,0,0};
		int wcontrol; //contador para saber se w é diferente de wa (ou seja, se houve variacao de w)
		//int[][] x = new int[8][4];

		do {
			wcontrol=0;
			//Yent =  somatorio (X . W)  +  b
			for (int j=0 ; j<8 ; j++) {
				for (int i=0 ; i<4 ; i++) {
					//System.out.print(" " + x[i][j]);
					yent[j] = x[i][j] * w[i] + b[i];
					//System.out.print(" " + yent);
					
					////cálculo da saída do neurônio
					//f(Yent)  = 
					// 1 se Yent >  0
					if(yent[j]>0)  fyent[j]=1;
					// 0 se -0 <= Yent <=0
					if(yent[j]==0) fyent[j]=0;
					//-1 se Yent < -0
					if(yent[j]<0)  fyent[j]=-1;
					//System.out.print(" " + fyent[j]);
	
				}
				//System.out.println();
			}
	
			for (int k=0 ; k<8 ; k++) {
				for (int l=0 ; l<4 ; l++) {
					//atualização dos pesos do neurônio
					//Se (fYent != t)
					if(fyent[k] != t[k]) {
						n=gerador.nextDouble();
						//System.out.println(n);
						//então: W = n * (T – fYent) * X
						w[l] = (int) Math.round (n * (t[k] - fyent[k]) * x[l][k]);
						//b = n * (T - fYent)
						b[l] = (int) Math.round (n * (t[k] - fyent[k]));
						
					}
				}
			}
			for (int y=0 ; y<4 ; y++) {
				System.out.print(w[y]);
				if(wa[y] != w[y]) {
					wa[y]=w[y];
					wcontrol++;
				}
			}
			System.out.println();
		} while(wcontrol!=0);
	}
}
