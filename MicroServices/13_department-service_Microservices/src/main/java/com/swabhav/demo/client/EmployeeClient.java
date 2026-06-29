package com.swabhav.demo.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.swabhav.demo.dto.EmployeeResponse;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class EmployeeClient {

	private final WebClient webClient;
	
	@Value("${employee.service.url}")
	private String employeeStringUrl;
	
	public List<EmployeeResponse> getEmployeeByDepartmentId(long departmentId) {

	    String url = employeeStringUrl + "/employees/department/" + departmentId;

	    List<EmployeeResponse> employees = webClient
	            .get()
	            .uri(url)
	            .retrieve()
	            .bodyToFlux(EmployeeResponse.class)
	            .collectList()
	            .block();

	    return employees;
	}
	
}
