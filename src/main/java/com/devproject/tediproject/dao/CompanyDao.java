package com.devproject.tediproject.dao;


import com.devproject.tediproject.model.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CompanyDao implements Dao<Company>{

    private List<Company> companies = new ArrayList<>();

    public CompanyDao(List<Company> companies) {  this.companies = companies;  }

//    @Override
//    public Optional<Company> get(String name) { return Optional.ofNullable((companies.get((String)name)); }
//    @Override
//    public Optional<Comment> get(long id) { return Optional.ofNullable(comments.get((int)id)); }


    @Override
    public List<Company> getAll() { return  companies; }

    @Override
    public void insert(Company company) { companies.add(company); }

    @Override
    public void update(Company company, String[] params){
        company.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
        companies.add(company);
    }

    @Override
    public void delete(Company company){
        companies.remove(company);
    }

}
