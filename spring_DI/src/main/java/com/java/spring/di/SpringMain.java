package com.java.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.java.general.Calculator;

public class SpringMain {

	public static void main(String[] args) {
		
		//context loader : xml(application-context.xml)을 읽는다
		//GenericXmlApplicationContext : 컨테이너 생성(xml에 있는 객체들 뽑아서 조립하는 역할)
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:application-context.xml");
		
		//컨테이너에게 bean 받기
		//"calculator" : 이름 모르면 Calculator(=타입).class만 써도 가능하지만 다형성을 위해 함부로 쓰지 말자
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		
		cal.sum(3, 5);
		cal.sum(3, 5, 10);
		
	}
	
}
