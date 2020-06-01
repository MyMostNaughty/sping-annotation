package com.zixue.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// 告诉Spring当前类是切面类，而不是普通类
@Aspect
public class LogAspects {
	//抽取公共的切入点表达式
	//1、本来引用
	//2.其他的切面引用(调用本方法的全路径：com.zixue.aop.LogAspects.pointCut())
	@Pointcut("execution(public int com.zixue.aop.MathCalculator.*(..))")
	public void pointCut(){
		
	}

	//@Before在目标方法之前切入：切入点表达式（指定在哪个方法切入）
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		System.out.println(joinPoint.getSignature().getName()+"运行。。。。。@Before参数列表是：{"+Arrays.asList(args)+"}");
	}
	
	@After("pointCut()")
	public void logEnd(JoinPoint joinPoint){
		System.out.println(joinPoint.getSignature().getName()+"结束。。。。@After");
	}
	
	// JoinPoint这个参数一定要出现在参数表的第一位，放在其他位置报错
	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn(JoinPoint joinPoint,Object result){
		System.out.println(joinPoint.getSignature().getName()+"正常返回。。。。。@AfterReturning返回结果：{"+result+"}");
	}
	
	@AfterThrowing(value="pointCut()",throwing="exception")
	public void logException(JoinPoint joinPoint,Exception exception){
		System.out.println(joinPoint.getSignature().getName()+"异常。。。。。@AfterThrowing异常信息：{"+exception+"}");
	}
}
