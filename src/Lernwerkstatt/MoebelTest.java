/*
 * Copyright (c) 2022 Stefan Psutka
 * All rights reserved
 */

package Lernwerkstatt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoebelTest {

    Moebel ref;

    @BeforeEach
    void setUp() {
        try {
            System.out.println("setup running!");
            ref = new Moebel("Sofa", true);
        } catch (Exception e) {
            System.out.println("setup failed!");
            e.printStackTrace();
        }
        System.out.println("setup done!");
    }

    @Test
    void setgetArt() {
        try {
            ref.setArt("Tisch");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("Tisch", ref.getArt());
    }

    @Test
    void setVerschiebbar() {
        ref.setVerschiebbar(false);
        assertFalse(ref.isVerschiebbar());
        ref.setVerschiebbar(true);
        assertTrue(ref.isVerschiebbar());
    }

    @Test
    void getArt() {
    }

    @Test
    void isVerschiebbar() {
    }

    @Test
    void testToString() {
        assertEquals("Moebel{art='Sofa', verschiebbar=true}", ref.toString());
    }

    @Test
    void print() {
    }
    @Test
    void testException(){
        assertThrows(Exception.class, () -> new Moebel(null, true));
    }
}