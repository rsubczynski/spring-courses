package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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

}
