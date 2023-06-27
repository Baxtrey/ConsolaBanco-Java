package banco.util;

import java.util.Random;

public class Utiles {

	public static final String[] NOMBRES = {
		    "Juan", "Juana", "Paola", "Luis", "Santiago", "María", "Pedro", "Ana", "Carlos", "Laura",
		    "Fernanda", "Andrés", "Valentina", "Diego", "Isabella", "Martín", "Camila", "Sebastián", "Daniela", "Javier"
		};

	public static final String[] APELLIDOS = {
		    "Cordero", "Reyes", "Torres", "Romero", "Campos",
		    "González", "Hernández", "García", "López", "Pérez",
		    "Silva", "Vargas", "Rojas", "Soto", "Morales",
		    "Fernández", "Martínez", "Ortega", "Mendoza", "Guerrero"
		};

		public static final String[] CORREOS = {
		    "Juan13", "Juana1256", "Paola", "LuisR", "Santiago98",
		    "gonzalez", "hernandez123", "garcia456", "lopez789", "perez10",
		    "silva22", "vargas33", "rojas44", "soto55", "morales66",
		    "fernandez77", "martinez88", "ortega99", "mendoza111", "guerrero222"
		};

	public static final String[] DOMINIOS = { "gmail.com","yahoo.es","hotmail.com","gmail.es","hotmail.es" };

	// obtener un nombre completo "Aleatorio" a partir de dos listas
	public static String nombreAleatorio(String[] nombres, String[] apellidos) {
		Random random = new Random();
		int indiceNombre = random.nextInt(nombres.length);
		String nombre = nombres[indiceNombre];

		int indiceApellido = random.nextInt(apellidos.length);
		String apellido = apellidos[indiceApellido];

		return nombre + " " + apellido;
	}

	public static String nombreAleatorio() {
		return nombreAleatorio(NOMBRES, APELLIDOS);
	}

	// retornar un email aleatorio
	// completa

	public static String correoAleatorio(String[] correos, String[] dominios) {
		Random random = new Random();
		int indiceCorreo = random.nextInt(correos.length);
		String correo = correos[indiceCorreo];

		int indiceDominio = random.nextInt(dominios.length);
		String dominio = dominios[indiceDominio];

		return correo + "@ " + dominio;
	}

	public static String correoAleatorio() {
		return correoAleatorio(CORREOS, DOMINIOS);
	}

}
