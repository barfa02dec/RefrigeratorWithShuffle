package com.main;


public class Test {

	public static void main(String[] args) throws Exception {
		Refrigerator ref = new Refrigerator(50, 70, 100);
		System.out.println(ref.put(new Product("Apple",10)));
		
//		System.out.println(" Small Bolck = " + ref.getProductsInSmallBlock());
//		System.out.println(" Medium Bolck = " + ref.getProductsInMediumBlock());
//		System.out.println(" Large Bolck = " + ref.getProductsInLargeBlock());
		
		
		ref.put(new Product("Apple",10));
//		System.out.println(" Small Bolck = " + ref.getProductsInSmallBlock());
//		System.out.println(" Medium Bolck = " + ref.getProductsInMediumBlock());
//		System.out.println(" Large Bolck = " + ref.getProductsInLargeBlock());
		
		
		ref.put(new Product("Apple",20));
//		System.out.println(" Small Bolck = " + ref.getProductsInSmallBlock());
//		System.out.println(" Medium Bolck = " + ref.getProductsInMediumBlock());
//		System.out.println(" Large Bolck = " + ref.getProductsInLargeBlock());
		
		ref.put(new Product("Apple",25));
		System.out.println(" Small Bolck = " + ref.getProductsInSmallBlock());
		System.out.println(" Medium Bolck = " + ref.getProductsInMediumBlock());
		System.out.println(" Large Bolck = " + ref.getProductsInLargeBlock());
		
		//ref.put(new Product("Apple",50));		
		
	}
}
