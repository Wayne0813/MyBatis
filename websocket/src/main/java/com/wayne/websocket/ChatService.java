package com.wayne.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author LV
 * @date 2018/7/12
 */
@ServerEndpoint("/weChat")
public class ChatService {
    private Session session  = null;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        System.out.println("连接已经接通");
    }

    @OnMessage
    public void onMessage(String msg){

        try {
            this.session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("信息已经传递,message: " + msg);
    }

    @OnError
    public void onError(Throwable th){
        System.out.println("连接已超时");
    }

    @OnClose
    public void onClose(){
        System.out.println("连接已关闭");
    }



}
