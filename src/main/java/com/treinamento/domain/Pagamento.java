package com.treinamento.domain;

import java.io.Serializable;
import java.util.Objects;

import com.treinamento.domain.enums.EstadoPagamento;

public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private EstadoPagamento estado;

	private Pedido pedido;

	public Pagamento() {
	}

	public Pagamento(EstadoPagamento estado, Pedido pedido) {
		super();
		this.estado = estado;
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public EstadoPagamento getEstado() {
		return estado;
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", estado=" + estado + ", pedido=" + pedido + "]";
	}

}
