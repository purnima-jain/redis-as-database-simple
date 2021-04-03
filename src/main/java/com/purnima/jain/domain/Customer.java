package com.purnima.jain.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("CUSTOMER_TABLE")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // This id annotation is NOT from spring-data-jpa
	private String customerId;

	private String firstName;

	private String lastName;

}
