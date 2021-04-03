package com.purnima.jain.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPutRequestDto {

	private String customerId;
	private String firstName;
	private String lastName;

}