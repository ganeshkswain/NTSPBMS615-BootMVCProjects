package com.nt.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "emp")
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	private Integer empno;
	private String ename;
	private String job;
	private Long deptno;
	private Double sal;

}
