//package com.backend.confee.service;
//
//import com.backend.confee.dto.ChatMessageDTO;
//import com.backend.confee.entity.ChatMessage;
//import com.backend.confee.repo.ChatMessageRepository;
//import com.backend.confee.service.ChatService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ChatServiceImpl implements ChatService {
//
//    @Autowired
//    private ChatMessageRepository chatMessageRepository;
//
//    @Override
//    public ChatMessageDTO sendMessage(ChatMessageDTO chatMessageDTO) {
//        ChatMessage chatMessage = new ChatMessage();
//        chatMessage.setSender(chatMessageDTO.getSender());
//        chatMessage.setRecipient(chatMessageDTO.getRecipient());
//        chatMessage.setMessage(chatMessageDTO.getMessage());
//        chatMessage.setTimestamp(LocalDateTime.now());
//
//        chatMessage = chatMessageRepository.save(chatMessage);
//
//        chatMessageDTO.setTimestamp(chatMessage.getTimestamp());
//        return chatMessageDTO;
//    }
//
//    @Override
//    public List<ChatMessageDTO> getMessagesBetweenUsers(String sender, String recipient) {
//        return chatMessageRepository.findBySenderAndRecipient(sender, recipient)
//                .stream()
//                .map(this::mapToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<ChatMessageDTO> getMessagesForUser(String recipient) {
//        return chatMessageRepository.findByRecipient(recipient)
//                .stream()
//                .map(this::mapToDTO)
//                .collect(Collectors.toList());
//    }
//
//    private ChatMessageDTO mapToDTO(ChatMessage chatMessage) {
//        ChatMessageDTO chatMessageDTO = new ChatMessageDTO();
//        chatMessageDTO.setSender(chatMessage.getSender());
//        chatMessageDTO.setRecipient(chatMessage.getRecipient());
//        chatMessageDTO.setMessage(chatMessage.getMessage());
//        chatMessageDTO.setTimestamp(chatMessage.getTimestamp());
//        return chatMessageDTO;
//    }
//}


package com.backend.confee.service;

import com.backend.confee.dto.ChatMessageDTO;
import com.backend.confee.entity.ChatMessage;
import com.backend.confee.repo.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Override
    public ChatMessageDTO sendMessage(ChatMessageDTO chatMessageDTO) {
        // Validate input DTO
        if (chatMessageDTO == null || chatMessageDTO.getSender() == null || chatMessageDTO.getRecipient() == null || chatMessageDTO.getMessage() == null) {
            throw new IllegalArgumentException("Invalid chat message data");
        }

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSender(chatMessageDTO.getSender());
        chatMessage.setRecipient(chatMessageDTO.getRecipient());
        chatMessage.setMessage(chatMessageDTO.getMessage());
        chatMessage.setTimestamp(LocalDateTime.now());

        // Save to repository and handle potential exceptions
        try {
            chatMessage = chatMessageRepository.save(chatMessage);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save chat message", e);
        }

        // Set timestamp in the response DTO
        chatMessageDTO.setTimestamp(chatMessage.getTimestamp());
        return chatMessageDTO;
    }

    @Override
    public List<ChatMessageDTO> getMessagesBetweenUsers(String sender, String recipient) {
        // Validate inputs
        if (sender == null || recipient == null) {
            throw new IllegalArgumentException("Sender and recipient must not be null");
        }

        // Fetch and map messages
        try {
            return chatMessageRepository.findBySenderAndRecipient(sender, recipient)
                    .stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve messages between users", e);
        }
    }

    @Override
    public List<ChatMessageDTO> getMessagesForUser(String recipient) {
        // Validate input
        if (recipient == null) {
            throw new IllegalArgumentException("Recipient must not be null");
        }

        // Fetch and map messages
        try {
            return chatMessageRepository.findByRecipient(recipient)
                    .stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve messages for user", e);
        }
    }

    // Helper method to map ChatMessage entity to ChatMessageDTO
    private ChatMessageDTO mapToDTO(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return null;
        }
        ChatMessageDTO chatMessageDTO = new ChatMessageDTO();
        chatMessageDTO.setSender(chatMessage.getSender());
        chatMessageDTO.setRecipient(chatMessage.getRecipient());
        chatMessageDTO.setMessage(chatMessage.getMessage());
        chatMessageDTO.setTimestamp(chatMessage.getTimestamp());
        return chatMessageDTO;
    }
}
