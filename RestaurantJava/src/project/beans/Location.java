package project.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
public class Location {
	@Id
	@GeneratedValue
	int id;
	String location_name;
	String address;
	@Transient
	CommonsMultipartFile imageFile;
	
	String city;
	String zipcode;
	String image;
	int staffs;
	
	
	public CommonsMultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(CommonsMultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStaffs() {
		return staffs;
	}
	public void setStaffs(int staffs) {
		this.staffs = staffs;
	}
	
}
