package com.wayne.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author LV
 * @date 2018/7/12
 */
@ServerEndpoint("/allChat")
public class AllChatService {
    private Session session  = null;
    private static CopyOnWriteArraySet<AllChatService> services = new CopyOnWriteArraySet<>();




    @OnOpen
    public void onOpen(Session session){
        this.session = session;

        services.add(this);

        System.out.println("连接已经接通");
    }

    @OnMessage
    public void onMessage(String msg){

        try {
            for (AllChatService service : services) {

                service.session.getBasicRemote().sendText(msg);

            }

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
        services.remove(this);
        System.out.println("连接已关闭");
    }



}
