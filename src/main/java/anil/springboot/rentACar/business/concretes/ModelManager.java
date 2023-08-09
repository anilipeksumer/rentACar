package anil.springboot.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import anil.springboot.rentACar.business.abstracts.IModelService;
import anil.springboot.rentACar.business.request.CreateModelRequest;
import anil.springboot.rentACar.business.response.GetAllModelsResponse;
import anil.springboot.rentACar.common.utilites.mappers.IModelMapperService;
import anil.springboot.rentACar.dataAccess.abstracts.IModelRepository;
import anil.springboot.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements IModelService {

	private IModelRepository modelRepository;
	private IModelMapperService modelMapperService;
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model -> this.modelMapperService.forResponse()
					.map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
		
		return modelsResponse;
		
		
		
	}
	@Override
	public void add(CreateModelRequest createModelRequest) {

		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
	}

}
