package org.dmwm.universal.core.aspectz;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.dmwm.universal.core.stats.StatsHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAspect {
	
	@Autowired
	StatsHolder sh;
	
	private static final Logger log = Logger.getLogger(SampleAspect.class);

	@Pointcut("execution(* *.process(..))") //  && !execution(* org.dmwm.universal.sys1.processors.GzPacker.process(..))
	private void processors(){}
	
	@Pointcut("execution(* org.dmwm.universal.sys1.processors.SOAPProcessor.process(..))")
	private void soapproc(){}
	
//	@Around("soapproc()")
//	public void frontEndDelay(ProceedingJoinPoint jp) throws Throwable{
//		log.warn("Delay for frontend aspect! (1000 ms)");
//		jp.proceed();
//	}
	
	@AfterReturning("processors() && args(msg)")
	public void logProcessor(JoinPoint jp, Exchange msg){
//		log.warn("ASPECT: " + jp.getTarget().getClass().getSimpleName());
		sh.putStat("Aop_" + jp.getTarget().getClass().getSimpleName());
	}
	
	
}
