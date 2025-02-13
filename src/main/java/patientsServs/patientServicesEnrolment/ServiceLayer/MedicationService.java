package patientsServs.patientServicesEnrolment.ServiceLayer;

import java.util.ArrayList;
import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import patientsServs.patientServicesEnrolment.Repositories.MedicationRepository;
import patientsServs.patientServicesEnrolment.Repositories.PatientRepository;
import patientsServs.patientServicesEnrolment.models.Disease;
import patientsServs.patientServicesEnrolment.models.Medication;
import patientsServs.patientServicesEnrolment.models.Patient;

@Service
public class MedicationService {
	
	@Autowired
	private MedicationRepository medicationRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	
	
	
	public List<Medication> getAllMedicines(){
		return medicationRepository.findAll();
	}
	
	
	public List<Medication> getAllMedicinesByPatientId(Long patientId) throws BadRequestException{
		
		List<Medication> medicinesList =  new ArrayList<Medication>();
		
		Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new BadRequestException("ERROR : PATIENT NOT FOUND"));
		
		for (Disease disease : patient.getDiseases()) {
			medicinesList.addAll(disease.getMedications());
		}
		return medicinesList;
	}
	

}
