package com.example.metier;

import java.util.List;

import com.example.dao.CompanyRepository;
import com.example.entities.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyMetierImpl implements CompanyMetier {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company saveCompany(Company c) {
		return companyRepository.save(c);
	}

	@Override
	public List<Company> listCompany() {
		return companyRepository.findAll();
	}

}
