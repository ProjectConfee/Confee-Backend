package com.backend.confee.controller;

import com.backend.confee.dto.ChatMessageDTO;
import com.backend.confee.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    public ChatMessageDTO sendMessage(@RequestBody ChatMessageDTO chatMessageDTO) {
        return chatService.sendMessage(chatMessageDTO);
    }

    @GetMapping("/conversation")
    public List<ChatMessageDTO> getConversation(
            @RequestParam String sender,
            @RequestParam String recipient) {
        return chatService.getMessagesBetweenUsers(sender, recipient);
    }

    @GetMapping("/messages")
    public List<ChatMessageDTO> getMessagesForUser(@RequestParam String recipient) {
        return chatService.getMessagesForUser(recipient);
    }
}
