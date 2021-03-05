package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestaRelacionamento {
    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setAgencia(78945);
        conta.setNumero(6549);
        conta.setSaldo(300.0);
        conta.setTitular("Danilo");

        Movimentacao movimentacao = new Movimentacao();

        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setValor(new BigDecimal("200.0"));
        movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
        movimentacao.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.persist(movimentacao);
        em.getTransaction().commit();
        em.close();
    }
}
