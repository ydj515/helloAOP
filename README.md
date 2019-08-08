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

# AOP Definition

- **Aspect**  
-흩어진 관심사를 모듈화 한 것
-주로 부가기능을 모듈화
-EX) logging, profileing, security, transaction

- **Join Point**  
-Aspect를 적용하는 곳(class, method..)

- **Advice**  
-실질적으로 어떤 일을 해야할 지에 대한 것, 실질적인 부가기능을 담은 구현체

- **Pointcut**  
-JointPoint의 상세한 스펙을 정의한 것  

![3](https://user-images.githubusercontent.com/32935365/62728083-d4ff5300-ba55-11e9-9e68-1bae6e81c198.PNG)



