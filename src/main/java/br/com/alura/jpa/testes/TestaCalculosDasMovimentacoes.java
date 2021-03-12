package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestaCalculosDasMovimentacoes {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        MovimentacaoDao soma = new MovimentacaoDao(em);
        System.out.println("Total de movimentações: R$ "+ soma.getSomaMovimentacoes());

        List<MediaComData> mediaDiariaDasMovimentacoes = new MovimentacaoDao(em).getMediaDiariaMovimentacoes();

        for (MediaComData resultado : mediaDiariaDasMovimentacoes) {
            System.out.println("As média de movimentacoes do dia "
                    + resultado.getDia()
                    + "/"
                    + resultado.getMes()
                    + " é: R$ " + resultado.getValor());


        MovimentacaoDao media = new MovimentacaoDao(em);
        System.out.println("A media das movimentações é R$: " + media.getMediaDasMovimentacoes());
        }
    }
}
