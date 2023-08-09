package anil.springboot.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Data // Lombok auto-generated getter,setters.
@Table(name = "brands")
@Getter // Sadece Getter oluştursun.
@Setter
@AllArgsConstructor // Lombok consturctor with parameters.
@NoArgsConstructor 
@Entity
public class Brand {
	
	@Id //db'de primary keysin.
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "brand")
	List<Model> models;
	
	
	
	
}
// 	CMD+SHIFT+O -> Delete unused imports etc.