package com.treinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.domain.Pagamento;
import com.treinamento.domain.Pedido;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
