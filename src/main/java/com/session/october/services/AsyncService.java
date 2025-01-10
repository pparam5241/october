package com.session.october.services;

import java.util.concurrent.CompletableFuture;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsyncService {

	@Async
	public CompletableFuture<Void> sampleWaitMethod(int num) throws InterruptedException {
		log.info("Async Execution Started");
		for (int i = 0; i < num; i++) {
			Thread.sleep(1000);
		}
		log.info("Async Execution Completed");
		return CompletableFuture.completedFuture(null);
	}
}