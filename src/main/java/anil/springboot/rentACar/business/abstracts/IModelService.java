package anil.springboot.rentACar.business.abstracts;

import java.util.List;

import anil.springboot.rentACar.business.request.CreateModelRequest;
import anil.springboot.rentACar.business.response.GetAllModelsResponse;

public interface IModelService {
	List<GetAllModelsResponse> getAll();
	void add (CreateModelRequest createModelRequest);

}
