package com.todouno.hulkstore.domain.modelo;



import javax.persistence.Entity;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;





@Entity
public class Producto {
	

	@Id
    @GeneratedValue
    private Long id;

    @Column(length = 200)
    @NotNull
    @Size(min = 1, max = 200)
    private String nombre;

    @Column(length = 10000)
    @Size(min = 1, max = 10000)
    private String descripcion;

    @Column(name = "uniCosto")
    @Min(1)
    private Float uniCosto;

    @Column(length = 50)
    @NotNull
    @Size(min = 1, max = 50)
    private String codigo;


    @Column(name = "catidad")
    private Integer catidad;

    @Column(name = "imageURL")
    @Size(min = 1, max = 100)
    private String imageURL;
    
    
    
        public Producto(String codigo, String nombre, Float uniCosto, Integer catidad,  Date datoProduccion, String imageURL, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.uniCosto = uniCosto;
        this.catidad = catidad;
        this.imageURL = imageURL;
        this.descripcion = descripcion;
    }
    
    public Producto () {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getUniCosto() {
		return uniCosto;
	}

	public void setUniCosto(Float uniCosto) {
		this.uniCosto = uniCosto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Integer getCatidad() {
		return catidad;
	}

	public void setCatidad(Integer catidad) {
		this.catidad = catidad;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	
	
	@Override
    public String toString() {
        return "Producto{" +
            "id=" + id +
            ", title='" + nombre + '\'' +
            ", description='" + descripcion + '\'' +
            ", unitCost=" + uniCosto +
            ", isbn='" + codigo + '\'' +
            '}';
    }
	

}