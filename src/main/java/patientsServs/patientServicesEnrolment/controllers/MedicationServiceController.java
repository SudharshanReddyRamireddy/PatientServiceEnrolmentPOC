package patientsServs.patientServicesEnrolment.controllers;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import patientsServs.patientServicesEnrolment.ServiceLayer.MedicationService;
import patientsServs.patientServicesEnrolment.models.Medication;

@RestController
@RequestMapping("/api")
public class MedicationServiceController {
	
	@Autowired
	private MedicationService medicationService;
	
	
	//fetching all medicines list
	@GetMapping("/medicines")
	public ResponseEntity<List<Medication>> getAllMedicines() throws BadRequestException{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(medicationService.getAllMedicines());
			
		} catch (Exception e) {
			throw new BadRequestException(e.getMessage());
		}
	}
	
	
	
	// fetching all medicines list by patient id
	@GetMapping("/medicines/{patientId}")
	public ResponseEntity<List<Medication>> getAllMedicinesByPatientId(@PathVariable("patientId") Long patientId) throws BadRequestException{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(medicationService.getAllMedicinesByPatientId(patientId));
		} catch (Exception e) {
			throw new BadRequestException(e.getMessage());
		}
	}

}
