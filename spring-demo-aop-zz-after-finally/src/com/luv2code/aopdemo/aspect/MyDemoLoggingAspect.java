package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinpoint) {
		System.out.println("\n========>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinpoint.getSignature();
		System.out.println("Method: " + methodSig);

		// display method arguments

		// get args
		Object[] args = theJoinpoint.getArgs();

		// loop thru agrs
		for (Object tempArgs : args) {
			System.out.println(tempArgs);
			if (tempArgs instanceof Account) {
				Account theAccount = (Account) tempArgs;
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());

			}
		}

	}

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		String method = theJoinPoint.getSignature().toShortString();

		System.out.println("\n=====> Executing @AfterReturning on method: " + method);

		System.out.println("\n=====> Executing result is: " + result);

		convertAccountToUpperCase(result);

		System.out.println("\n=====> Executing result is: " + result);
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinpoint, Throwable theExc) {

		String method = theJoinpoint.getSignature().toShortString();
		System.out.println("\n=====> Executing @AfterThrowing on method: " + method);
		System.out.println("\n=====> The exception is: " + theExc);

	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccountAdvice(JoinPoint theJoinpoint) {
		String method = theJoinpoint.getSignature().toShortString();
		System.out.println("\n=====> Executing @After on method: " + method);
	}

	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=====> Executing @Around on method: " + method);
		
		
		long begin = System.currentTimeMillis();
		
		Object result = theProceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		System.out.println("\n====> Dutation: " + duration / 1000.0 + "");
		return result;
	}

	private void convertAccountToUpperCase(List<Account> result) {
		for (Account temp : result) {
			temp.setLevel(temp.getLevel().toUpperCase());
			temp.setName(temp.getName().toUpperCase());
		}
	}

}
