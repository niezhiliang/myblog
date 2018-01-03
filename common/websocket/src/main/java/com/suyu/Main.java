package com.suyu;

import com.suyu.server.SocketServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Main {

    @Bean
    public SocketServer getSocketService (SocketServer socketServer) {
        return new SocketServer();
    }
}
