package br.ufjf.dcc193.atividade9.login;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Around("execution(* *..*.*Controller.*(..))")
    public Object doLog(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("Método iniciando: " + jp.getSignature());
        try {
            Object retorno = jp.proceed();
            System.out.println("Método concluído: " + jp.getSignature());
            return retorno;

        } catch (Exception e) {
            System.out.println("Método interrrompido: " + jp.getSignature());
            e.printStackTrace();
            throw e;
        }
    }

    @Around("execution(* *..*.*DAOImpl*.*(..))")
    public Object doDAOLog(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("Método iniciando: " + jp.getSignature());
        try {
            Object retorno = jp.proceed();
            System.out.println("Método concluído: " + jp.getSignature());
            return retorno;

        } catch (Exception e) {
            System.out.println("Método interrrompido: " + jp.getSignature());
            e.printStackTrace();
            throw e;
        }
    }
}
