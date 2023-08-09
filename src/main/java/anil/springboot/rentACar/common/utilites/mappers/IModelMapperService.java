package anil.springboot.rentACar.common.utilites.mappers;

import org.modelmapper.ModelMapper;

public interface IModelMapperService{
	ModelMapper forResponse();
	ModelMapper forRequest();

}
