
public class Product {
	int stock;
	int price;
	Product(int stock, int price){
		this.stock = stock;
		this.price = price;
	}
	int getStock(){
		return stock;
	}
	int getPrice(){
		return price;
	}
	void setStock(int newStock){
		this.stock = newStock;
	}
	void sell(int amount){
		if(this.stock - amount >= 0)
		this.stock -= amount;
		
		else throw new RuntimeException();
	}
}
