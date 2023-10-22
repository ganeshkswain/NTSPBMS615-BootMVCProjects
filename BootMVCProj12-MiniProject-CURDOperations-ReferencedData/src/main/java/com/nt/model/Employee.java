package com.nt.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

	@Entity
	@SQLDelete(sql = "UPDATE EMP SET STATUS='inactive' WHERE EMPNO=?")
	@Where(clause = "STATUS <> 'inactive'")
	@Data
	@Table(name = "EMP")
	public class Employee implements Serializable {
		@Id
		@SequenceGenerator(name = "gen1",sequenceName = "emp_id_seq",initialValue = 101,allocationSize = 1)
		@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
		private Integer empno;
		@Column(length=20)
		private String ename;
		@Column(length = 20)
		private String job;
		private Double sal;
		@Transient
		private String vflag="no";
		private String country="India";
		private String state;

}
