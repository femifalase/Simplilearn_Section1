package ap.commons.hibernate.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "eproduct")
public class EProductAnnotated {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long ID;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "date_added")
	private Date dateAdded;

	@OneToMany
	@JoinColumn(name = "product_id")
	private List<Color> colors;

	public EProductAnnotated() {

	}

	public EProductAnnotated(long id, String name, BigDecimal price, Date dateAdded) {
		this.ID = id;
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
	}

	public String getColors() {
		StringBuffer sb = new StringBuffer();
		if(colors!=null) {
			for(Color c : colors) {
				sb.append(c.getName()+",");
			}
		}
		
		return sb.toString();
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public long getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setID(long id) {
		this.ID = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setDateAdded(Date date) {
		this.dateAdded = date;
	}
}
