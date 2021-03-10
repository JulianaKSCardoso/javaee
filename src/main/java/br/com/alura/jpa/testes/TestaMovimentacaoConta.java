package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.*;

public class TestaMovimentacaoConta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Movimentacao movimentacao = em.find(Movimentacao.class, 1L);
        Conta conta = movimentacao.getConta();
        int quantidadeDeMovimentacoes;
        quantidadeDeMovimentacoes = conta.getMovimentacoes().size();

        System.out.println("Quantidade de movimentações: " + quantidadeDeMovimentacoes);
        System.out.println("Titular da conta: " + conta.getTitular());

    }
}
