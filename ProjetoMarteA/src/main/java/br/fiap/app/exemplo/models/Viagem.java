package br.fiap.app.exemplo.models;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;


@Entity
public class Viagem {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO) // auto increment
	private Long id;

	
	private LocalDate dataDecolagem;

	@PositiveOrZero
	private int duracaoEstadia;

	@PositiveOrZero
	private int assentosDisponiveis;

	@Pattern(regexp = "^[a-zA-Z]{4}-\\d{4}$")
	private String nomeModeloNave;

	@NotNull(message = "O nome do primeiro comandate é obrigatório!")
	private String nomePrimeiroComandante;

	@Pattern(regexp = "^[a-zA-Z]{3}-\\d{4}-[a-zA-Z]\\d[a-zA-Z]$")
	private String matriculaPrimeiroComandante;

	@NotNull(message = "O nome do segundo comandate é obrigatório!")
	private String nomeSegundoComandante;

	@Pattern(regexp = "^[a-zA-Z]{3}-\\d{4}-[a-zA-Z]\\d[a-zA-Z]$")
	private String matriculaSegundoComandante;

	
	
	
	// getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataDecolagem() {
		return dataDecolagem;
	}

	public void setDataDecolagem(LocalDate dataDecolagem) {
		this.dataDecolagem = dataDecolagem;
	}

	public int getDuracaoEstadia() {
		return duracaoEstadia;
	}

	public void setDuracaoEstadia(int duracaoEstadia) {
		this.duracaoEstadia = duracaoEstadia;
	}

	public int getAssentosDisponiveis() {
		return assentosDisponiveis;
	}

	public void setAssentosDisponiveis(int assentosDisponiveis) {
		this.assentosDisponiveis = assentosDisponiveis;
	}

	public String getNomeModeloNave() {
		return nomeModeloNave;
	}

	public void setNomeModeloNave(String nomeModeloNave) {
		this.nomeModeloNave = nomeModeloNave;
	}

	public String getNomePrimeiroComandante() {
		return nomePrimeiroComandante;
	}

	public void setNomePrimeiroComandante(String nomePrimeiroComandante) {
		this.nomePrimeiroComandante = nomePrimeiroComandante;
	}

	public String getMatriculaPrimeiroComandante() {
		return matriculaPrimeiroComandante;
	}

	public void setMatriculaPrimeiroComandante(String matriculaPrimeiroComandante) {
		this.matriculaPrimeiroComandante = matriculaPrimeiroComandante;
	}

	public String getNomeSegundoComandante() {
		return nomeSegundoComandante;
	}

	public void setNomeSegundoComandante(String nomeSegundoComandante) {
		this.nomeSegundoComandante = nomeSegundoComandante;
	}

	public String getMatriculaSegundoComandante() {
		return matriculaSegundoComandante;
	}

	public void setMatriculaSegundoComandante(String matriculaSegundoComandante) {
		this.matriculaSegundoComandante = matriculaSegundoComandante;
	}

}
