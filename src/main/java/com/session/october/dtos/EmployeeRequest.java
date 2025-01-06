package com.session.october.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRequest {

	@NotBlank(message = "name is required.")
	private String name;

	@NotNull(message = "departmentId is required.")
	private Long departmentId;
}