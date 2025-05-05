package com.abhijeetmajumdar.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigs {
    private final ChatClient.Builder builder;
    @Autowired
    private ToolCallbackProvider toolCallbackProvider;

    public BeanConfigs(ChatClient.Builder builder) {
        this.builder = builder;
    }

    @Bean
    public ChatClient chatClient() {

        return this.builder
                .defaultTools(toolCallbackProvider.getToolCallbacks())
                .build();
    }

}
