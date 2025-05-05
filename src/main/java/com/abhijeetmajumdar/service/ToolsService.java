package com.abhijeetmajumdar.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class ToolsService {
    @Tool(description = "Details about Abhijeet?")
    public String abhijeet() {
        return "hello, Abhijeet Majumdar!";
    }

    @Tool(description = "say hello to someone")
    public String helloTo(@ToolParam(description = "name of the guy you want to say hello to") String name) {
        return "Hello, " + name;
    }
    }
