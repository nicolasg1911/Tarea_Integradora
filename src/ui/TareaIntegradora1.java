import java.util.Scanner;
public class TareaIntegradora1{
	public static final double PLUMBINGWORKFIXED=2600000;
	public static final double CONSTRUCTIONFIXED=1300000;
	public static final double PAINTFIXED=980000;
	public static void main(String[] args){
		Scanner entry=new Scanner(System.in);
		System.out.println("ingrese cantidad total de productos (no contar productos repetidos)");
		int totalItems=entry.nextInt();
		String [] names=new String[totalItems];
		double [] HCPrices=new double[totalItems];
		double [] barrioPrices=new double[totalItems];
		double [] centroPrices=new double[totalItems];
		int [] amountOfItems=new int[totalItems];
		UseTypeEnum [] useType=new UseTypeEnum[totalItems];
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
			System.out.println("el estado de PW es: "+PWVerification);
			System.out.println("el estado de Cons. "+ConsVerification);
			System.out.println("el estado de Paint es: "+PaintVerification);
			
			System.out.println("El costo total en Home Center es: "+TotalMetodHC(amountOfItems,HCPrices,totalItems,PaintVerification,ConsVerification,PWVerification,useType));
			System.out.println("El costo total en la ferreteria del barrio es: "+totalMetodBarrio(amountOfItems,barrioPrices,totalItems, PaintVerification, ConsVerification, PWVerification, useType));
			System.out.println("El costo total en la ferreteria del centro es: "+totalMetodCentro(amountOfItems,centroPrices,totalItems, PaintVerification, ConsVerification, PWVerification, useType));
		System.out.println("");
	}
	/**
	*Get the total price in Home Center <br>
	*<b> pre: </b> previous arrays got to be filled
	*@param amountOfItems list of the amount for each item
	*@param HCPrices list of prices for each item
	*@param totalItems total amount of items
	*@param PaintVerification search the use type paint
	*@param ConsVerification search the use type construction
	*@param PWVerification search the use type Plumbing work
	*@param useType list of use types
	*@return it returns the total price in Home Center
	*/
	public static double TotalMetodHC(int[] amountOfItems, double[] HCPrices, int totalItems, boolean PaintVerification, boolean ConsVerification, boolean PWVerification,UseTypeEnum[] useType){
		double totalPriceHC=0;
		for(int i=0;i<totalItems;i++){
			totalPriceHC=(amountOfItems[i]*HCPrices[i])+totalPriceHC;
		}
			if((PWVerification==true) && (ConsVerification==true)){
				if(PaintVerification==true){
					totalPriceHC=PLUMBINGWORKFIXED+CONSTRUCTIONFIXED+PAINTFIXED+totalPriceHC;
				}
				else{
					totalPriceHC=PLUMBINGWORKFIXED+CONSTRUCTIONFIXED+totalPriceHC;	
				}
			}
			if((ConsVerification==true) && (PaintVerification==true)){
				if(PWVerification==true){
					totalPriceHC=PLUMBINGWORKFIXED+CONSTRUCTIONFIXED+PAINTFIXED+totalPriceHC;
				}
				else{
					totalPriceHC=CONSTRUCTIONFIXED+PAINTFIXED+totalPriceHC;	
				}
			}
			if((PWVerification==true) && (PaintVerification==true)){
				if(ConsVerification==true){
					totalPriceHC=PLUMBINGWORKFIXED+CONSTRUCTIONFIXED+PAINTFIXED+totalPriceHC;
				}
				else{
					totalPriceHC=PLUMBINGWORKFIXED+PAINTFIXED+totalPriceHC;	
				}
			}
			if((PWVerification==true) && (ConsVerification==false) && (PaintVerification==false)){
			totalPriceHC=totalPriceHC+PLUMBINGWORKFIXED;
			}
			if((PWVerification==false) && (ConsVerification==true) && (PaintVerification==false)){
			totalPriceHC=totalPriceHC+CONSTRUCTIONFIXED;
			}
			if((PWVerification==false) && (ConsVerification==false) && (PaintVerification==true)){
			totalPriceHC=totalPriceHC+PAINTFIXED;
			}
		
		return totalPriceHC;
	}
	/**
	*Get the total price in ferreteria del barrio<br>
	*<b> pre: </b> previous arrays got to be filled
	*@param amountOfItems list of the amount for each item
	*@param HCPrices list of prices for each item
	*@param totalItems total amount of items
	*@param PaintVerification search the use type paint
	*@param ConsVerification search the use type construction
	*@param PWVerification search the use type Plumbing work
	*@param useType list of use types
	*@return it returns the total price in ferreteria del barrio
	*/
	public static double totalMetodCentro(int[] amountOfItems, double[] centroPrices, int totalItems, boolean PaintVerification, boolean ConsVerification, boolean PWVerification,UseTypeEnum[] useType){
	double totalPriceCentro=0;
		for(int i=0;i<totalItems;i++){
			totalPriceCentro=(amountOfItems[i]*centroPrices[i])+totalPriceCentro;
		}
			if((PWVerification==true) && (ConsVerification==true)){
				if(PaintVerification==true){
					totalPriceCentro=PLUMBINGWORKFIXED+CONSTRUCTIONFIXED+PAINTFIXED+totalPriceCentro;
				}
				else{
					totalPriceCentro=PLUMBINGWORKFIXED+CONSTRUCTIONFIXED+totalPriceCentro;	
				}
			}
			if((ConsVerification==true) && (PaintVerification==true)){
				if(PWVerification==true){
					totalPriceCentro=PLUMBINGWORKFIXED+CONSTRUCTIONFIXED+PAINTFIXED+totalPriceCentro;
				}
				else{
					totalPriceCentro=CONSTRUCTIONFIXED+PAINTFIXED+totalPriceCentro;	
				}
			}
			if((PWVerification==true) && (PaintVerification==true)){
				if(ConsVerification==true){
					totalPriceCentro=PLUMBINGWORKFIXED+CONSTRUCTIONFIXED+PAINTFIXED+totalPriceCentro;
				}
				else{
					totalPriceCentro=PLUMBINGWORKFIXED+PAINTFIXED+totalPriceCentro;	
				}
			}
			if((PWVerification==true) && (ConsVerification==false) && (PaintVerification==false)){
			totalPriceCentro=totalPriceCentro+PLUMBINGWORKFIXED;
			}
			if((PWVerification==false) && (ConsVerification==true) && (PaintVerification==false)){
			totalPriceCentro=totalPriceCentro+CONSTRUCTIONFIXED;
			}
			if((PWVerification==false) && (ConsVerification==false) && (PaintVerification==true)){
			totalPriceCentro=totalPriceCentro+PAINTFIXED;
			}
		return totalPriceCentro;
	}
	/**
	*Get the total price in ferreteria del centro <br>
	*<b> pre: </b> previous arrays got to be filled
	*@param amountOfItems list of the amount for each item
	*@param HCPrices list of prices for each item
	*@param totalItems total amount of items
	*@param PaintVerification search the use type paint
	*@param ConsVerification search the use type construction
	*@param PWVerification search the use type Plumbing work
	*@param useType list of use types
	*@return it returns the total price in ferreteria del centro
	*/
	public static double totalMetodBarrio(int[] amountOfItems, double[] barrioPrices, int totalItems,  boolean PaintVerification, boolean ConsVerification, boolean PWVerification,UseTypeEnum[] useType){
	double totalPriceBarrio=0;
		for(int i=0;i<totalItems;i++){
			totalPriceBarrio=(amountOfItems[i]*barrioPrices[i])+totalPriceBarrio;
		}
		if((PWVerification==true) && (ConsVerification==true)){
				if(PaintVerification==true){
					totalPriceBarrio=PLUMBINGWORKFIXED+CONSTRUCTIONFIXED+PAINTFIXED+totalPriceBarrio;
				}
				else{
					totalPriceBarrio=PLUMBINGWORKFIXED+CONSTRUCTIONFIXED+totalPriceBarrio;	
				}
			}
			if((ConsVerification==true) && (PaintVerification==true)){
				if(PWVerification==true){
					totalPriceBarrio=PLUMBINGWORKFIXED+CONSTRUCTIONFIXED+PAINTFIXED+totalPriceBarrio;
				}
				else{
					totalPriceBarrio=CONSTRUCTIONFIXED+PAINTFIXED+totalPriceBarrio;	
				}
			}
			if((PWVerification==true) && (PaintVerification==true)){
				if(ConsVerification==true){
					totalPriceBarrio=PLUMBINGWORKFIXED+CONSTRUCTIONFIXED+PAINTFIXED+totalPriceBarrio;
				}
				else{
					totalPriceBarrio=PLUMBINGWORKFIXED+PAINTFIXED+totalPriceBarrio;	
				}
			}
			if((PWVerification==true) && (ConsVerification==false) && (PaintVerification==false)){
			totalPriceBarrio=totalPriceBarrio+PLUMBINGWORKFIXED;
			}
			if((PWVerification==false) && (ConsVerification==true) && (PaintVerification==false)){
			totalPriceBarrio=totalPriceBarrio+CONSTRUCTIONFIXED;
			}
			if((PWVerification==false) && (ConsVerification==false) && (PaintVerification==true)){
			totalPriceBarrio=totalPriceBarrio+PAINTFIXED;
			}
		return totalPriceBarrio;
	}
}

