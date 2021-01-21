package br.ufrgs.inf.pet.dinoapi.websocket.service.queue;

import br.ufrgs.inf.pet.dinoapi.entity.user.User;
import br.ufrgs.inf.pet.dinoapi.service.auth.OAuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericQueueMessageService {
    private final SimpMessagingTemplate simpMessagingTemplate;

    private final OAuthServiceImpl authService;

    @Autowired
    public GenericQueueMessageService(SimpMessagingTemplate simpMessagingTemplate,
                                             OAuthServiceImpl authService) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.authService = authService;
    }

    public <T> void send(T data, String url, User user) {
        final List<String> webSocketTokens = authService.getAllUserWebSocketToken(user);
        final String dest = this.generateQueueDest(url);
        for (String webSocketToken : webSocketTokens) {
            this.simpMessagingTemplate.convertAndSendToUser(webSocketToken, dest, data);
        }
    }

    private String generateQueueDest(String url) {
        return "/queue/" + url;
    }

}
