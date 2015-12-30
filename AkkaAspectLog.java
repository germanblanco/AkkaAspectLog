package gbbaspecttest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AkkaAspectLog {
  @Pointcut(value = "execution (* hello(..))")
  public void helloPointcut() {}

  @Before(value = "helloPointcut()")
  public void helloHello() {
    System.out.println("Yahoooo.");
  }
}
