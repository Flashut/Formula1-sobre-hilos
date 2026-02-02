package ejercicioCarreras;

public class Coche{
	
	private String nombre;
	private Integer velocidadPorSegundo;
	private Integer kmRecorridos;
	private Carrera carrera;
	
	public Coche(String nombre, Integer velocidadPorSegundo, Carrera carrera) {
		super();
		this.nombre = nombre;
		this.velocidadPorSegundo = velocidadPorSegundo;
		this.carrera = carrera;
		kmRecorridos = 0;
	}
	
	public void correrCarrera() {
		do {
			pausar();
			avanzar();
			System.out.println(nombre + " >> va por el km " + kmRecorridos);
		}
		while (kmRecorridos < carrera.getKmTotales());
		System.out.println("Fin de carrera !!");
		carrera.subirAlPodio(nombre);		
	}
	
	public void avanzar() {
		kmRecorridos = kmRecorridos + velocidadPorSegundo;
		if (kmRecorridos > carrera.getKmTotales()) {
			kmRecorridos = carrera.getKmTotales();
		}
	}
	
	public void pausar() {
		// TODO: IMPLEMENTAR POR EL ALUMNO. DEBE ESPERAR UN TIEMPO ALEATORIO ENTRE 1 Y 3 SEGUNDOS
	}

	
	
	
}
