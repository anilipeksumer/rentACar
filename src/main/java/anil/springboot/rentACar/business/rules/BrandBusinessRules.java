package anil.springboot.rentACar.business.rules;

import org.springframework.stereotype.Service;

import anil.springboot.rentACar.common.utilites.exceptions.BusinessException;
import anil.springboot.rentACar.dataAccess.abstracts.IBrandRepository;
import lombok.AllArgsConstructor;

/*
 	İş kurallarımızın tatik tanımlanmasına gerek yok Injectionla çalışıyoruz.
 	Singleton ile çalışacağız.
 */
@Service
@AllArgsConstructor
public class BrandBusinessRules {
	private IBrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand name already exists!");
		}
	}
}
