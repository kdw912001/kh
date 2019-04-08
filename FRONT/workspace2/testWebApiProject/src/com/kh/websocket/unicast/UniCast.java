package com.kh.websocket.unicast;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/unicast")
public class UniCast {
	//연결한 사용자 리스트 저장용 필드
	//단 한 사용자가 2번 연결하면 안되기 때문에
	//Set 을 통해 연결정보에 대한 중복을 배제한다.
	private static Set<Session> clients = 
		Collections.synchronizedSet(
			new HashSet<Session>());	
	
	@OnOpen
	public void onOpen(Session session){
		//서버에 연결하는 시점에서 실행되는 메소드임.
		System.out.println(session);
		//연결 요청한 사용자를 Set 에 추가함
		clients.add(session);
	}
	
	@OnMessage
	public void onMessage(String msg, 
			Session session) throws IOException{
		//서버로 전송온 메세지를 받는 메소드임.
		System.out.println(msg);
		
		//메세지를 받아서 다른 사용자에게 전송하는 동안
		//사용자 변경이 발생하지 않도록 동기화 처리함
		//NullPointerException 이 발생하지 않도록 처리
		synchronized(clients){
			//현재 연결된 모든 사용자에게 받은 메세지를
			//보낸다.
			for(Session client : clients){
				//보낸 당사자는 빼고 보냄
				if(!client.equals(session)){
					client.getBasicRemote().sendText(msg);
				}
			}
		}
	}
	
	@OnError
	public void onError(Throwable error){
		//메세지 전송 과정에서 에러가 발생한 경우
		error.printStackTrace();
	}
	
	@OnClose
	public void onClose(Session session){
		clients.remove(session);
	}
}









