package com.generation.lojadegames.model;

import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;


	
	@Entity
	@Table(name="tb_produtos")//create table tb_postagens
	public class Produto {
		
		@Id //Primary key (id)
		@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
		private Long id;
		
		@Column(length=100)
		@NotBlank(message= "O atrituto nome é obrigatório!")
		@Size(min=3,max=100, message="O atributo nome deve conter contém no minimo 05 e no máximo 100 caracteres")
		private String nome;
		
		@Column(length=1000)
		@NotBlank(message= "O atrituto descricao é obrigatório!")
		@Size(min=10,max=1000, message="O atributo descricao deve conter contém no minimo 05 e no máximo 100 caracteres")
		private String descricao;
		
		@NotNull(message= "O atrituto preço é obrigatório!")
		@PositiveOrZero(message="O preço deve ser positivo ou zero")
		private Double preco;
		
		@NotNull(message= "O atrituto quantidade do estoque é obrigatório!")	
		@PositiveOrZero(message="A quantidade deve ser positiva ou zero")
		private int quantidade_estoque;
		
		@UpdateTimestamp
		private LocalDate data_cadastro;
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Categoria categoria;

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

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Double getPreco() {
			return preco;
		}

		public void setPreco(Double preco) {
			this.preco = preco;
		}

		public int getQuantidade_estoque() {
			return quantidade_estoque;
		}

		public void setQuantidade_estoque(int quantidade_estoque) {
			this.quantidade_estoque = quantidade_estoque;
		}

		public LocalDate getData_cadastro() {
			return data_cadastro;
		}

		public void setData_cadastro(LocalDate data_cadastro) {
			this.data_cadastro = data_cadastro;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
			
	}

