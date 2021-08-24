package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long>{
}
