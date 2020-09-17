import java.util.Scanner;
public class TareaIntegradora1{
	public static final double PLUMBINGWORKFIX=2600000;
	public static final double CONSTRUCTIONFIX=1300000;
	public static final double PAINTFIX=980000;
	public static void main(String[] args){
		Scanner entry=new Scanner(System.in);
		System.out.println("ingrese cantidad total de productos (no contar productos repetidos)");
		int totalItems=entry.nextInt();
		String [] names=new String[totalItems];
		double [] HCPrices=new double[totalItems];
		double [] barrioPrices=new double[totalItems];
		double [] centroPrices=new double[totalItems];
		int [] amountOfItems=new int[totalItems];
		Object [] useType=new Object[totalItems];
		boolean PWVerification=false;
		boolean ConsVerification=false;
		boolean PaintVerification=false;
		entry.nextLine();
		for(int i=0;i<totalItems;i++){
			System.out.println("ingrese nombre del producto #"+(i+1));
			names[i]=entry.nextLine();
			System.out.println("ingrese cantidad del producto:");
			amountOfItems[i]=entry.nextInt();
			System.out.println("ingrese precio en Home Center:");
			HCPrices[i]=entry.nextDouble();
			System.out.println("ingrese precio en la ferreteria del centro");
			centroPrices[i]=entry.nextDouble();
			System.out.println("ingrese precio en la ferreteria del barrio");
			barrioPrices[i]=entry.nextDouble();
			entry.nextLine();
			}
			for(int j=0;j<totalItems;j++){
			System.out.println("ingrese el uso que se le va a dar al producto "+names[j]);
			System.out.println("ingrese 1 para obras negras, 2 para obras blancas y 3 para pintura");
			int typeDefinition=entry.nextInt();
			switch(typeDefinition){
				case 1:
				useType[j]=UseTypeEnum.PLUMBINGWORK;
				PWVerification=true;
				break;
				case 2:
				useType[j]=UseTypeEnum.CONSTRUCTION;
				ConsVerification=true;
				break;
				case 3:
				useType[j]=UseTypeEnum.PAINT;
				PaintVerification=true;
				break;
			}
			}
			System.out.println("El costo total en Home Center es: "+TotalMetodHC(amountOfItems,HCPrices,totalItems,PaintVerification,ConsVerification,PWVerification,useType));
			System.out.println("El costo total en la ferreteria del barrio es: "+totalMetodBarrio(amountOfItems,barrioPrices,totalItems));
			System.out.println("El costo total en la ferreteria del centro es: "+totalMetodCentro(amountOfItems,centroPrices,totalItems));
		System.out.println("");
	}
	public static double TotalMetodHC(int[] amountOfItems, double[] HCPrices, int totalItems, boolean PaintVerification, boolean ConsVerification, boolean PWVerification,Object[] useType){
		double totalPriceHC=0;
		for(int i=0;i<totalItems;i++){
			totalPriceHC=(amountOfItems[i]*HCPrices[i])+totalPriceHC;
		}
		/*for(int n=0;n<totalItems;n++){
			if(useType[n]==UseTypeEnum.PLUMBINGWORK){
				PWVerification=true;
			}
			if(useType[n]==UseTypeEnum.CONSTRUCTION){
				ConsVerification=true;
			}
			if(useType[n]==UseTypeEnum.PAINT){
				PaintVerification=true;
			}
		}*/
		if((PaintVerification=true) && (ConsVerification=true)){
			if(PWVerification=true){
			totalPriceHC=totalPriceHC+PLUMBINGWORKFIX+CONSTRUCTIONFIX+PAINTFIX;
			}
			else{
				totalPriceHC=totalPriceHC+CONSTRUCTIONFIX+PAINTFIX;
			}
		}
		return totalPriceHC;
	}
	public static double totalMetodCentro(int[] amountOfItems, double[] centroPrices, int totalItems){
	double totalPriceCentro=0;
		for(int i=0;i<totalItems;i++){
			totalPriceCentro=(amountOfItems[i]*centroPrices[i])+totalPriceCentro;
		}
		return totalPriceCentro;
	}
	public static double totalMetodBarrio(int[] amountOfItems, double[] barrioPrices, int totalItems){
	double totalPriceBarrio=0;
		for(int i=0;i<totalItems;i++){
			totalPriceBarrio=(amountOfItems[i]*barrioPrices[i])+totalPriceBarrio;
		}
		return totalPriceBarrio;
	}
}

