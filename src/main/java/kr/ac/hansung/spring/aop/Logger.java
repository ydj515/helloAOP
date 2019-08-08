package kr.ac.hansung.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logger {

	//target method 지정
	@Pointcut("execution(  void kr.ac.hansung.spring.aop.*.sound() )")
	
	//java 에서 id 값 지정(point cut id)
	private void selectSound() { //signature
		
	}
	
	//위에서 지정한 point cut id를 넣어준다
	@Before("selectSound()")
	public void aboutToSound() {
		System.out.println("before advice : about to sound()");
	}
}
