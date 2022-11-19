package in.rohitc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rohitc.entity.Specialization;
import in.rohitc.repository.SpecializationRepository;
import in.rohitc.service.ISpecializationService;

@Service
public class ISpecializationServiceImpl implements ISpecializationService {
	
	@Autowired
	private SpecializationRepository repo;

	@Override
	public Long saveSpecialization(Specialization spec) {
		return repo.save(spec).getId();
	}

	@Override
	public List<Specialization> getAllSpecialization() {		
		return repo.findAll();
	}

	@Override
	public void updateSpecialization(Specialization spec) {
	repo.save(spec);

	}
	
	@Override
	public void removeSpecialization(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public Specialization getOneSpecialization(Long id) {
		Optional<Specialization> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}

	}
}