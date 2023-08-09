package anil.springboot.rentACar.business.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
	//validation of req. fields (model eklemek istiyorsan name'i gir.
	
	@NotBlank
	@Size(min = 1, max = 20)
	private String modelName;
	
	
	@NotNull
	private int brandId;

}