package tpintegradorgp2;

//import trabajo.Equipo;
//import trabajo.Partido;
//import trabajo.resultadoEnu;

public class Pronostico {
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnu resul;

	
	public Pronostico(Partido p, Equipo e, ResultadoEnu r) {
		this.equipo=e;
		this.partido=p;
		this.resul=r;
	}
	
	public int puntos() {
		int x=0;
		ResultadoEnu re=partido.resultado(equipo);
		if(resul.equals(re)) {
			x++;
		}
		return x;
	}
}
