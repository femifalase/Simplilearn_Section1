package ap.commons.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "colors")
public class Color {

	@Id
	//@GeneratedValue
	@Column(name = "ID")
	private long COLORID;

	@Column(name = "color_name")
	private String name;
	
	@Column(name="product_id")
	private String productId;
	
	public Color() {

	}

	public Color(String name) {
		this.COLORID = 0;
		this.name = name;
	}

	public long getCOLORID() {
		return this.COLORID;
	}

	public String getName() {
		return this.name;
	}

	public void setCOLORID(long id) {
		this.COLORID = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
