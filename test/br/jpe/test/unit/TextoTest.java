/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.test.unit;

import br.jpe.dallahits.util.Texto;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Casos de teste para a classe Texto
 *
 * @author Joaov
 */
public class TextoTest {
    
    @Test
    public void capitalize(){
        assertEquals("Texto", Texto.capitalize("texto"));
        assertEquals("Texto", Texto.capitalize("Texto"));
        assertEquals("12313", Texto.capitalize("12313"));
        assertEquals("1asd2313", Texto.capitalize("1asd2313"));
        assertEquals("1234a", Texto.uncaptalize("1234a"));
        assertEquals("324C", Texto.uncaptalize("324C"));
    }
    
    @Test
    public void uncapitalize(){
        assertEquals("texto", Texto.uncaptalize("Texto"));
        assertEquals("texto", Texto.uncaptalize("texto"));
        assertEquals("12313", Texto.uncaptalize("12313"));
        assertEquals("1asd2313", Texto.uncaptalize("1asd2313"));
        assertEquals("1234a", Texto.uncaptalize("1234a"));
        assertEquals("324C", Texto.uncaptalize("324C"));
    }
    
    @Test
    public void toCamelCase(){
        assertEquals("Texto", Texto.toCamelCase("Texto", true));
        assertEquals("Texto", Texto.toCamelCase("texto", true));
        assertEquals("TextoComposto", Texto.toCamelCase("texto_composto", true));
        assertEquals("ABC", Texto.toCamelCase("a_b_c", true));
        assertEquals("1aBC", Texto.toCamelCase("1a_b_c", true));
        assertEquals("1ABC", Texto.toCamelCase("1_a_b_c", true));
        
        assertEquals("texto", Texto.toCamelCase("texto", false));
        assertEquals("Texto", Texto.toCamelCase("Texto", false));
        assertEquals("textoComposto", Texto.toCamelCase("texto_composto", false));
        assertEquals("aBC", Texto.toCamelCase("a_b_c", false));
        assertEquals("1aBC", Texto.toCamelCase("1a_b_c", false));
        assertEquals("1ABC", Texto.toCamelCase("1_a_b_c", false));
    }
    
    @Test
    public void toUnderScore(){
        assertEquals("Texto", Texto.toUnderScore("Texto"));
        assertEquals("texto", Texto.toUnderScore("texto"));
        assertEquals("Texto_Composto", Texto.toUnderScore("TextoComposto"));
        assertEquals("texto_Composto", Texto.toUnderScore("textoComposto"));
        assertEquals("123texto", Texto.toUnderScore("123texto"));
        assertEquals("123_Texto", Texto.toUnderScore("123Texto"));
        assertEquals("ab_C123_Texto", Texto.toUnderScore("abC123Texto"));
    }

    @Test
    public void removeFirst() {
        assertEquals("Texto", Texto.removeFirst("", "Texto"));
        assertEquals("TTexto", Texto.removeFirst("T", "TTTexto"));
        assertEquals("bataXta", Texto.removeFirst("X", "baXtaXta"));
        assertEquals("bataXXta", Texto.removeFirst("X", "bataXXXta"));
        assertEquals("AmendoIM", Texto.removeFirst("XXXX", "AmendoIM"));
    }

    @Test
    public void removeLast() {
        assertEquals("Texto", Texto.removeLast("", "Texto"));
        assertEquals("TTexto", Texto.removeLast("T", "TTTexto"));
        assertEquals("baXtata", Texto.removeLast("X", "baXtaXta"));
        assertEquals("bataXXta", Texto.removeLast("X", "bataXXXta"));
        assertEquals("AmendoIM", Texto.removeLast("XXXX", "AmendoIM"));
    }

    @Test
    public void removeCharAt() {
        assertEquals("ABCEF", Texto.removeCharAt("ABCDEF", 3));
        assertEquals("BAtaTA", Texto.removeCharAt("BAtaTA3", 6));
        assertEquals("ABCDEF", Texto.removeCharAt("0ABCDEF", 0));
        assertEquals("AmendoIM", Texto.removeCharAt("AmendoIM", 999));
    }

    @Test
    public void removeOuterParenteses() {
        assertEquals("ABC123", Texto.removeOuterParenteses("ABC123"));
        assertEquals("(ABC123", Texto.removeOuterParenteses("(ABC123"));
        assertEquals("ABC123)", Texto.removeOuterParenteses("ABC123)"));
        assertEquals("ABC123", Texto.removeOuterParenteses("(ABC123)"));
        assertEquals("ABC123)", Texto.removeOuterParenteses("(ABC123))"));
        assertEquals("()", Texto.removeOuterParenteses("()"));
        assertEquals("ABC123)()", Texto.removeOuterParenteses("(ABC123)())"));
    }

}
