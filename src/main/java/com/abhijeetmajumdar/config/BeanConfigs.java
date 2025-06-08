package com.abhijeetmajumdar.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigs {

    @Bean
    public ChatMemory chatMemory() {
        return new InMemoryChatMemory();
    }


    @Bean
    public MessageChatMemoryAdvisor messageChatMemoryAdvisor(ChatMemory chatMemory) {
        return new MessageChatMemoryAdvisor(chatMemory);
    }

    @Bean
    public ChatClient myChatClient(ChatClient.Builder builder, ToolCallbackProvider toolCallbackProvider, MessageChatMemoryAdvisor messageChatMemoryAdvisor) {
        ChatModel chatModel = OllamaChatModel.builder()
                .ollamaApi(OllamaApi.builder().build())
                .defaultOptions(OllamaOptions.builder()
                        .model(OllamaModel.LLAMA3_2_1B)
                        .temperature(0.6)
                        .toolCallbacks(toolCallbackProvider.getToolCallbacks())
                        .build())
                .build();

        ChatClient chatClient = ChatClient.builder(chatModel)
                .defaultSystem("You are Chase Bank assistant, and a friendly Chat bot. ")
                .defaultAdvisors(messageChatMemoryAdvisor)
                .build();

        return chatClient;
    }

}
