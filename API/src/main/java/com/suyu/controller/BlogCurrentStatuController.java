package com.suyu.controller;

import com.suyu.server.SocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * websocket
 * 消息推送(个人和广播)
 */
@Controller
@RequestMapping(value = "blogstatus")
public class BlogCurrentStatuController {
    @Autowired
    private SocketServer socketServer;

    /**
     * 个人信息推送
     * @return
     */
    @RequestMapping("sendmsg")
    @ResponseBody
    public String sendmsg(String msg,String username){
        //第一个参数 :msg 发送的信息内容
        //第二个参数为用户长连接传的username
        SocketServer.sendMessage(msg,username);
        return "success";
    }

    /**
     * 推送给所有在线用户
     * @return
     */
    @RequestMapping("sendAll")
    @ResponseBody
    public String sendAll(String msg){
        SocketServer.sendAll(msg);
        return "success";
    }

    /**
     * 获取当前在线用户
     * @return
     */
    @RequestMapping("webstatus")
    public String webstatus(){
        //当前用户个数
       int count = SocketServer.getOnlineNum();
       //当年用户的username
       SocketServer.getOnlineUsers();
        return "tongji";
    }
}
