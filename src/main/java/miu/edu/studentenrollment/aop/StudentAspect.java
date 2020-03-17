package miu.edu.studentenrollment.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StudentAspect {
    @Around("execution(* miu.edu.studentenrollment.controller.StudentController.*(..))")
    public Object transactionSafety(ProceedingJoinPoint call) {
        Object object = null;
        try {
            System.out.println("Running try catch for "+call.getSignature().getName());
            object = call.proceed();
        } catch(Throwable e){
            e.printStackTrace();
        }
        return object;
    }
}
