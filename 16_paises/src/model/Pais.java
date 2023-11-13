package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pais {
	
	@SerializedName(value="name")
	private String nombre;
	
	private String capital;
	@SerializedName(value="region")
	
	private String continente;
	
	@SerializedName(value="population")
	private long poblacion;
	
}
