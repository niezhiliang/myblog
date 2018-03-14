package com.suyu.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@ServerEndpoint(value = "/socketServer/{userid}")
@Component
public class SocketServer {

	private Session session;
	private static Map<String,Session> sessionPool = new HashMap<String,Session>();
	private static Map<String,String> sessionIds = new HashMap<String,String>();
	private static Map<String,String> onlinesize = new HashMap<String, String>();
	private static Set<String> online = new HashSet<String>();


	@OnOpen
	public void open(Session session,@PathParam(value="userid")String userid){
		this.session = session;
		sessionPool.put(userid, session);
		sessionIds.put(session.getId(), userid);
		online.add(userid);
	}

	@OnMessage
	public void onMessage(String message){
		System.out.println("当前发送人sessionid为"+session.getId()+"发送内容为"+message);
	}

	@OnClose
	public void onClose(@PathParam(value="userid")String userid){
		sessionPool.remove(sessionIds.get(session.getId()));
		sessionIds.remove(session.getId());
		online.remove(userid);
	}

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

	public static void sendMessage(String message,String userId){
		Session s = sessionPool.get(userId);
		if(s!=null){
			try {
				s.getBasicRemote().sendText(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static int getOnlineNum(){
		return online.size();
	}

	public static String getOnlineUsers(){
		StringBuffer users = new StringBuffer();
	    for (String key : sessionIds.keySet()) {
		   users.append(sessionIds.get(key)+",");
		}
	    return users.toString();
	}

	public static void sendAll(String msg) {
		for (String key : sessionIds.keySet()) {
			sendMessage(msg, sessionIds.get(key));
	    }
	}
}
