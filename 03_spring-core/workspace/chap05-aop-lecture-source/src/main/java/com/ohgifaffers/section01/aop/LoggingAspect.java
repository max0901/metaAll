package com.ohgifaffers.section01.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAspect {
    //공통되는 관심사
    @Pointcut("execution(* com.ohgifaffers.section01.aop.*Service.*(..))")
    //aop패키지않에잇는 모든 @Service
    //memberService class의 모든 메소드
    public void logPointCut(){
        //pointcut은 반드시 void

    }
    @Before("LoggingAspect.logPointCut()")
    public void logBefore(JoinPoint joinPoint){
        //주소 위치에서 실행
        //advice
        System.out.println("Befoe joinPoint.getTarget()"+ joinPoint.getTarget());
        System.out.println("Befoe joinPoint.getSignature()"+ joinPoint.getSignature());
        if(joinPoint.getArgs().length>0){
            for(Object param:joinPoint.getArgs()){
                System.out.println(param);
            }
        }
    }
    @After("logPointCut()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After joinPoint.getSignature()"+ joinPoint.getSignature());
    }
    @AfterReturning(pointcut = "logPointCut()",returning = "result")
    public void logAfterReturning(JoinPoint joinPoint,Object result){
        System.out.println("afterReturning result :" + result);
    }
    @AfterThrowing(pointcut = "logPointCut()",throwing = "exception")
    public void logAfterThrowing(Throwable exception){
        System.out.println("exception.getMessage() = " + exception.getMessage());
    }
    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //사전에 동작할 내용
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        Object result=joinPoint.proceed();
        //사후에 동작할 내용
        stopWatch.stop();

        System.out.println("메소드 수행에 걸린시간 : "+ stopWatch.getTotalTimeMillis()+"(ms)");
        return result;
    }
}
