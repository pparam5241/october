package com.session.october.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsyncService {
	
	@Async
	public void sampleWaitMethod() throws InterruptedException {
		log.info("Async Execution Started");
		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
		}
		log.info("Async Execution Completed");
	}
}