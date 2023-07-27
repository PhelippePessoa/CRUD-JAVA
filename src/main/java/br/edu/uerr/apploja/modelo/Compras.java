package br.edu.uerr.apploja.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compras")
public class Compras implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	@Column(name="fornecedor_id")
	private Integer fornecedorId;
	@Column(name="produtos_id")
	private Integer produtosId;
	private Integer quantidade;
	@Column(name="valor_unitario")
	private Double valorunitario;
	@Column(name="forma_pagamento")
	private Integer formaPagamento;
	@Column(name="data_compra")
	private Calendar dataCompra;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFornecedorId() {
		return fornecedorId;
	}
	public void setFornecedorId(Integer fornecedorId) {
		this.fornecedorId = fornecedorId;
	}
	public Integer getProdutosId() {
		return produtosId;
	}
	public void setProdutosId(Integer produtosId) {
		this.produtosId = produtosId;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValorunitario() {
		return valorunitario;
	}
	public void setValorunitario(Double valorunitario) {
		this.valorunitario = valorunitario;
	}
	public Integer getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(Integer formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Calendar getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	
	
}
