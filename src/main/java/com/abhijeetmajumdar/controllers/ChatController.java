package com.abhijeetmajumdar.controllers;


import com.abhijeetmajumdar.models.ChatRequest;
import com.abhijeetmajumdar.models.ChatResponse;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.spec.McpSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final static Logger LOG = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    private ChatClient myChatClient;

    @Autowired
    List<McpSyncClient> mcpSyncClients;

    @Autowired
    ToolCallbackProvider toolCallbackProvider;

    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        try {
            McpSyncClient syncClient = mcpSyncClients.get(0);
            System.out.println(syncClient.listTools());
            System.out.println(syncClient.callTool(new McpSchema.CallToolRequest("findAllChaseOfferings", Map.of("", ""))));
            String userMessage = request.getMessage();

            String content = myChatClient.prompt()
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