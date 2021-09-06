package br.ufjf.dcc193.atividade9.login;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Before("execution(* br.ufjf.dcc193.atividade9.login.LoginController.getLogin(..))")
    public void startLog(JoinPoint jp){
        System.out.println("Método iniciando: " + jp.getSignature());
    }

}
