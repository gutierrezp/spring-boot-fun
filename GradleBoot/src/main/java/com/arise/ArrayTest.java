package com.arise;

import org.h2.engine.SysProperties;

public class ArrayTest {
	
	public static String[][] lista = {{"Pitufos", "7","8","9"}, {"Ewoks", "5", "6","7"},{"La Sirenita", "3","2","1"}};
	
	public static void main (String...args){
		
		mostrarTitulos();
		//String userSelection = "Pitufos";
		//String userSelection = "Ewoks";
		String userSelection = "Condemor";
		//String userSelection = "La Sirenita";
		//mostrarNotasPelicula(userSelection);
		//modificarPelicula(userSelection);
		//modificarPuntuacionPelicula(userSelection);
		//mostrarPuntuacionaMasAlta(userSelection);
		float numero = 10f;
		preguntaRara(numero);
	}

	private static void preguntaRara(float numero) {
		for(int fila = 0 ; fila<lista.length; fila++){
			// calcular media de fila
			float media = calcularMediaFila(fila);
			// si cumple, mostrar titulo
			if(numero<=media){
				System.out.println("Esta cuela: "+lista[fila][0]);
			}
		}
		
	}

	private static float calcularMediaFila(int fila) {
		float media = 0f;
		for(int col=1; col<lista[fila].length;col++){
			media += Float.parseFloat(lista[fila][col]);
		}
		media = media/3;
		return media;
	}

	private static void mostrarPuntuacionaMasAlta(String userSelection) {
		int filaPelicula = encontrarPelicula(userSelection);
		if(filaPelicula<0){
			System.out.println("La pelicula no se encuentra en la lista");
		}else{
			float max = Float.MIN_VALUE;
			for(int col=1; col<lista[filaPelicula].length;col++){
				float aux = Float.parseFloat(lista[filaPelicula][col]);
				if(max<aux){
					max = aux;
				}
			}
			System.out.println("El numero maximo es: "+max);
			
		}	
	}

	private static void modificarPuntuacionPelicula(String userSelection) {
		int filaPelicula = encontrarPelicula(userSelection);
		if(filaPelicula<0){
			System.out.println("La pelicula no se encuentra en la lista");
		}else{
			for(int i=1;i<lista[filaPelicula].length;i++){
				System.out.println("quieres cambiar esta puntuacion: "+lista[filaPelicula][i]);
				// si o no
				
				// si escoge si
				lista[filaPelicula][i]="35";
				break;
			}
			
		}	
		
	}

	private static void modificarPelicula(String userSelection) {
		int filaPelicula = encontrarPelicula(userSelection);
		if(filaPelicula<0){
			System.out.println("La pelicula no se encuentra en la lista");
		}else{
			String titulo = "Bracula";
			lista[filaPelicula][0] = titulo;
		}	
	}

	private static void mostrarNotasPelicula(String userSelection) {
		int filaPelicula = encontrarPelicula(userSelection);
		if(filaPelicula<0){
			System.out.println("La pelicula no se encuentra en la lista");
		}else{
			mostrarValoresPelicula(filaPelicula);
		}
	}

	private static void mostrarValoresPelicula(int filaPelicula) {
		for(int col=1; col<lista[filaPelicula].length;col++){
			System.out.println("nota numero "+col+": "+lista[filaPelicula][col]);
		}
	}

	private static int encontrarPelicula(String userSelection) {
		int resultado = -1;
		for(int fila=0; fila<lista.length;fila++){
			String aux = lista[fila][0];
			if(userSelection.equals(aux)){
				resultado = fila;
			}
		}
		return resultado;
	}

	private static void mostrarTitulos() {
		for(int fila=0; fila<lista.length;fila++){
			System.out.println("Titulo: "+ lista[fila][0]);
		}
		
	}
	
	

}
