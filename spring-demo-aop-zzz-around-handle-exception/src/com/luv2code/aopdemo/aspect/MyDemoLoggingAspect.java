package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	private static Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinpoint) {
		myLogger.info("\n========>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinpoint.getSignature();
		myLogger.info("Method: " + methodSig);

		// display method arguments

		// get args
		Object[] args = theJoinpoint.getArgs();

		// loop thru agrs
		for (Object tempArgs : args) {
			myLogger.info(tempArgs.toString());
			if (tempArgs instanceof Account) {
				Account theAccount = (Account) tempArgs;
				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());

			}
		}

	}

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		String method = theJoinPoint.getSignature().toShortString();

		myLogger.info("\n=====> Executing @AfterReturning on method: " + method);

		myLogger.info("\n=====> Executing result is: " + result);

		convertAccountToUpperCase(result);

		myLogger.info("\n=====> Executing result is: " + result);
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinpoint, Throwable theExc) {

		String method = theJoinpoint.getSignature().toShortString();
		myLogger.info("\n=====> Executing @AfterThrowing on method: " + method);
		myLogger.info("\n=====> The exception is: " + theExc);

	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccountAdvice(JoinPoint theJoinpoint) {
		String method = theJoinpoint.getSignature().toShortString();
		myLogger.info("\n=====> Executing @After on method: " + method);
	}

	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====> Executing @Around on method: " + method);

		long begin = System.currentTimeMillis();

		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();

		} catch (Exception e) {
			myLogger.warning(e.getMessage());
			result = "Major accident!!!!!!!!";
		}
		long end = System.currentTimeMillis();

		long duration = end - begin;

		myLogger.info("\n====> Dutation: " + duration / 1000.0 + "");

		return result;
	}

	private void convertAccountToUpperCase(List<Account> result) {
		for (Account temp : result) {
			temp.setLevel(temp.getLevel().toUpperCase());
			temp.setName(temp.getName().toUpperCase());
		}
	}

}
