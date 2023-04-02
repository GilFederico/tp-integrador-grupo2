package tpintegradorgp2;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

public class Partido {

	private Equipo equipo1;
	private Equipo equipo2;
	private int golE1;
	private int golE2;
	
	public Partido(Equipo e1, Equipo e2, int ge1, int ge2) {
		this.equipo1=e1;
		this.equipo2=e2;
		this.golE1=ge1;
		this.golE2=ge2;
	}
	public ResultadoEnu resultado(Equipo equ) {
		ResultadoEnu x=null;
		Equipo j=new Equipo(null,null);
		int i=0;
		if(golE1>golE2) {
			j=equipo1;
		}else if(golE2>golE1) {
			j=equipo2;
		}
		if(j.equals(equ)) {
			x=ResultadoEnu.GANADOR;
		}else if(j.equals(equ)== false) {
			x=ResultadoEnu.PERDEDOR;
		}
		if(golE1==golE2){
			x=ResultadoEnu.EMPATE;
		}
		return x;		
	}
}
