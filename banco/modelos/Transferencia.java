package banco.modelos;

import java.util.Date;

public class Transferencia {
	private Integer id;
	private Integer idOrdenante;
	private Integer idBeneficiario;
	private Double importe;
	private String concepto;
	private Date fecha;


	public Transferencia() {
			}
	public Transferencia (Integer id, Integer idOrdenante, Integer idBeneficiario, Double importe, String concepto, Date fecha ) {
		
		this.id = id;
		this.idOrdenante = idOrdenante;
		this.idBeneficiario =idBeneficiario;
		this.importe = importe;
		this.concepto = concepto;
		this.fecha = fecha;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdOrdenante() {
		return idOrdenante;
	}
	public void setIdOrdenante(Integer idOrdenante) {
		this.idOrdenante = idOrdenante;
	}
	public Integer getIdBeneficiario() {
		return idBeneficiario;
	}
	public void setIdBeneficiario(Integer idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String toString() {
		return "Transferencia{id: " + this.id + ", idOrdenante: " + this.idOrdenante + ", idBeneficiario: " + this.idBeneficiario + "}";
	}

	public boolean equals(Object o) {
		Transferencia  t = (Transferencia) o;
		return this.id == t.id;
	}
	
}
