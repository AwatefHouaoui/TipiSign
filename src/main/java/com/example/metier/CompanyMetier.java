package com.example.metier;

import java.util.List;

import com.example.entities.Company;

public interface CompanyMetier {
	public Company saveCompany(Company c);

	public List<Company> listCompany();

}
