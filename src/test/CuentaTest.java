package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sesion3_TDD.Cuenta;

class CuentaTest {
	
	
	Cuenta cuenta;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cuenta = new Cuenta("0","0");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void ingreso() {
		cuenta.ingresar(500);
		assertEquals(500, cuenta.getSaldo());
	}

	@Test
	void reintegro() {
		cuenta.reintegrar(500);
		assertEquals(-500, cuenta.getSaldo());
	}
	
	@Test
	void test0014() {
		// 1. Inicialización
		Cuenta cuenta12345 = new Cuenta("12345", "Titular 1", 50); // Saldo inicial 50€
		Cuenta cuenta67890 = new Cuenta("67890", "Titular 2", 0);  // Saldo inicial 0€

		// 2. Instrucciones paso a paso
		cuenta12345.reintegrar(200); // Paso 1: Saldo 50 - 200 = -150€
		cuenta67890.reintegrar(350); // Paso 2: Saldo 0 - 350 = -350€
		cuenta12345.ingresar(100);   // Paso 3: Saldo -150 + 100 = -50€
		cuenta67890.reintegrar(200); // Paso 4: Fallo (-350 - 200 = -550 < -500€). Permanece en -350€
		cuenta67890.reintegrar(150); // Paso 5: Saldo -350 - 150 = -500€
		cuenta12345.reintegrar(200); // Paso 6: Saldo -50 - 200 = -250€
		cuenta67890.ingresar(50);    // Paso 7: Saldo -500 + 50 = -450€
		cuenta67890.reintegrar(100); // Paso 8: Fallo (-450 - 100 = -550 < -500€). Permanece en -450€

		// 3. Verificación de resultados esperados
		assertEquals(-250, cuenta12345.getSaldo(), "El saldo final de la cuenta 12345 debe ser -250€");
		assertEquals(-450, cuenta67890.getSaldo(), "El saldo final de la cuenta 67890 debe ser -450€");
	}

}
