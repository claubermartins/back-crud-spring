package com.clauber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("_id")
	@ApiModelProperty(value = "Codigo do curso")
	private Long id;
	
	@NotBlank
	@Size(max = 60)
	@Column(length = 200, nullable = false)
	@ApiModelProperty(value = "Nome do curso")
	private String name;
	
	@NotBlank
	@Size(max = 60)
	@Column(length = 200, nullable = false)
	@ApiModelProperty(value = "Categoria do curso")
	private String category;
	
	@NotBlank
	@Size(max = 255)
	@Column(length = 200, nullable = false)
	@Email
	@ApiModelProperty(value = "Email do curso")
	private String email;

}