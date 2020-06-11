package com.biblioteca.biblioteca.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="livros")
public class Livros {
	
	@Id                                                         
	@GeneratedValue(strategy = GenerationType.IDENTITY)         
	private long id;                                            
	                                                            
	@NotNull                                                    
	@Size(min=5, max=100)                                       
	private String nome;                                 
	                                                            
	@NotNull                                                    
	@Size(min=10, max=1000)                                     
	private String descricao;                           
	                                                            
	@NotNull                                                    
	@Size(min=10, max=500)                                      
	private String editora;                              
	                                                                                                                          
	@NotNull                                                                                          
	private long paginas;
	
	@NotNull                                                                                          
	private long isbn;


	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public String getEditora() {
		return editora;
	}


	public void setEditora(String editora) {
		this.editora = editora;
	}


	public long getPaginas() {
		return paginas;
	}


	public void setPaginas(long paginas) {
		this.paginas = paginas;
	}


	public long getIsbn() {
		return isbn;
	}


	public void setIsbn(long isbn) {
		this.isbn = isbn;
	} 
	
	
	
	
}
