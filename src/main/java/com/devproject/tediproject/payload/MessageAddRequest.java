package com.devproject.tediproject.payload;

import java.util.List;

public class MessageAddRequest {

    Long conversationId;
    List<ContentAddRequest> content;

    public MessageAddRequest(Long conversationId, List<ContentAddRequest> content) {
        this.conversationId = conversationId;
        this.content = content;
    }

    public Long getConversationId() {
        return conversationId;
    }

    public List<ContentAddRequest> getContent() {
        return content;
    }
}
