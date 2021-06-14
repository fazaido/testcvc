package com.cvc.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "transfer")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ACCOUNT_FROM")
	private Integer accountNumberFrom;

	@Column(name = "ACCOUNT_TO")
	private Integer accountNumberTo;

	@Column(name = "VALUE", precision = 10, scale = 2)
	private Double value;

	@Column(name = "RATE", precision = 2, scale = 2)
	private Double rate;

	@Column(name = "DATE_TRANSFER", columnDefinition = "DATE")
	private LocalDate transferDate;

	@Column(name = "DATE_SCHEDULING", columnDefinition = "DATE")
	private LocalDate schedulingDate;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAccountNumberFrom() {
		return accountNumberFrom;
	}

	public void setAccountNumberFrom(Integer accountNumberFrom) {
		this.accountNumberFrom = accountNumberFrom;
	}

	public Integer getAccountNumberTo() {
		return accountNumberTo;
	}

	public void setAccountNumberTo(Integer accountNumberTo) {
		this.accountNumberTo = accountNumberTo;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public LocalDate getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
	}

	public LocalDate getSchedulingDate() {
		return schedulingDate;
	}

	public void setSchedulingDate(LocalDate schedulingDate) {
		this.schedulingDate = schedulingDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
