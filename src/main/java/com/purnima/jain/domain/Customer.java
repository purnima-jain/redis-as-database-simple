package com.purnima.jain.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("CUSTOMER_STORE") // @RedisHash(value = "CUSTOMER_STORE", timeToLive = 20000)
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // This id annotation is NOT from spring-data-jpa
	private String customerId;

	@Indexed
	private String firstName;

	@Indexed
	private String lastName;

}
