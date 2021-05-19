package com.capgemini.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Mechanics;
import com.capgemini.entities.ServiceCatalog;
import com.capgemini.entities.ServiceRequest;
import com.capgemini.entities.Vehicle;
import com.capgemini.repository.MechanicsRepository;
import com.capgemini.repository.ServiceCatalogRepository;
import com.capgemini.repository.ServiceRequestRepository;
import com.capgemini.repository.VehicleRepository;
@Service
public class ServiceRequestServiceImpl implements IServiceRequestService {

	@Autowired
	private ServiceRequestRepository serreqrepository;
	
	@Autowired
	private VehicleRepository vehiclerepository;
	
	@Autowired
	private ServiceCatalogRepository sercatrepo;
	
	@Autowired
	private MechanicsRepository mechanicsrepository;
	@Override
	public String createServiceRequest(ServiceRequest serviceRequest) {
		if(serviceRequest.getVehicle()!=null) {
			Vehicle vehi=vehiclerepository.findById(serviceRequest.getVehicle().getVehicle_reg_no()).get();
			serviceRequest.setVehicle(vehi);
		}
		if(serviceRequest.getServiceCatalog()!=null) {
			ServiceCatalog ser_cat=sercatrepo.findById(serviceRequest.getServiceCatalog().getService_catalog_id()).get();
			serviceRequest.setServiceCatalog(ser_cat);
		}
		if(serviceRequest.getMechanics()!=null) {
			Mechanics mech=mechanicsrepository.findById(serviceRequest.getMechanics().getMechanicsId()).get();
			serviceRequest.setMechanics(mech);
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		serviceRequest.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		serviceRequest.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		serviceRequest.date = java.time.LocalDateTime.now().format(formatter);
		
		serreqrepository.save(serviceRequest);
		return "Request Added!!!";
	}

	@Override
	public String updateServiceRequest(int serviceRequest_id, ServiceRequest serviceRequest) {
		ServiceRequest dbServiceRequest= serreqrepository.findById(serviceRequest_id).get();
		if(dbServiceRequest!=null) {
			
			dbServiceRequest.setStatus(serviceRequest.getStatus());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			serviceRequest.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		}
		serreqrepository.save(dbServiceRequest);
			return "Status Updated";
	}

	@Override
	public ServiceRequest getServiceRequestById(int serviceRequest_id) {
		return serreqrepository.findById(serviceRequest_id).get();
	}

	@Override
	public List<ServiceRequest> getRequest() {
		return serreqrepository.findAll();
	}

	@Override
	public String deleteServiceRequest(int serviceRequest_id) {
		ServiceRequest dbServiceRequest= serreqrepository.findById(serviceRequest_id).get();
		if(dbServiceRequest.isDeleted == false) {
			dbServiceRequest.isDeleted = true;
			serreqrepository.save(dbServiceRequest);
		}
		return "Service Request Deleted";
	}

}
