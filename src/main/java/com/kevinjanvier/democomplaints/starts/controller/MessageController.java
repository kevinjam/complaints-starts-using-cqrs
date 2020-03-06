package com.kevinjanvier.democomplaints.starts.controller;

import com.kevinjanvier.democomplaints.starts.ComplainFileEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@ProcessingGroup("amqpEvents")
@RestController
public class MessageController {

    private ConcurrentMap<String, AtomicLong> statistics = new ConcurrentHashMap<>();

    @EventHandler
    public void on(ComplainFileEvent event) {
        System.out.println("Event Complain ");
        statistics.computeIfAbsent(event.getCompany(), k -> new AtomicLong()).incrementAndGet();
    }

    @GetMapping
    public Map<String , AtomicLong> getStatistic(){
        System.out.println("----Map------ " + statistics);
        return statistics;
    }
}
