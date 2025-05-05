package com.abhijeetmajumdar.controllers;


import com.abhijeetmajumdar.models.ChatRequest;
import com.abhijeetmajumdar.models.ChatResponse;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {


    @Resource
    private ChatClient chatClient;

    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        try {

            String userMessage = request.getMessage();
            String content = chatClient.prompt()
                    .user(userMessage)
                    .call()
                    .content();

            return ResponseEntity.ok(new ChatResponse(content));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ChatResponse("Ollama: " + e.getMessage()));
        }
    }

}