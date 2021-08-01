package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Admin;

import java.util.*;

public class AdminDao implements Dao<Admin>{

    private List<Admin> admins = new ArrayList<>();

    public AdminDao(List<Admin> admins) {
        this.admins = admins;
    }

    @Override
    public Optional<Admin> get(long id){
        return Optional.ofNullable(admins.get((int)id));
    }

    @Override
    public List<Admin> getAll(){
        return admins;
    }

    @Override
    public void insert(Admin admin){
        admins.add(admin);
    }

    @Override
    public void update(Admin admin, String[] params){
        admin.setUsername(Objects.requireNonNull(
                params[0], "Username cannot be null"));
        admin.setPassword(Objects.requireNonNull(params[1], "Password cannot be null"));

        admins.add(admin);
    }

    @Override
    public void delete(Admin admin){
        admins.remove(admin);
    }

}