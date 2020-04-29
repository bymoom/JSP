package com.jsp.listener;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.jsp.action.ApplicationContext;

@WebListener
public class InitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent ctxEvent)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent ctxEvent)  { 
    	/*String sqlSessionFactoryType = ctxEvent.getServletContext().getInitParameter("sqlSessionFactory");

    	List<String> DAOType = new ArrayList<String>();
    	DAOType.add(ctxEvent.getServletContext().getInitParameter("memberDAO"));
    	DAOType.add(ctxEvent.getServletContext().getInitParameter("boardDAO"));
    	DAOType.add(ctxEvent.getServletContext().getInitParameter("replyDAO"));
    	String memberDAOType = ctxEvent.getServletContext().getInitParameter("memberDAO");
    	String boardDAOType = ctxEvent.getServletContext().getInitParameter("boardDAO");
    	String replyDAOType = ctxEvent.getServletContext().getInitParameter("replyDAO");

    	try {
    		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) Class.forName(sqlSessionFactoryType).newInstance();
    		
    		//dao에 어떤 타입의 메소드, 클래스 Impl이 올지 몰라서 와일드카드 사용
    		Class<?> cls = Class.forName(memberDAOType);
    		Class<?> cls2 = Class.forName(boardDAOType);
    		
    		//"setSessionFactory" : 원래 set메소드를 for문으로 돌려서 확인해야한다
    		//getMethod(메소드명, 메소드의 파라미터타입들(가변배열)->지금은 하나) -> 일단 있는지 확인
    		Method setSqlSessionFactory = cls.getMethod("setSessionFactory", SqlSessionFactory.class);
    		
    		Object obj = cls.newInstance();
    		Object obj2 = cls2.newInstance();
    		//invoke(obj, sqlSessionFactory) : 있으니 확인해봤으면 알아서해라...
    		//"setSqlSessionFactory"야, 너 obj에 있으니까 어떻게 실행하는지 가서 확인해봐
    		//갈때 sqlSessionFactory 이거 챙겨가
    		setSqlSessionFactory.invoke(obj, sqlSessionFactory);
    		
    		MemberDAO memberDAO = (MemberDAO) obj;
    		MemberServiceImpl.getInstance().setMemberDAO(memberDAO);

    		BoardDAO boardDAO = (BoardDAO) obj2;
    		BoardServiceImpl.getInstance().setBoardDAO(boardDAO);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}*/
    	
    	/**
    	 * 블럭(인스턴스:web.xml에 쓴 dao, service들) 조립
    	 */
    	Map<String, Object> applicationContext = ApplicationContext.getApplicationContext();

		ServletContext ctx = ctxEvent.getServletContext();

		// 1. 인스턴스 생성
		Enumeration<String> paramNames = ctx.getInitParameterNames(); //web.xml 명단 가져오기(파라미터 이름들)

		//컨테이너(applicationContext)에 인스턴스 넣기
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String classType = ctx.getInitParameter(paramName); //get param-value
			try {
				Class<?> cls = Class.forName(classType);

				Object targetObj = cls.newInstance(); //인스턴스 생성

				applicationContext.put(paramName, targetObj);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// 2. 인스턴스 의존성 확인(클래스가 어떤 타입인지, 안에 어떤 내용있는지 확인) 및 조립
		paramNames = ctx.getInitParameterNames(); //nextElement() 다 하면 마지막에 머물기 때문에 처음으로 돌아가기위해 재할당
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String classType = ctx.getInitParameter(paramName);
			
			try {
				Class<?> cls = Class.forName(classType);

				Method[] methods = cls.getMethods(); //(proxy에 있는)클래스안에 메서드 꺼내서 확인

				for (Method method : methods) {
					if (method.getName().contains("set")) { //set메서드 있는지 확인
						
						System.out.println(method.getName());
						
						//메서드 이름에서 set을 지우고 남은 글자의 첫글자를 소문자로 바꾸고 뒤글자들을 붙이기
						String setInstanceName = ((method.getName().replace("set", "")).charAt(0) + "").toLowerCase()
								+ method.getName().substring(4);
						
						//컨테이너(applicationContext)에 있는 인스턴스에 있는 set메서드에 해당 객체 넣어줘(boardServiceImpl에 있는 setBoardDao에 boardDao를 넣어줘)
						//setBoardDAO.invoke(BoardServiceImpl(싱행할곳), boardDAO(변수))
						method.invoke(applicationContext.get(paramName), applicationContext.get(setInstanceName));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(applicationContext);
    }
	
}
