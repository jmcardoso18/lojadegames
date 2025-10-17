package com.generation.lojadegames.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


	
	@Entity
	@Table(name="tb_categorias")//create table tb_postagens
	public class Categoria {
		
		@Id //Primary key (id)
		@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
		private Long id;
		
		@Column(length=100)//Campo nome não pode ser nulo e deve ter o tamanho entre 5 e 100 caracteres
		@NotBlank(message= "O atrituto nome é obrigatório!")
		@Size(min=5,max=100, message="O atributo nome deve conter contém no minimo 05 e no máximo 100 caracteres")
		private String nome;
		
		@NotNull(message="O Campo 'ativo' é obrigatório")//Campo para determinar se a categoria está ativa ou não
		private Boolean ativo;
				
		//Relacionamento com a tabela Produto
		@OneToMany(fetch = FetchType.LAZY,mappedBy ="categoria",cascade=CascadeType.REMOVE)
		@JsonIgnoreProperties (value = "categoria",allowSetters=true)
		private List<Produto> produto;

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

		public Boolean getAtivo() {
			return ativo;
		}

		public void setAtivo(Boolean ativo) {
			this.ativo = ativo;
		}

		public List<Produto> getProduto() {
			return produto;
		}

		public void setProduto(List<Produto> produto) {
			this.produto = produto;
		}
				
		
	}


