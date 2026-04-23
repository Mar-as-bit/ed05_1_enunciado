package org.ed05_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GestorJuegosTest {
    //Instancia al main, asi no tengo q llamrlo en cada Camino
    private GestorJuegos gestor;

    // Camino 1: Todo correcto, stock suficiente
    @Test
    public void Camino1_CodigoNoigualaUnidades(){
        GestorJuegos gestor = new GestorJuegos();
        //assertEquals para hacer las pruebas test
        assertEquals(-1, gestor.registrarLoteJuegos(new String[]{"A"} ,new int[]{2, 3})); //Esperamos el -1 como resultado
        //Por eso llamo al gestor que hice antes, llamo al metodo, para luego para hacer la prueba y me de ese reultado necesito
        // un NEW STRING y un INT con sus valores

    }

    @Test
    public void Camino2_Codigosigual0(){
        GestorJuegos gestior = new GestorJuegos();
        assertEquals(-1, gestor.registrarLoteJuegos(new String[]{},new int[]{0}));

    }

    @Test
    public void Camino3_SeRepiteIPorMenor() {
        GestorJuegos gestor = new GestorJuegos();
        assertEquals(-2, gestor.registrarLoteJuegos(new String[]{}, new int[]{-1}));
    }

    @Test
    public void Camino4_CantidadNegativaPrimera() {
        GestorJuegos gestor = new GestorJuegos();
        assertEquals(-2, gestor.registrarLoteJuegos(new String[]{"ABC123"}, new int[]{5}));
    }

    // Camino 5: Cantidad negativa en posición intermedia
    @Test
    public void Camino5_CantidadNegativaIntermedia() {
        GestorJuegos gestor = new GestorJuegos();
        assertEquals(-2, gestor.registrarLoteJuegos(new String[]{"ABC123", "DEF456", "GHI789"}, new int[]{5, -3, 2}));
    }

    // Camino 6: Excede stock máximo (error -3)
    @Test
    public void Camino6_ExcedeStockMaximo() {
        GestorJuegos gestor = new GestorJuegos();
        // Primero registramos 150 unidades
        gestor.registrarLoteJuegos(new String[]{"AAA111"}, new int[]{150});
        // Intentamos registrar 100 más (total 250 > 200)
        assertEquals(-3, gestor.registrarLoteJuegos(new String[]{"BBB222"}, new int[]{100}));
    }

    // Camino 7: Todos los códigos son nuevos
    @Test
    public void Camino7_TodosCodigosNuevos() {
        GestorJuegos gestor = new GestorJuegos();
        assertEquals(30, gestor.registrarLoteJuegos(new String[]{"NUEVO1", "NUEVO2"}, new int[]{10, 20}));
    }

    // Camino 8: Mezcla de códigos existentes y nuevos
    @Test
    public void Camino8_MezclaExistentesYNuevos() {
        GestorJuegos gestor = new GestorJuegos();
        // Primero registramos un código que ya existirá
        gestor.registrarLoteJuegos(new String[]{"EXISTE"}, new int[]{5});
        // Ahora registramos mezcla: uno existente y uno nuevo
        assertEquals(10, gestor.registrarLoteJuegos(new String[]{"EXISTE", "NUEVO"}, new int[]{3, 7}));
    }
}
