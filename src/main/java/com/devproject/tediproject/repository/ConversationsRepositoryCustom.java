package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Conversations;

import java.util.List;

public interface ConversationsRepositoryCustom {
    public List<Conversations> getConversationsByProf1(Long profId);
}
