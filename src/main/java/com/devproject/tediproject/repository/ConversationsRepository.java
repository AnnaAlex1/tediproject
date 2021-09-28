package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Conversations;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ConversationsRepository extends JpaRepository<Conversations, Long>, ConversationsRepositoryCustom { }
