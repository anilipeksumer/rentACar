package anil.springboot.rentACar.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "models")
@Getter // Sadece Getter oluştursun.
@Setter
@AllArgsConstructor // Lombok consturctor with parameters.
@NoArgsConstructor 
@Entity
public class Model {

	@Id //db'de primary keysin.
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne()
	@JoinColumn(name="brand_id")
	private Brand brand;
}
