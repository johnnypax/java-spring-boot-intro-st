package com.st.introduzione.models;


public class LibroDTO {
	private String tit;
	private Float pre;
	private String isb;
	private Integer ann;
	private AutoreDTO aut;
	
	public String getTit() {
		return tit;
	}
	public void setTit(String tit) {
		this.tit = tit;
	}
	public Float getPre() {
		return pre;
	}
	public void setPre(Float pre) {
		this.pre = pre;
	}
	public String getIsb() {
		return isb;
	}
	public void setIsb(String isb) {
		this.isb = isb;
	}
	public Integer getAnn() {
		return ann;
	}
	public void setAnn(Integer ann) {
		this.ann = ann;
	}
	public AutoreDTO getAut() {
		return aut;
	}
	public void setAut(AutoreDTO aut) {
		this.aut = aut;
	}
	
	
}
