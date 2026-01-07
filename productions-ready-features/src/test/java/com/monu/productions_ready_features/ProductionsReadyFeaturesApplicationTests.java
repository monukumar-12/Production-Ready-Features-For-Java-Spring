package com.monu.productions_ready_features;

import com.monu.productions_ready_features.clients.EmployeeClient;
import com.monu.productions_ready_features.dto.EmployeeDto;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ProductionsReadyFeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	@Order(3)
	void getAllEmployeesTest() {
		List<EmployeeDto> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

	@Test
	@Order(2)
	void getEmployeeByIdTest() {
		EmployeeDto employeeDTO = employeeClient.getEmployeeById(100L);
		System.out.println(employeeDTO);
	}

	@Test
	@Order(1)
	void createNewEmployeeTest() {
		EmployeeDto employeeDTO = new EmployeeDto(null, "monu", "monu@gmail.com", 16,
				"USER", LocalDate.of(2020, 12, 1), true);
		EmployeeDto savedEmployeeDTO = employeeClient.createNewEmployee(employeeDTO);
		System.out.println(savedEmployeeDTO);
	}



}
