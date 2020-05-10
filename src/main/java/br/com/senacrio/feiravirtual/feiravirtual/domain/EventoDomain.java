package br.com.senacrio.feiravirtual.feiravirtual.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "evento")
public class EventoDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7037916308692461564L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evento_id")
    private Integer id;

    @Column(name = "evento_titulo")
    private String eventoTitulo;
    
    @OneToOne
    @JoinColumn(name = "evento_tipo_id")
    private EventoTipoDomain eventoTipo;
    
    @Column(name = "evento_link")
    private String eventoLink;

    @Column(name = "evento_link_banner")
    private String eventoLinkBanner;

    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
    @Column(name = "evento_data_inicio")
    private Date eventoDataInicio;
    
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
    @Column(name = "evento_data_fim")
    private Date eventoDataFim;
    
    @Column(name = "evento_vagas")
    private int eventoVagas;
    
    @Column(name = "evento_status")
    private Integer eventoStatus;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventoTitulo() {
		return eventoTitulo;
	}

	public void setEventoTitulo(String eventoTitulo) {
		this.eventoTitulo = eventoTitulo;
	}

	public EventoTipoDomain getEventoTipo() {
		return eventoTipo;
	}

	public void setEventoTipo(EventoTipoDomain eventoTipo) {
		this.eventoTipo = eventoTipo;
	}

	public String getEventoLink() {
		return eventoLink;
	}

	public void setEventoLink(String eventoLink) {
		this.eventoLink = eventoLink;
	}

	public Date getEventoDataInicio() {
		return eventoDataInicio;
	}
	
	public void setEventoDataInicio(Date eventoDataInicio) {
		this.eventoDataInicio = eventoDataInicio;
	}
	
	public Date getEventoDataFim() {
		return eventoDataFim;
	}

	public void setEventoDataFim(Date eventoDataFim) {
		this.eventoDataFim = eventoDataFim;
	}

	public String getEventoLinkBanner() {
		return eventoLinkBanner;
	}

	public void setEventoLinkBanner(String eventoLinkBanner) {
		this.eventoLinkBanner = eventoLinkBanner;
	}

	public int getEventoVagas() {
		return eventoVagas;
	}

	public void setEventoVagas(int eventoVagas) {
		this.eventoVagas = eventoVagas;
	}

	public Integer getEventoStatus() {
		return eventoStatus;
	}

	public void setEventoStatus(Integer eventoStatus) {
		this.eventoStatus = eventoStatus;
	}

	@Override
    public String toString() {
        return "EventoDomain{" +
                "id=" + id +
                ", eventoTitulo='" + eventoTitulo + '\'' +
                '}';
    }
}
