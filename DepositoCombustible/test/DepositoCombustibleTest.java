import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DepositoCombustibleTest {

	@Test
	void testGetDepositoNivel() {
		DepositoCombustible dep = new DepositoCombustible(40,20);
		assertEquals(20, dep.getDepositoNivel());
	}

	@Test
	void testGetDepositoMax() {
		DepositoCombustible dep = new DepositoCombustible(40,20);
		assertEquals(40, dep.getDepositoMax());
	}

	@Test
	void testEstaVacio() {
		DepositoCombustible dep = new DepositoCombustible(40,20);
		assertFalse(dep.estaVacio());
		dep = new DepositoCombustible(0,0);
		assertTrue(dep.estaVacio());
	}

	@Test
	void testEstaLleno() {
		DepositoCombustible dep = new DepositoCombustible(40,20);
		assertFalse(dep.estaLleno());
		dep = new DepositoCombustible(40,40);
		assertTrue(dep.estaLleno());
	}

	@Test
	void testFill() {
		double depNivel_inicial = 20;
		DepositoCombustible dep = new DepositoCombustible(40,depNivel_inicial);
		dep.fill(10);
		assertTrue(dep.getDepositoNivel() > depNivel_inicial);
		assertEquals(30.0, dep.getDepositoNivel());
		
		dep.fill(10);
		assertTrue(dep.getDepositoNivel() > depNivel_inicial);
		assertEquals(40.0, dep.getDepositoNivel());
		assertTrue(dep.estaLleno());
		
		dep = new DepositoCombustible(40, depNivel_inicial);
		dep.fill(-10);
		assertTrue(dep.getDepositoNivel() > depNivel_inicial);
		
		dep = new DepositoCombustible(40,depNivel_inicial);
		dep.fill(0);
		assertTrue(dep.getDepositoNivel() > depNivel_inicial);
		
		dep = new DepositoCombustible(40,depNivel_inicial);
		dep.fill(30);
		assertTrue(dep.getDepositoNivel() > depNivel_inicial);
		assertEquals(40.0, dep.getDepositoNivel());
		assertTrue(dep.estaLleno());
		
	}

	@Test
	void testConsumir() {
		DepositoCombustible dep = new DepositoCombustible(40, 40);
		dep.consumir(30);
		assertEquals(10, dep.getDepositoNivel());
		dep.consumir(30);
		assertEquals(0, dep.getDepositoNivel());
		dep.consumir(-10);
		assertEquals(40, dep.getDepositoNivel());
	}

}
