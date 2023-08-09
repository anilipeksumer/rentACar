package anil.springboot.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import anil.springboot.rentACar.entities.concretes.Model;

public interface IModelRepository extends JpaRepository<Model, Integer>  {

}
