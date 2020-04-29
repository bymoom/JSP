package com.jsp.dispatcher;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.jsp.action.Action;
import com.jsp.action.ApplicationContext;
/**
 * action과 service 연결해주는 역할
 *
 */
public class HandlerMapper {
	
	private Map<String, Action> commandMap = new HashMap<String, Action>();
	
	{
		//url.properties 라고 쓰지 않는 이유 : ResourceBundle은 properties 읽는 용도라서 알아서 읽는다
		String path = "com/jsp/properties/url";
		
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
		
		//키 중복을 방지하기 위해 Set 사용
		//keySet() : 키를 담고 있는 바구니
		Set<String> actionSetHome = rbHome.keySet();
		
		Iterator<String> it = actionSetHome.iterator();
		
		while (it.hasNext()) {
			String command = it.next();
			
			//getString() : Value 값 꺼내기
			String actionClassName = rbHome.getString(command);
			
			System.out.println(actionClassName);
			
			try {
				Class<?> actionClass = Class.forName(actionClassName);
				Action commandAction = (Action) actionClass.newInstance();
			
				//의존성 확인 및 조립
				Method[] methods = actionClass.getMethods();
				
				for(Method method : methods) {
					if(method.getName().contains("set")) {
						String paramType = method.getParameterTypes()[0].getName();
						paramType = paramType.substring(paramType.lastIndexOf(".") + 1);
						
						paramType = (paramType.charAt(0) + "").toLowerCase() + paramType.substring(1);
						
						try {
							method.invoke(commandAction, ApplicationContext.getApplicationContext().get(paramType));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
				commandMap.put(command, commandAction);
				
				System.out.println("[HandlerMapper]" + command + " : " + commandAction + "가 준비되었습니다.");
				
			} catch (ClassNotFoundException e) {
				System.out.println("[HandlerMapper]" + actionClassName + "이 존재하지 않습니다.");
			} catch (InstantiationException e) {
				System.out.println("[HandlerMapper]" + actionClassName + "인스턴스를 생성할 수 없습니다.");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Action getAction(String command) {
		Action action = commandMap.get(command);
		return action;
	}
}
