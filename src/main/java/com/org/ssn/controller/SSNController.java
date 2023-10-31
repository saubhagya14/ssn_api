package com.org.ssn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.ssn.model.CitizenInfo;

@RestController
public class SSNController {

	@GetMapping("/check-ssn")
	public CitizenInfo checkSsn(@RequestBody CitizenInfo citizenInfo) {

		char prefix = citizenInfo.getSsn().charAt(0);

		switch (prefix) {
		case '1':
			citizenInfo.setStateName("New Jersey");
			break;
		case '2':
			citizenInfo.setStateName("Ohio");
			break;
		case '3':
			citizenInfo.setStateName("Texas");
			break;
		case '4':
			citizenInfo.setStateName("California");
			break;
		case '5':
			citizenInfo.setStateName("Rhode Island");
			break;
		case '6':
			citizenInfo.setStateName("Kentucky");
			break;
		default:
			citizenInfo = new CitizenInfo();
			citizenInfo.setStatus("Failed");
			citizenInfo.setMessage("Invalid SSN");
			citizenInfo.setCode(201);

		}

		return citizenInfo;

	}
}
