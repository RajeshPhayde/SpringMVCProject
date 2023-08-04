package com.project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.repo.RecipientRepo;

@Service
public class RecipientService {

	@Autowired
	RecipientRepo repo;
	
	public String sendAmount(int id, String name, int amt) {
		return repo.sendAmount(id,name,amt);
	}

	public String deleteData(int id) {
		return repo.deleteData(id);
	}

	public String updateRecipient(int id, int amt) {
		return repo.updateRecipient(id,amt);
	}

	public String fetchAll() {
		return repo.fetchAll();
	}

}
