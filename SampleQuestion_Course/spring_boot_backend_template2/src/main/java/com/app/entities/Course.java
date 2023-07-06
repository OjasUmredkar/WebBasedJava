package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course extends BaseEntity {

	@Column(name = "name",  unique = true,length = 30)
	private String name;
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private Category category;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	@Column
	private double fee;
	@Column(name = "update_date_time")
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
}
