package anil.springboot.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import anil.springboot.rentACar.entities.concretes.Brand;

public interface IBrandRepository extends JpaRepository<Brand, Integer> { // Brand dediğim yer primary key, int de onun türü
	boolean existsByName(String name);	
}

/* 
JPA sayesinde bu interface'in concrete'inin oluşturulmasına gerek yoktur.
Bellekte sanki implement edilmiş gibi yerini tutar.
 */

/*  JPA Repositorynin keywordlere göre otomatik sorgu yazma özelliği var.
	Dolayısıyla concrete'ini yazmadan da biz bu sorguları atabiliriz.
	// Spring JPA keywords
*/