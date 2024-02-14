package com.treinamento.domain;

import com.treinamento.domain.enums.EstadoPagamento;

public class PagamentoComCatao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;

	public PagamentoComCatao() {
	}

	public PagamentoComCatao(EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	@Override
	public String toString() {
		return "PagamentoComCatao [numeroDeParcelas=" + numeroDeParcelas + "]";
	}

}
