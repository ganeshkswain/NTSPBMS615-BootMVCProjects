package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "BOOT_JS_INFO")
@Entity
public class JobSeekerInfo implements Serializable {
	@Id
	@GeneratedValue
	private Integer jsId;
	@Column(length = 20)
	private String jsName;
	@Column(length = 20)
	private String jsAddrs;
	@Column(length = 200)
	private String resumePath;
	@Column(length = 200)
	private String photoPath;

}
