
package br.com.fesa.projetos.analisadorsintatico;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class AnalisadorTest {
    
    private Analisador analisador;
    
    
    public AnalisadorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        analisador = new Analisador();
    }
    
    @AfterEach
    public void tearDown() {
    }


    @ParameterizedTest
    @ValueSource(strings = {"daada", "caadacaf", "f", "daba", "cababaf", "daadaadaada", "dabaacacaf", "da"})
    public void testRealizaAnaliseTrue(String input) {
        assertTrue(analisador.realizaAnalise(input));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"marcelly", "benevides", "fff", "dad", "caca", "daadaadaadaf", "dabacacaf", "daf"})
    public void testRealizaAnaliseFalse(String input) {
        assertFalse(analisador.realizaAnalise(input));
    }
}
