package center.alora.archetypes.jpa;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Game
 *
 */
@Entity
public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private String clasification;
	private Float price;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cat_id")
	private Category category;
	

	public Game() {
		super();
	}   
	
	public Game(String name) {
		this.name = name;
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClasification() {
		return clasification;
	}

	public void setClasification(String clasification) {
		this.clasification = clasification;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Game@: [ id: "+this.getId()+
				" , name: " + this.getName()+ 
				" , description: " + this.getDescription()+ 
				" , clasificacion: " + this.getClasification()+ 
				", price: "+ this.getPrice()+
				", category: " + this.getCategory()+
	            "]";
	}
	
	
   
}
