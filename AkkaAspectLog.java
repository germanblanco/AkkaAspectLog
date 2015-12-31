package gbbaspecttest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AkkaAspectLog {

  @Pointcut(value = "execution (* getLogger(..))")
  public void loggerInfoPointcut() {}

  @Before(value = "loggerInfoPointcut()")
  public void loggerInfoHit() {
    System.out.println("Hit Logger Info pointcut.");
  }

  @Pointcut(value = "execution (* hello(..))")
  public void helloPointcut() {}

  @Before(value = "helloPointcut()")
  public void helloHit() {
    System.out.println("Hit hello pointcut.");
  }
}
