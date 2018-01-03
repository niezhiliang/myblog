package com.suyu.controller;

import com.suyu.server.SocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class WebSocketTestController {
    @Autowired
    private SocketServer socketServer;

    @RequestMapping(value = "index")
    public String idnex() {

        return "index";
    }

    @RequestMapping(value = "admin")
    public String admin(Model model) {
       int num = socketServer.getOnlineNum();
       String str = socketServer.getOnlineUsers();
       model.addAttribute("num",num);
       model.addAttribute("users",str);
        return "admin";
    }
}
