package banco.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import banco.modelos.Cliente;
import banco.modelos.Gestor;
import banco.modelos.Mensaje;
import banco.modelos.Transferencia;
import banco.util.Utiles;

public class ConsolaBanco {

	// atributos de la clase consola
	private List<Gestor> gestores;
	private List<Cliente> clientes;
	private List<Mensaje> mensajes;
	private List<Transferencia> transferencias;

	// para garantizar el id es unico
	private Integer siguienteIdGestor;
	private Integer siguienteCliente;
	private Integer siguienteIdMensaje;
	private Integer siguienteIdTransferencia;
	private Scanner teclado;

	// inicializamos los atributos en el construtor
	ConsolaBanco() {
		this.gestores = new ArrayList<>();
		this.siguienteIdGestor = 1;
		new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.siguienteCliente = 1;
		new ArrayList<>();
		this.mensajes = new ArrayList<>();
		siguienteIdMensaje = 1;
		new ArrayList<>();
		this.transferencias = new ArrayList<>();
		siguienteIdTransferencia = 1;
		new ArrayList<>();

		this.teclado = new Scanner(System.in);
	}

	private void login() {
		System.out.print("Id gestor: ");
		int idGestor = teclado.nextInt();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		Gestor gestor = buscarGestorPorId(idGestor);
		if (gestor != null) {
			if (gestor.getPassword().equals(pass)) {
				System.out.println("Login correcto!");
			} else {
				System.out.println("Login incorrecto!");
			}
		} else {
			System.out.println("El usuario no existe...");
		}
	}

	private void mostrarMenu() {
		System.out.println("\n1. Insertar gestor");
		System.out.println("2. Insertar gestores de prueba");
		System.out.println("3. Consultar gestor");
		System.out.println("4. Ver todos los gestores");
		System.out.println("5. Actualizar gestor");
		System.out.println("6. Eliminar un gestor");
		System.out.println("7. Insertar cliente");
		System.out.println("8. Consultar cliente");
		System.out.println("9. Ver todos los clientes");
		System.out.println("10. Actualizar cliente");
		System.out.println("11. Eliminar un cliente");
		System.out.println("12. Obtener un mensaje");
		System.out.println("13. Ver todos los mensajes");
		System.out.println("14. Enviar un mensaje");
		System.out.println("15. Obtener una transferencia");
		System.out.println("16. Ver todos las transferencias");
		System.out.println("17. Enviar una transferencia");
		System.out.println("18. Iniciar sección como gestor");
		System.out.println("0. Salir\n");
	}

	private void insertarGestor() {
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		System.out.print("Oficina: ");
		String oficina = teclado.next();
		Gestor nuevoGestor = new Gestor(siguienteIdGestor, nombre, pass, email, oficina);
		gestores.add(nuevoGestor);
		siguienteIdGestor++;
		System.out.println("Gestor creado con éxito.");
	}

	private void insertarGestoresDePrueba() {
		System.out.print("Número de gestores: ");
		int numeroGestores = teclado.nextInt();
		for (int i = 0; i < numeroGestores; i++) {
			String usuario = Utiles.nombreAleatorio();
			String correo = Utiles.correoAleatorio();
			Gestor gestor = new Gestor(siguienteIdGestor, usuario, "", correo, "Valencia");
			gestores.add(gestor);
			siguienteIdGestor++;
		}
	}

	private void consultarGestor() {
		System.out.print("Id del gestor a consultar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		for (int i = 0; i < gestores.size(); i++) {
			Gestor gestor = gestores.get(i);
			if (gestor.getId() == idGestor) {
				gestorResultado = gestor;
				// como ya lo hemos encontrado, rompemos el bucle
				break;
			}
		}
		// si se ha encontrado
		if (gestorResultado != null) {
			System.out.println(gestorResultado);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
	}

	private Gestor buscarGestorPorId(int idGestor) {
		Gestor gestorResultado = null;
		for (int i = 0; i < gestores.size(); i++) {
			Gestor gestor = gestores.get(i);
			if (gestor.getId() == idGestor) {
				gestorResultado = gestor;
				// como ya lo hemos encontrado, rompemos el bucle
				return gestorResultado;
			}
		}

		return null;
	}

	private void mostrarGestores() {
		if (gestores.isEmpty()) {
			System.out.println("Todavía no hay gestores.");
		}
		gestores.forEach(gestor -> {
			System.out.println(gestor);
		});
	}

	private void actualizarGestor() {
		System.out.print("Id del gestor a actualizar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		// si se ha encontrado
		if (gestorResultado != null) {
			System.out.println(gestorResultado);
			System.out.println("[n] Nombre");
			System.out.println("[e] Email");
			System.out.println("[c] Contraseña");
			System.out.println("[o] Oficina");
			System.out.println("[x] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().charAt(0);
			switch (opcionActualizar) {
			case 'n':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				gestorResultado.setUsuario(nombre);
				break;
			case 'e':
				System.out.print("Email: ");
				String email = teclado.next();
				gestorResultado.setCorreo(email);
				break;
			case 'c':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				gestorResultado.setPassword(pass);
				break;
			case 'o':
				System.out.print("Oficina: ");
				String oficina = teclado.next();
				gestorResultado.setOficina(oficina);
				break;
			case 'x':
				System.out.print("Cancelando actualización...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
			if (opcionActualizar != 'x') {
				System.out.println("Se actualizó el gestor con el id " + idGestor);
			}
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
	}

	private void eliminarGestor() {
		System.out.print("Id del gestor a eliminar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = null;
		int posicionGestor = -1;
		for (int i = 0; i < gestores.size(); i++) {
			Gestor gestor = gestores.get(i);
			if (gestor.getId() == idGestor) {
				gestorResultado = gestor;
				posicionGestor = i;
				// como ya lo hemos encontrado, rompemos el bucle
				break;
			}
		}
		// si se ha encontrado
		if (gestorResultado != null) {
			gestores.remove(posicionGestor);
			System.out.println("Se eliminó el gestor con el id " + idGestor);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
	}

	private void insertarCliente() {
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		System.out.print("Saldo: ");
		Double saldo = teclado.nextDouble();
		System.out.print("Gestores: ");
		Integer idGestor = teclado.nextInt();
		Cliente nuevoCliente = new Cliente(siguienteCliente, nombre, pass, email, saldo, idGestor);
		clientes.add(nuevoCliente);
		siguienteCliente++;
		System.out.println("Cliente ha sido registrado con éxito.");
	}

	private void consultarCliente() {
		System.out.print("Id del cliente a consultar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getId() == idCliente) {
				clienteResultado = cliente;
				// como ya lo hemos encontrado, rompemos el bucle
				break;
			}
		}
		// si se ha encontrado
		if (clienteResultado != null) {
			System.out.println(clienteResultado);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idCliente);
		}
	}

	private Cliente buscarClientePorId(int idCliente) {
		Cliente clienteResultado = null;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getId() == idCliente) {
				clienteResultado = cliente;
				// como ya lo hemos encontrado, rompemos el bucle
				return clienteResultado;
			}
		}

		return null;
	}

	private void mostrarClientes() {
		if (clientes.isEmpty()) {
			System.out.println("Todavía no hay cliente.");
		}
		clientes.forEach(cliente -> {
			System.out.println(cliente);
		});
	}

	private void actualizarCliente() {
		System.out.print("Id del cliente a actualizar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		// si se ha encontrado
		if (clienteResultado != null) {
			System.out.println(clienteResultado);
			System.out.println("[n] Nombre");
			System.out.println("[e] Email");
			System.out.println("[c] Contraseña");
			System.out.println("[x] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().charAt(0);
			switch (opcionActualizar) {
			case 'n':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				clienteResultado.setUsuario(nombre);
				break;
			case 'e':
				System.out.print("Email: ");
				String email = teclado.next();
				clienteResultado.setCorreo(email);
				break;
			case 'c':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				clienteResultado.setPassword(pass);
				break;
			case 'x':
				System.out.print("Cancelando actualización...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
			if (opcionActualizar != 'x') {
				System.out.println("Se actualizó el cliente con el id " + idCliente);
			}
		} else {
			System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
		}
	}

	private void eliminarCliente() {
		System.out.print("Id del cliente a eliminar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = null;
		int posicionCliente = -1;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getId() == idCliente) {
				clienteResultado = cliente;
				posicionCliente = i;
				// como ya lo hemos encontrado, rompemos el bucle
				break;
			}
		}
		// si se ha encontrado
		if (clienteResultado != null) {
			clientes.remove(posicionCliente);
			System.out.println("Se eliminó el cliente con el id " + idCliente);
		} else {
			System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
		}
	}

	private void obtenerMensaje() {
		System.out.print("Id del mensaje a obtener: ");
		int idMensaje = teclado.nextInt();
		Mensaje mensajeResultado = buscarMensajePorId(idMensaje);
		if (mensajeResultado != null) {
			System.out.println(mensajeResultado);
		} else {
			System.out.println("No se pudo encontrar un mensaje con el id " + idMensaje);
		}
	}

	private Mensaje buscarMensajePorId(int idMensaje) {
		for (Mensaje mensaje : mensajes) {
			if (mensaje.getId() == idMensaje) {
				return mensaje;
			}
		}
		return null;
	}

	private void obtenerTodosLosMensajes() {
		if (mensajes.isEmpty()) {
			System.out.println("No hay mensajes disponibles.");
		} else {
			for (Mensaje mensaje : mensajes) {
				System.out.println(mensaje);
			}
		}
	}

	private void enviarMensaje() {
		System.out.print("Id del origen: ");
		int idOrigen = teclado.nextInt();
		System.out.print("Id del destino: ");
		int idDestino = teclado.nextInt();
		teclado.nextLine(); // Limpiar el búfer de entrada
		System.out.print("Texto del mensaje: ");
		String texto = teclado.nextLine();

		Mensaje nuevoMensaje = new Mensaje(siguienteIdMensaje, idOrigen, idDestino, texto);
		mensajes.add(nuevoMensaje);
		siguienteIdMensaje++;

		System.out.println("Mensaje enviado con éxito.");
	}

	private void obtenerTransferencia() {
		System.out.print("Id de la transferencia a obtener: ");
		int idTransferencia = teclado.nextInt();
		Transferencia transferenciaResultado = buscarTransferenciaPorId(idTransferencia);
		if (transferenciaResultado != null) {
			System.out.println(transferenciaResultado);
		} else {
			System.out.println("No se pudo encontrar una transferencia con el id " + idTransferencia);
		}
	}

	private Transferencia buscarTransferenciaPorId(int idTransferencia) {
		for (Transferencia transferencia : transferencias) {
			if (transferencia.getId() == idTransferencia) {
				return transferencia;
			}
		}
		return null;
	}

	private void obtenerTodasLasTransferencias() {
		if (transferencias.isEmpty()) {
			System.out.println("No hay transferencias disponibles.");
		} else {
			for (Transferencia transferencia : transferencias) {
				System.out.println(transferencia);
			}
		}
	}

	private void realizarTransferencia() {
		System.out.print("Id del ordenante: ");
		int idOrdenante = teclado.nextInt();
		System.out.print("Id del beneficiario: ");
		int idBeneficiario = teclado.nextInt();
		System.out.print("Importe: ");
		double importe = teclado.nextDouble();
		teclado.nextLine();
		System.out.print("Concepto: ");
		String concepto = teclado.nextLine();

		Transferencia nuevaTransferencia = new Transferencia(siguienteIdTransferencia, idOrdenante, idBeneficiario,
                importe, concepto, new Date());

		transferencias.add(nuevaTransferencia);
		siguienteIdTransferencia++;

		System.out.println("Transferencia realizada con éxito.");
	}

	private void cerrar() {
		teclado.close();
		System.out.println("¡Hasta pronto!");
	}

	private void iniciar() {

		int opcion = -1;

		do {
			mostrarMenu();

			System.out.print("Selecciona una opción: ");

			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				insertarGestor();
				break;
			case 2:
				insertarGestoresDePrueba();
				break;
			case 3:
				consultarGestor();
				break;
			case 4:
				mostrarGestores();
				break;
			case 5:
				actualizarGestor();
				break;
			case 6:
				eliminarGestor();
				break;
			case 7:
				insertarCliente();
				break;
			case 8:
				consultarCliente();
				break;
			case 9:
				mostrarClientes();
				break;
			case 10:
				actualizarCliente();
				break;
			case 11:
				eliminarCliente();
				break;
			case 12:
				obtenerMensaje();
				break;
			case 13:
				obtenerTodosLosMensajes();
				break;
			case 14:
				enviarMensaje();
				break;
			case 15:
				obtenerTransferencia();
				break;
			case 16:
				obtenerTodasLasTransferencias();
				break;
			case 17:
				realizarTransferencia();
				break;
			case 18:
				login();
				break;
			case 0:
				cerrar();
				break;
			default:
				System.out.println("Opción desconocida...");
			}
		} while (opcion != 0);
	}

	public static void main(String[] args) {

		ConsolaBanco consola = new ConsolaBanco();

		consola.iniciar();
	}
}