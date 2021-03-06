package com.jsp.test;

public class Parent {

	private static Parent instance = new Parent();
	private Parent() {}
	public static Parent getInstance() {
		return instance;
	}
	
	//child에 인스턴스를 안줘서 MainServlet 실행해도 nullPointerException 뜸
	//그래서 web.xml에 listener 사용하면 해결됨
	private Child child;
	public void setChild(Child child) {
		this.child = child;
	}
	
	public String resultSum(int a, int b) throws Exception {
		String resultSum = "";
		int result = child.sum(a, b);
		
		resultSum = a + "와 " + b + "를 더한 결과는 " + result + "입니다.";
		return resultSum;
	}
}
