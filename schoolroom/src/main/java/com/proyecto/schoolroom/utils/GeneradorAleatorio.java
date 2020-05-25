package com.proyecto.schoolroom.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.schoolroom.repository.GradoRepository;
import com.proyecto.schoolroom.security.model.User;
import com.proyecto.schoolroom.security.repository.UserRepository;

public class GeneradorAleatorio {	
	@Autowired
	GradoRepository repo;
	
	@Autowired
	UserRepository repoU;
	
	public String Aleatorio() {
		
		String cadena= "";
		String comparacion="";
		String nuevo="";
		
	try {
		
		int cntr = 1;
		while(cntr > 0) {		
			
			int cntr2 = cntr;
			
			String[] codigos = new String[cntr2];
			
			String[] abcd = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
					"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
			
			String[] digitos = {"0","1","2","3","4","5","6","7","8","9"};
			
			for (int i = 0; i < cntr2; i++) {
				codigos[i] = abcd[(int) (Math.floor(Math.random() * ((abcd.length - 1) - 0 + 1) + 0))] + 
						digitos[(int) (Math.floor(Math.random() * ((digitos.length - 1) - 0 + 1) + 0))] + 
						abcd[(int) (Math.floor(Math.random() * ((abcd.length - 1) - 0 + 1) + 0))] + 
						abcd[(int) (Math.floor(Math.random() * ((abcd.length - 1) - 0 + 1) + 0))] + 
						digitos[(int) (Math.floor(Math.random() * ((digitos.length - 1) - 0 + 1) + 0))] +
						abcd[(int) (Math.floor(Math.random() * ((abcd.length - 1) - 0 + 1) + 0))] + 
						digitos[(int) (Math.floor(Math.random() * ((digitos.length - 1) - 0 + 1) + 0))] ;
				nuevo=codigos[i];
			}
				
			for (String item : codigos) {
				
				comparacion = repo.findByCodigo(item).getCodigo();
				if (comparacion == item) {
					cntr++;
				}
				else {
					cadena = item;					
					cntr = 0;
				}				
			}
		}
		
		} catch (Exception e) {
			return nuevo;
		}
	return cadena;
		
	}
	
	public String Correo(String nombres, String apellidos, String fecha) {
		String correo = "";
		correo = String.valueOf(nombres.charAt(0)) + String.valueOf(apellidos.charAt(0));
		try {
			int cntr = 0;
			while(cntr == 0) {
				String[] digitos = {"0","1","2","3","4","5","6","7","8","9"};
				for (int i = 0; i < 1; i++) {
					correo +=
							digitos[(int) (Math.floor(Math.random() * ((digitos.length - 1) - 0 + 1) + 0))] + 
							digitos[(int) (Math.floor(Math.random() * ((digitos.length - 1) - 0 + 1) + 0))] +
							digitos[(int) (Math.floor(Math.random() * ((digitos.length - 1) - 0 + 1) + 0))] +
							digitos[(int) (Math.floor(Math.random() * ((digitos.length - 1) - 0 + 1) + 0))] + 
							fecha.substring(5, 7) + fecha.substring(0, 4);
				}
				correo += "@cecac.edu.sv";
				List<User> listado = repoU.findAll();
				for (User user : listado) {
					if (user.getUsername() == correo) {
						cntr = 0;
					}			
					else {
						cntr = 1;
					}
				}
			}	
			return correo;
			
		} catch (Exception e) {
			return correo;
		}
	}

}