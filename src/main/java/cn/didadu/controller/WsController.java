package cn.didadu.controller;

import cn.didadu.domain.WiselyMessage;
import cn.didadu.domain.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by jinggg on 16/4/23.
 */

@Controller
public class WsController {


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg){

    }


    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }

}
