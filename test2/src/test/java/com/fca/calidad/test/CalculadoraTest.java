package com.fca.calidad.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

	private Calculadora cal;
	
	@Before
	public void Inicializar() {
		cal = new Calculadora();
	}
	
	@Test
	public void sumaTest() {
		float resultadoEjecucion = cal.suma(2, 2);
		float resultadoEsperado = 4.0f;
		
		//Verificacion
		assertEquals(resultadoEjecucion,resultadoEsperado,0.01);
	}
	@Test
	public void restaTest() {
		float resultadoEjecucion = cal.resta(5, 3);
		float resultadoEsperado = 2.0f;
		
		assertEquals(resultadoEjecucion,resultadoEsperado,0.01);
	
	}
	@Test
	public void multiplicaTest() {
		float resultadoEjecucion = cal.multiplica(2, 3);
		float resultadoEsperado  = 6.0f;
		
		assertEquals(resultadoEjecucion,resultadoEsperado,0.01);
	}
	@Test
	public void divisionTest() {
		float resultadoEjecucion= cal.divide(4, 2);
		float resultadoDivision = 2.0f;
		
		assertEquals(resultadoEjecucion,resultadoDivision,0.01);
	}
}
