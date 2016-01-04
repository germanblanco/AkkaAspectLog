package gbbaspecttest

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

import net.logstash.logback.marker.Markers
import net.logstash.logback.marker.LogstashMarker

import scala.collection.JavaConverters._

import java.util.HashMap

@Aspect
class AkkaAspectLog {

      @Pointcut(value = "execution ( * "
              + "net.logstash.logback.marker.Markers.appendEntries(..)) "
              + "&& args(map)",
              argNames = "map")
      def appendEntriesPointcut(map : java.lang.Object) {}

      @Around(value = "appendEntriesPointcut(map)", argNames = "jp,map")
      def appendEntriesHit(jp : ProceedingJoinPoint,
                           map : java.util.Map[java.lang.String, java.lang.Object]) : java.lang.Object = {
        val out : Array[java.lang.Object] = Array(map)
        jp.proceed(out)
      }
/*
    @Pointcut(value = "execution (net.logstash.logback.marker.LogstashMarker "
                                     + "net.logstash.logback.marker.Markers.appendEntries(map)) "
                                     + "&& args(map)",
              argNames = "map")
    def appendEntriesPointcut(map : java.lang.Object) {}

    @Before(value = "appendEntriesPointcut(map)", argNames = "jp,map")
    def appendEntriesHit(jp : JoinPoint, map : java.lang.Object) {
      println("Hit Append Entries pointcut.")
    }

    @Pointcut(value = "execution (* getLogger(..))")
    def loggerInfoPointcut() {}

    @Before(value = "loggerInfoPointcut()")
    def loggerInfoHit() {
      println("Hit Logger Info pointcut.")
    }

    @Pointcut(value = "execution (* hello(..))")
    def helloPointcut() {}

    @Before(value = "helloPointcut()")
    def helloHit() {
      println("Hit hello pointcut.")
    }
  */
}
