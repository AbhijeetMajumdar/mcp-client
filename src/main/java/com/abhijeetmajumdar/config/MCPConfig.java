package com.abhijeetmajumdar.config;

import com.abhijeetmajumdar.service.ToolsService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MCPConfig {
    @Bean
    ToolCallbackProvider toolCallbackProvider(ToolsService toolsController) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(toolsController)
                .build();
    }
}
