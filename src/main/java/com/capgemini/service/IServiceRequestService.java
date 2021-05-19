package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.ServiceRequest;

public interface IServiceRequestService {
String createServiceRequest(ServiceRequest serviceRequest);
String updateServiceRequest(int serviceRequest_id,ServiceRequest serviceRequest);
ServiceRequest getServiceRequestById(int serviceRequest_id);
List<ServiceRequest> getRequest();
String deleteServiceRequest(int serviceRequest_id );
}
