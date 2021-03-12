package br.com.alura.jpa.modelo.dao;

import br.com.alura.jpa.modelo.MediaComData;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class MovimentacaoDao {
    private EntityManager em;
    public MovimentacaoDao(EntityManager em) {
        this.em = em;
    }
 public List<MediaComData> getMediaDiariaMovimentacoes() {

        TypedQuery<MediaComData> query3 = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);
        return query3.getResultList();
    }

    public BigDecimal getSomaMovimentacoes() {
        String jpql = "select sum (m.valor) from Movimentacao m";

        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
        return query.getSingleResult();
    }

    public Double getMediaDasMovimentacoes() {
        String jpql = "select avg (m.valor) from Movimentacao m";

        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        return query.getSingleResult();
    }


}
