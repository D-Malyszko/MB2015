package test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 */
public class SampleInterceptor {

//    @PostConstruct
//    public void init(InvocationContext context) throws Exception{
//        System.out.println("SampleInterceptor > PostConstruct > init");
//        context.proceed();
//    }

    @AroundConstruct
    public Object construct(InvocationContext context) throws Exception {
        System.out.println("SampleInterceptor > construct");
        return context.proceed();
    }

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
    
        System.out.println("SampleInterceptor > invoke");
        
        System.out.println("SimpleInterceptor - Logging BEFORE calling method :"+context.getMethod().getName() );

	Object result = context.proceed();

	System.out.println("SimpleInterceptor - Logging AFTER calling method :"+context.getMethod().getName() );

	return result;
	
    }
        
        
    
    @PreDestroy
    public void destroy(InvocationContext context) throws Exception {
        System.out.println("SampleInterceptor > PreDestroy > destroy");
        context.proceed();
    }
}
