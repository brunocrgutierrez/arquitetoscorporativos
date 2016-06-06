package br.gov.serpro.sri.dominio.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Telefone extends Contato {
	
	private String numero;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
