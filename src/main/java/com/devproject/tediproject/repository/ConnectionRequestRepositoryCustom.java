package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.ConnectionRequest;
import com.devproject.tediproject.model.ConnectionRequestId;

import java.util.List;

public interface ConnectionRequestRepositoryCustom {
    public List<ConnectionRequest> getCRForProf(Long profId);

    public void deleteConnectionRequest(Long fromId, Long toId);
}
