package com.mycompany.unicafe;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoKonstruktorillaOikein() {
        assertThat(kortti.toString(), is("saldo: 0.10"));
    }
    
    @Test
    public void lataaRahaaToimii() {
        kortti.lataaRahaa(1);
        assertThat(kortti.toString(), is("saldo: 0.11"));
    }
    
    @Test
    public void saldoaOnTarpeeksi() {
        kortti.otaRahaa(1);
        assertThat(kortti.toString(), is("saldo: 0.9"));
    }
    
    @Test
    public void saldoaEiTarpeeksi() {
        kortti.otaRahaa(11);
        assertThat(kortti.toString(), is("saldo: 0.10"));
    }
    
    @Test
    public void saldoaOnTarpeeksiTrue() {
        assertThat(kortti.otaRahaa(1), is(true));
    }
    
    @Test
    public void saldoaEiTarpeeksiFalse() {
        
        assertThat(kortti.otaRahaa(11), is(false));
    }
}
