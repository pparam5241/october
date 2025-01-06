package com.session.october.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("jpaAccountService")
public class JpaAccountService extends AccountService {

	@Override
	public void print() {
		log.info("From Jpa Account Service.");
	}
}