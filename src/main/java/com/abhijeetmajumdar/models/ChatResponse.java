package com.abhijeetmajumdar.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatResponse {
    public String getContent() {
        return content;
    }

    public ChatResponse(String content) {
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    String content;
}
