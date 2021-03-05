package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraSaldoContaLeonardo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta contaDoLeonardo = em.find(Conta.class, 3);

        em.getTransaction().begin();

        contaDoLeonardo.setSaldo(20.0);
        contaDoLeonardo.setTitular("Leonardo");

        em.getTransaction().commit();

    }
}
