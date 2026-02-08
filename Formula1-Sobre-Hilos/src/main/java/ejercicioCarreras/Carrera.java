package ejercicioCarreras;

public class Carrera {

	private Integer kmTotales;
	private String[] podio;
	private Integer personasEnPodio;

	public Carrera(Integer kmTotales) {
		this.kmTotales = kmTotales;
		podio = new String[3];
		personasEnPodio = 0;
	}

	public Integer getKmTotales() {
		return kmTotales;
	}

	public void setKmTotales(Integer kmTotales) {
		this.kmTotales = kmTotales;
	}

//	public void subirAlPodio(String nombreCoche) {
//		podio[personasEnPodio] = nombreCoche;
//		personasEnPodio++;
//	}

	public synchronized void subirAlPodio(String nombreCoche) {
		if (personasEnPodio < podio.length) {
			podio[personasEnPodio] = nombreCoche;
			personasEnPodio++;
			notifyAll();
		}
	}

//	public void imprimirPodio() {
//		System.out.println("Podio de la carrera: ");
//		for (int i = 0; i < podio.length; i++) {
//			System.out.println("\tLugar " + (i+1) + " >> " + podio[i]);
//		}
//	}

//	*TODO:
//
//	Método que
//	imprime el
//	podio cuando
//	la carrera*
//	termina y
//	todos los
//	corredores ya
//	tienen su puesto*
//	en el
//	podio o clasificación**/

	public synchronized void imprimirPodio() {

		try {
			if (personasEnPodio != podio.length) {
				wait();
			}

			else if (personasEnPodio == podio.length) {
				notify();
				System.out.println("Podio de la carrera: ");
				for (int i = 0; i < podio.length; i++) {
					System.out.println("\tLugar " + (i + 1) + " >> " + podio[i]);
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
