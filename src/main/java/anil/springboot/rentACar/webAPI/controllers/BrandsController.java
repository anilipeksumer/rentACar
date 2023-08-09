package anil.springboot.rentACar.webAPI.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import anil.springboot.rentACar.business.abstracts.IBrandService;
import anil.springboot.rentACar.business.request.CreateBrandRequest;
import anil.springboot.rentACar.business.request.UpdateBrandRequest;
import anil.springboot.rentACar.business.response.GetAllBrandsResponse;
import anil.springboot.rentACar.business.response.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands") // İletişimi sağlar
@AllArgsConstructor
public class BrandsController {
	private IBrandService brandService;
	
	
	
// AllArgsConstuctor kullanarak aşağıdakini iptal etmeyi başardık.
	
//	@Autowired // constructor parametrelerine bak, git uygulamayı tara, implemente edeni newle bana ver.
//	// Spring'in yeni versionlarında Autowired yazmasak da çalışıyor.
//	public BrandsController(IBrandService brandService) {
//		this.brandService = brandService;
//	}
	
	
	@GetMapping() // 'api/brands/getAll'
	public List<GetAllBrandsResponse> getAll(){
		//IoC -> Inversion of Control: git bellekte newle, isteyene referansını ver.
		
		return brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
		
	}
	
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	
	@PutMapping()
	public void update(@RequestBody  UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}
	
	/*
	 * Eski sistemlerde kullanılan hali aşağıda. Artık Spring çoğu annotation'ı otomatik tanıyor.
	 * web.bind.annotation altından gelmeli, aynı isimde swagger'da da var.
	 */
	
//	@PostMapping("/add")
//	public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
//		this.brandService.add(createBrandRequest);
//	}
	
}
