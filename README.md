# helloAOP

## What is AOP?
- **영역 지향 프로그래밍**으로써 프로그램의 영역이 수행프로그램 컴파일 방법을 결정하는 프로그래밍 방법
- 로깅, 트랜잭션, 보안 등 여러 모듈에서 **공통적으로 사용하는 기능을 분리하여 관리**  
- **AspectJ**를 포함하여 사용할 수 있고, 스프링에서 지원하는 실행에 조합하는 방식도 지원한다. 
  
![1](https://user-images.githubusercontent.com/32935365/62727245-fcedb700-ba53-11e9-8365-b56377894df5.PNG)
-위와 같이 3개의 모듈이 로깅, 트랜잭션, 보안등의 기능을 사용한다면 따로 분리해서 재사용 가능하게 한다!

## AOP Weaving(삽입)

- **runtime시에 삽입**  
![2](https://user-images.githubusercontent.com/32935365/62727469-82716700-ba54-11e9-89cf-04559d315ced.PNG)

## AOP Definition

- **Aspect**  
-흩어진 관심사를 모듈화 한 것
-주로 부가기능을 모듈화  
  - **logging, profileing, security, transaction**

- **Join Point**  
-Aspect를 적용하는 곳(class, method..)

- **Advice**  
-실질적으로 어떤 일을 해야할 지에 대한 것, 실질적인 부가기능을 담은 구현체  
  - **Before** : Aspect 전에 실행  
  - **After** : Aspect 후에 실행  
  - **After-returning** : 메소드가 성공적으로 실행시에만 실행  
  - **After-throwing** : 메소드가 exception 발생시에만 실행  
  - **around**

- **Pointcut**  
-JointPoint의 상세한 스펙을 정의한 것  

![3](https://user-images.githubusercontent.com/32935365/62728083-d4ff5300-ba55-11e9-9e68-1bae6e81c198.PNG)

## XML 사용
- animal.xml
```xml
<bean id="id_logger" class="kr.ac.hansung.spring.aop.Logger"/>

<aop:config>
  <aop:aspect ref="id_logger" id="myAspect"> <!-- 위의 logger bean을 참조-->
    <!-- execution( 반환형 패키지.메소드 ) -->
    <aop:pointcut expression="execution( void kr.ac.hansung.spring.aop.*.sound() )" id="selectSound" />
    <!-- -before 메소드로 kr.ac.hansung.spring.aop.*.sound()를 등록 -->
    <aop:before method="aboutToSound" pointcut-ref="selectSound" />
  </aop:aspect>
</aop:config>
```

## Annotation 사용
- Logger.java
```java
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
```
