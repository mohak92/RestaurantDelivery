package project.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User_Cart {
	
	@Id
	@GeneratedValue
	int id;
	int user_id;
	int menuitemid;
	double row_price;
	double tax;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMenuitemid() {
		return menuitemid;
	}
	public void setMenuitemid(int menuitemid) {
		this.menuitemid = menuitemid;
	}
	public double getRow_price() {
		return row_price;
	}
	public void setRow_price(double row_price) {
		this.row_price = row_price;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
}
