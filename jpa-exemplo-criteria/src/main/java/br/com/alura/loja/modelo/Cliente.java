package br.com.alura.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded
	private DadosDoCliente dadosDoCliente;

	public Cliente(String nome, String cpf) {
		this.dadosDoCliente = new DadosDoCliente(nome, cpf);
	}

	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return dadosDoCliente.getNome();
	}

	public String getCpf() {
		return dadosDoCliente.getCpf();
	}



}
