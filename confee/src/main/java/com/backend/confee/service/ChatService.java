package com.backend.confee.service;

import com.backend.confee.dto.ChatMessageDTO;

import java.util.List;

public interface ChatService {

    ChatMessageDTO sendMessage(ChatMessageDTO chatMessageDTO);

    List<ChatMessageDTO> getMessagesBetweenUsers(String sender, String recipient);

    List<ChatMessageDTO> getMessagesForUser(String recipient);
}