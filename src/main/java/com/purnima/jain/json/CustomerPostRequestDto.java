package com.purnima.jain.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPostRequestDto {

	private String firstName;
	private String lastName;

}