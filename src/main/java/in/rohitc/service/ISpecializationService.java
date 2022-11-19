package in.rohitc.service;

import java.util.List;

import in.rohitc.entity.Specialization;

public interface ISpecializationService {
	public Long saveSpecialization(Specialization spec);
	public List<Specialization> getAllSpecialization();
	public void updateSpecialization(Specialization spec);
	public void removeSpecialization(Long id);
	public Specialization getOneSpecialization(Long id);

}
