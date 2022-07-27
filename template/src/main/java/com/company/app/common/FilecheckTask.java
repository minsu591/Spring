package com.company.app.common;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FilecheckTask {
	//@Scheduled(fixedRate = 5000)
	public void checkFile() {
		System.out.println("task Run...");
	}
}
