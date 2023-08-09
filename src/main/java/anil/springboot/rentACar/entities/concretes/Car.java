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

@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name = "plate")
	private String plate;
	
	@Column(name = "dailyPrice")
	private double dailyPrice;
	  
	@Column(name = "modelYear")
	private int modelYear;
	
	@Column (name = "status")
	private int status;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
}