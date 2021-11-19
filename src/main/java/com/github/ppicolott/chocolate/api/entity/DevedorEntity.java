package com.github.ppicolott.chocolate.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "devedores", schema = "public")
public class DevedorEntity implements Serializable {

	private static final long serialVersionUID = -1689085860934267662L;

	@Id
	@Column(name = "uuid", nullable = false, unique = true, updatable = false, precision = 50)
	private String uuid;
	@Column(name = "name", nullable = false, unique = true, updatable = true, precision = 150)
	private String name;
	@Column(name = "qtd", nullable = true, unique = false, updatable = true)
	private Integer qtd;

	public DevedorEntity() {
		// Construct
	}

	public DevedorEntity(String uuid, String name, Integer qtd) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.qtd = qtd;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	@Override
	public String toString() {
		return "DevedorEntity [uuid=" + uuid + ", name=" + name + ", qtd=" + qtd + "]";
	}

}
