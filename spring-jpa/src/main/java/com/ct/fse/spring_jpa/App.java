package com.ct.fse.spring_jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ct.fse.Model.Trainee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("trainee-unit");
        EntityManager entityManager=factory.createEntityManager();
        EntityTransaction tx=entityManager.getTransaction();
//        Trainee trainee=new Trainee(102,"Aditya","aditya@gmail.com",LocalDate.of(1998,10,15));
//        tx.begin();
//        entityManager.persist(trainee);
//        tx.commit();
        Trainee trainee=entityManager.find(Trainee.class, 102);
//        System.out.println(trainee);
        trainee.setTraineeName("Harshit");
        tx.begin();
        entityManager.persist(trainee);
        tx.commit();
        System.out.println("Transaction completed");
        
    }
}
