package com.treinamento.domain;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.treinamento.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer estado;
	
	@MapsId
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	public Pagamento() {
	}

	public Pagamento(EstadoPagamento estado, Pedido pedido) {
		super();
		this.estado = (estado == null) ? null : estado.getCod();
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
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
