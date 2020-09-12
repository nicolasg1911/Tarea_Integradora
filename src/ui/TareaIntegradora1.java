import java.util.Scanner;
public class TareaIntegradora1{
	public static final double OBRASBLANCAS=2600000;
	public static final double OBRASNEGRAS=1300000;
	public static final double PINTURA=1300000;
	public static void main(String[] args){
		Scanner entry=new Scanner(System.in);
		System.out.println("ingrese cantidad total de productos (no contar productos repetidos)");
		int totalItems=entry.nextInt();
		String [] names=new String[totalItems];
		double [] HCPrices=new double[totalItems];
		double [] barrioPrices=new double[totalItems];
		double [] centroPrices=new double[totalItems];
		int [] amountOfItems=new int[totalItems];
		String [] useType=new String[totalItems];
		
		for(int i=0;i<totalItems;i++){
			System.out.println("ingrese nombre del producto:");
			names[i]=entry.next();
			System.out.println("ingrese cantidad del producto:");
			amountOfItems[i]=entry.nextInt();
			System.out.println("ingrese precio en Home Center:");
			HCPrices[i]=entry.nextDouble();
			System.out.println("ingrese precio en la ferreteria del centro");
			centroPrices[i]=entry.nextDouble();
			System.out.println("ingrese precio en la ferreteria del barrio");
			barrioPrices[i]=entry.nextDouble();
			System.out.println("ingrese el uso que se le va a dar al material:");
			useType[i]=entry.next();
			useType[i]=useType[i].toLowerCase();
			}
		System.out.println("");
	}
	
}
