package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
		
		System.out.println("\n=====> Executing @AfterReturning on method: " + method);

		System.out.println("\n=====> Executing result is: " + result);
	}

	private void convertAccountToUpperCase(List<Account> result) {
		for (Account temp : result) {
			temp.setLevel(temp.getLevel().toUpperCase());
			temp.setName(temp.getName().toUpperCase());
		}
	}

}
