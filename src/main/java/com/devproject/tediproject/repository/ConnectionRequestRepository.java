package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.ConnectionRequest;
import com.devproject.tediproject.model.ConnectionRequestId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConnectionRequestRepository extends JpaRepository<ConnectionRequest, ConnectionRequestId>, ConnectionRequestRepositoryCustom {

}
