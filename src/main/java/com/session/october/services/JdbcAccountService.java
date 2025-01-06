package com.session.october.services;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JdbcAccountService extends AccountService {

	@Override
	public void print() {
		log.info("From JDBC Account Service.");
	}
}