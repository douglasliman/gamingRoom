package com.gamingroom.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O nome do produto é obrigatório")
	@Size(min = 1, max = 100, message = "O atriburo deve conter no mínimo 05 e no máximo 100 caracteres")
	private String nome;

	@NotNull(message = "O idade minina para compra do produto é obrigatório")
	@Size(min = 1, max = 100, message = "O atriburo deve conter no mínimo 05 e no máximo 100 caracteres")
	private String idade;

	@DecimalMin(value = "0.00", inclusive = false, message = "O preço deve ser maior que zero")
	@Digits(integer = 6, fraction = 2, message = "O preço deve ter até 6 dígitos inteiros e 2 decimais")
	private BigDecimal preco;

	@ManyToOne
	@JsonIgnoreProperties("categoria")
	private Categoria categoria;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
