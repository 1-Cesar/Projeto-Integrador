package com.generation.IntegraJa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**@author Cesar
 * @version v2
 * @since 26/01/2022 
 * */

@Entity
@Table (name = "tb_publico")
public class Publico {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idPublico;
	
	@NotNull
	private Boolean lgbtqiapPublico;
	
	@NotNull
	private Boolean mulheresPublico;
	
	@NotNull
	private Boolean pcdsPublico;
	
	@NotNull
	private Boolean indigenasPublico;

	public long getIdPublico() {
		return idPublico;
	}

	public void setIdPublico(long idPublico) {
		this.idPublico = idPublico;
	}

	public Boolean getLgbtqiapPublico() {
		return lgbtqiapPublico;
	}

	public void setLgbtqiapPublico(Boolean lgbtqiapPublico) {
		this.lgbtqiapPublico = lgbtqiapPublico;
	}

	public Boolean getMulheresPublico() {
		return mulheresPublico;
	}

	public void setMulheresPublico(Boolean mulheresPublico) {
		this.mulheresPublico = mulheresPublico;
	}

	public Boolean getPcdsPublico() {
		return pcdsPublico;
	}

	public void setPcdsPublico(Boolean pcdsPublico) {
		this.pcdsPublico = pcdsPublico;
	}

	public Boolean getIndigenasPublico() {
		return indigenasPublico;
	}

	public void setIndigenasPublico(Boolean indigenasPublico) {
		this.indigenasPublico = indigenasPublico;
	}
}
