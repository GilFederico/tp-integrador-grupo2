package tpintegradorgp2;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
public class Main {

	public static void main(String[] args)  {
		List<archresultados> listaresul;
		List<archpronostico> listapronos;
		Partido[] part=new Partido[2];
		int i=0,h=0;
		ResultadoEnu rest = null;
		Ronda ronda;
		
		try {
			listaresul=new CsvToBeanBuilder(new FileReader(args[0]))
			.withType(archresultados.class)
			.build()
			.parse();
			listapronos=new CsvToBeanBuilder(new FileReader(args[1]))
			.withType(archpronostico.class)
			.build()
			.parse();
				for(archresultados lista:listaresul) {//leer una linea archivo con resultados
					for(archpronostico lista2:listapronos) {//leer una linea del archivo con los pronostico
						if(lista.gete1().equals(lista2.gete1() )) {// comparar que sea el mismo partido
					 Equipo eq1=new Equipo(lista.gete1(),"----");
					 Equipo eq2=new Equipo(lista.gete2(),"----");
					part[i]=new Partido(eq1,eq2,lista.getgole1(),lista.getgole2());
					switch(lista2.getgana()) { // g1=gana equipo 1, emp= empate, g2=gana equipo 2
						case "g1":{
							 rest=rest.GANADOR;
						}break;
						case "emp":{
							 rest=rest.EMPATE;
						}break;
						case "g2":{
							 rest=rest.PERDEDOR;
						}break;				
					}
					Pronostico prons=new Pronostico(part[i], eq1,rest);
					h=h+prons.puntos();
						}						
					}
				i++;					
				}	
			System.out.println("puntaje= "+h);
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}
}
