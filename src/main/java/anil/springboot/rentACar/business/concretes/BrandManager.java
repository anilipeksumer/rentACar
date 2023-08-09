package anil.springboot.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import anil.springboot.rentACar.business.abstracts.IBrandService;
import anil.springboot.rentACar.business.request.CreateBrandRequest;
import anil.springboot.rentACar.business.request.UpdateBrandRequest;
import anil.springboot.rentACar.business.response.GetAllBrandsResponse;
import anil.springboot.rentACar.business.response.GetByIdBrandResponse;
import anil.springboot.rentACar.business.rules.BrandBusinessRules;
import anil.springboot.rentACar.common.utilites.mappers.IModelMapperService;
import anil.springboot.rentACar.dataAccess.abstracts.IBrandRepository;
import anil.springboot.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service //bu sınıf bir business nesnesidir.
@AllArgsConstructor
public class BrandManager implements IBrandService {
	private IBrandRepository brandRepository; //Loosely Coupled, business'ın interface dışında haberi yok
	private IModelMapperService modalMapperService;
	private BrandBusinessRules brandBusinessRules;


	@Override
	public List<GetAllBrandsResponse> getAll() {
		// iş kuralları
		List<Brand> brands = brandRepository.findAll();
				
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this.modalMapperService.forResponse()
				.map(brand, GetAllBrandsResponse.class)				
				).collect(Collectors.toList());
		return brandsResponse;
	}



	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getBrandName());
		Brand brand = this.modalMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}



	@Override
	public GetByIdBrandResponse getById(int Id) {
		Brand brand = this.brandRepository.findById(Id).orElseThrow();
		GetByIdBrandResponse response = this.modalMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		
		
		return response;
	}



	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modalMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);

	}



	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
	}

}
