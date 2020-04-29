package com.main;

import java.util.ArrayList;
import java.util.List;

public class Refrigerator{

	private int smallBlockSize;
	private int mediumBlockSize;
	private int largeBlockSize;
	private int availableSmallBlockSize;
	private int availableMediumBlockSize;
	private int availableLargeBlockSize;
	private List<Product> productsInSmallBlock;
	private List<Product> productsInMediumBlock;
	private List<Product> productsInLargeBlock;
	
	public Refrigerator(int smallBlockSize,int mediumBlockSize,int largeBlockSize) {
		this.smallBlockSize = smallBlockSize;
		this.mediumBlockSize = mediumBlockSize;
		this.largeBlockSize = largeBlockSize;
		this.productsInSmallBlock = new ArrayList<>();
		this.productsInMediumBlock = new ArrayList<>();
		this.productsInLargeBlock = new ArrayList<>();
		this.availableSmallBlockSize = smallBlockSize;
		this.availableMediumBlockSize = mediumBlockSize;
		this.availableLargeBlockSize = largeBlockSize;
	}
	

	public String put(Product product) throws Exception{
		if(product.getProductSize() <= this.availableSmallBlockSize) {
			productsInSmallBlock.add(product);
			this.availableSmallBlockSize -= product.getProductSize();
		}
		else {			
			if(!this.canStoreInSmallBlock(product)) {
				System.out.println("Can not Store in small block");
				if(!this.canStoreInMediumBlock(product)) {
					System.out.println("Can not Store in medium block");
					if(!this.canStoreInLargeBlock(product)) {
						throw new Exception("Can not Store product");		
					}
				}				
			}
		}
		return product + " stored";
	}
	
	public boolean canStoreInSmallBlock(Product product) {
		int overSize = product.getProductSize() - availableSmallBlockSize;
		if(!productsInSmallBlock.isEmpty()) {
			Product removeProduct = new Product();
			removeProduct.setProductSize(smallBlockSize);
			for(Product p : productsInSmallBlock) {
				if(p.getProductSize() >= overSize && removeProduct.getProductSize() > p.getProductSize()) 
					removeProduct = p;
			}
			if(removeProduct.getProductName()!=null)
				if(canStoreInMediumBlock(removeProduct)) {
					productsInSmallBlock.remove(removeProduct);
					availableSmallBlockSize += removeProduct.getProductSize() - product.getProductSize();
					return productsInSmallBlock.add(product);
				}
		}
		return false;
	}
	
	
	public boolean canStoreInMediumBlock(Product product) {
		if(product.getProductSize() <= availableMediumBlockSize){
			availableMediumBlockSize -= product.getProductSize();
			return productsInMediumBlock.add(product);
		}
		else{
			int overSize = product.getProductSize() - availableMediumBlockSize;
			if(!productsInMediumBlock.isEmpty()) {
				Product removeProduct = new Product();
				removeProduct.setProductSize(mediumBlockSize);
				for(Product p : productsInSmallBlock) {
					if(p.getProductSize() >= overSize && removeProduct.getProductSize() > p.getProductSize())
						removeProduct = p;
				}
				if(removeProduct.getProductName()!=null)
					if(canStoreInLargeBlock(removeProduct)) {
						availableMediumBlockSize -= product.getProductSize();
						return productsInMediumBlock.add(product);
					}
			}
		}
		return false;
	}
		
	public boolean canStoreInLargeBlock(Product product) {
		if(product.getProductSize() <= availableLargeBlockSize) {
			availableLargeBlockSize -= product.getProductSize();
			return productsInLargeBlock.add(product);
		}
		else
			return false;
	}

	@Override
	public String toString() {
		return "Refrigerator [smallBlockSize=" + smallBlockSize + ", mediumBlockSize=" + mediumBlockSize
				+ ", largeBlockSize=" + largeBlockSize + ", availableSmallBlockSize=" + availableSmallBlockSize
				+ ", availableMediumBlockSize=" + availableMediumBlockSize + ", availableLargeBlockSize="
				+ availableLargeBlockSize + ", productsInSmallBlock=" + productsInSmallBlock
				+ ", productsInMediumBlock=" + productsInMediumBlock + ", productsInLargeBlock=" + productsInLargeBlock
				+ "]";
	}


	public int getSmallBlockSize() {
		return smallBlockSize;
	}


	public void setSmallBlockSize(int smallBlockSize) {
		this.smallBlockSize = smallBlockSize;
	}


	public int getMediumBlockSize() {
		return mediumBlockSize;
	}


	public void setMediumBlockSize(int mediumBlockSize) {
		this.mediumBlockSize = mediumBlockSize;
	}


	public int getLargeBlockSize() {
		return largeBlockSize;
	}


	public void setLargeBlockSize(int largeBlockSize) {
		this.largeBlockSize = largeBlockSize;
	}


	public int getAvailableSmallBlockSize() {
		return availableSmallBlockSize;
	}


	public void setAvailableSmallBlockSize(int availableSmallBlockSize) {
		this.availableSmallBlockSize = availableSmallBlockSize;
	}


	public int getAvailableMediumBlockSize() {
		return availableMediumBlockSize;
	}


	public void setAvailableMediumBlockSize(int availableMediumBlockSize) {
		this.availableMediumBlockSize = availableMediumBlockSize;
	}


	public int getAvailableLargeBlockSize() {
		return availableLargeBlockSize;
	}


	public void setAvailableLargeBlockSize(int availableLargeBlockSize) {
		this.availableLargeBlockSize = availableLargeBlockSize;
	}


	public List<Product> getProductsInSmallBlock() {
		return productsInSmallBlock;
	}


	public void setProductsInSmallBlock(List<Product> productsInSmallBlock) {
		this.productsInSmallBlock = productsInSmallBlock;
	}


	public List<Product> getProductsInMediumBlock() {
		return productsInMediumBlock;
	}


	public void setProductsInMediumBlock(List<Product> productsInMediumBlock) {
		this.productsInMediumBlock = productsInMediumBlock;
	}


	public List<Product> getProductsInLargeBlock() {
		return productsInLargeBlock;
	}


	public void setProductsInLargeBlock(List<Product> productsInLargeBlock) {
		this.productsInLargeBlock = productsInLargeBlock;
	}

	
	
	
}
