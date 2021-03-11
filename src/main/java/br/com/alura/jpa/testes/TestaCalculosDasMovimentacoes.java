package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class TestaCalculosDasMovimentacoes {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        String jpql = "select avg (m.valor) from Movimentacao m";

        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        Double mediaDasMovimentacoes = query.getSingleResult();

        System.out.println("A media das movimentacoes é R$: " + mediaDasMovimentacoes);

        //Calcula soma das movimentacoes
        String jpql2 = "select sum (m.valor) from Movimentacao m";

        TypedQuery<BigDecimal> query2 = em.createQuery(jpql2, BigDecimal.class);
        BigDecimal somaDasMovimentacoes = query2.getSingleResult();

        System.out.println("A soma das movimentacoes é R$: " + somaDasMovimentacoes);

        //calcula media diaria das movimentacoes
        String jpql3;
        jpql3 = "select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor)," +
                " day(m.data)," +
                " month(m.data))" +
                "  from Movimentacao m group by " +
                "day(m.data)," +
                " month(m.data)," +
                " year(m.data)";

        TypedQuery<MediaComData> query3 = em.createQuery(jpql3, MediaComData.class);
        List<MediaComData> mediaDiariaDasMovimentacoes = query3.getResultList();

        for (MediaComData resultado : mediaDiariaDasMovimentacoes) {
            System.out.println("As média de movimentacoes do dia "
                            + resultado.getDia()
                            + "/"
                            + resultado.getMes()
                            + " é: R$ " + resultado.getValor());

        }
    }
}
