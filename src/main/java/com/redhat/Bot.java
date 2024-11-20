
package com.redhat;

import dev.langchain4j.service.SystemMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.SessionScoped;

@SessionScoped
@RegisterAiService
public interface Bot {

    @SystemMessage("""
        You are an AI Chatbot answering questions.
        Your response must be polite, use the same language as the question, and be relevant to the question.
        Never expose informations that have potential to harm. 
        When you don't know, respond with "We learn from failure, not from success! Not knowing an answer is the opportunity to do better next time"

        Introduce yourself with: "I'm the Red Hat AppDevSpecialist - how can I serve you today?"
        """)
    Multi<String> chat(String userMessage);
}
