package anil.springboot.rentACar.common.utilites.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapperManager implements IModelMapperService {

	private ModelMapper modelMapper;
	
	@Override
	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);

		return this.modelMapper;
		
		/*
		 * LOOSE stratejisi ile maplenmesi şunu beraberinde getirir.
		 * Diyelim ki bizim veri tabanımızda id,name,x,y,z gibi alanlar olsun.
		 * Eğer ben sadece name ve x alanlarının maplenmesini istiyorsam diğerleri requestte gelmediğinde,
		 * maplenmemelerine kızma!!!
		 * 
		 * Yani şöyle, benim adama döndüğüm response'un generic olmasını, istediğim alanların görüntülenmesini
		 * sağlamaktadır.
		 */
		
		
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		
		return this.modelMapper;
	}

}
//Bizim kullandığımız request-response yapısı -> DTO (Data Transform Object)

