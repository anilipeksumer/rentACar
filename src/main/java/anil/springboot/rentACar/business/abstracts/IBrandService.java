package anil.springboot.rentACar.business.abstracts;

import java.util.List;

import anil.springboot.rentACar.business.request.CreateBrandRequest;
import anil.springboot.rentACar.business.request.UpdateBrandRequest;
import anil.springboot.rentACar.business.response.GetAllBrandsResponse;
import anil.springboot.rentACar.business.response.GetByIdBrandResponse;

public interface IBrandService { // iş kurallarını yazacağım yapı
	// Response-Request Pattern kullanılacak!
	
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int Id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
	

	
}
