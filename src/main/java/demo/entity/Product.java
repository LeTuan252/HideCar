package demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PRODUCTS")
public class Product {
	 public static final String ROLE_MANAGER = "MANAGER";
	 public static final String ROLE_EMPLOYEE = "EMPLOYEE";
	 
	 @Id
	 @Column(name="Code", length = 20, nullable = false)
	 private String code;
	 
	 @Column(name="Name", length = 255, nullable = false)
	 private String name;
	 
	 @Column(name="Price", nullable = false)
	 private double price;
	 
	 @Lob
	 @Column(name="Image", nullable = true, length = Integer.MAX_VALUE)
	 private byte[] image;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name="Create_Date", nullable = false)
	 private Date createDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
