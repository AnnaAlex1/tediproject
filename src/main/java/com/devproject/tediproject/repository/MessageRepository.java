package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long>{
    List<Message> findByConversationId(Long id);
}
