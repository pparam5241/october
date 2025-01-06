package com.session.october.services;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MyTestAnnotation
public class CommonService {

	public void test() {
		log.info("test() method called from CommonService.");
	}
}