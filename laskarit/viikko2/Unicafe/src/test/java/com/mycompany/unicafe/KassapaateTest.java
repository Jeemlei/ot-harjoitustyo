package com.mycompany.unicafe;

import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate k;
    Maksukortti m;

    public KassapaateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        k = new Kassapaate();
        m = new Maksukortti(400);
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void rahaKonstruktorissaOikein() {
        assertThat(k.kassassaRahaa(), is(100000));
    }
    
    @Test
    public void edullisetKonstruktorissaOikein() {
        assertThat(k.edullisiaLounaitaMyyty(), is(0));
    }
    
    @Test
    public void maukkaatKonstruktorissaOikein() {
        assertThat(k.maukkaitaLounaitaMyyty(), is(0));
    }
    
    @Test
    public void edullisestiKateinenKassa() {
        k.syoEdullisesti(240);
        assertThat(k.kassassaRahaa(), is(100240));
    }
    
    @Test
    public void edullisestiKateinenVaihto() {
        assertThat(k.syoEdullisesti(241), is(1));
    }
    
    @Test
    public void edullisestiKateinenMyydyt() {
        k.syoEdullisesti(240);
        assertThat(k.edullisiaLounaitaMyyty(), is(1));
    }
    
    @Test
    public void edulKateinenEiRiitaKassa() {
        k.syoEdullisesti(0);
        assertThat(k.kassassaRahaa(), is(100000));
    }
    
    @Test
    public void edulKateinenEiRiitaVaihto() {
        assertThat(k.syoEdullisesti(1), is(1));
    }
    
    @Test
    public void edulKateinenEiRiitaMyydyt() {
        k.syoEdullisesti(1);
        assertThat(k.edullisiaLounaitaMyyty(), is(0));
    }
    
    @Test
    public void maukkaastiKateinenKassa() {
        k.syoMaukkaasti(400);
        assertThat(k.kassassaRahaa(), is(100400));
    }
    
    @Test
    public void maukkaastiKateinenVaihto() {
        assertThat(k.syoMaukkaasti(401), is(1));
    }
    
    @Test
    public void maukkaastiKateinenMyydyt() {
        k.syoMaukkaasti(400);
        assertThat(k.maukkaitaLounaitaMyyty(), is(1));
    }
    
    @Test
    public void maukKateinenEiRiitaKassa() {
        k.syoMaukkaasti(0);
        assertThat(k.kassassaRahaa(), is(100000));
    }
    
    @Test
    public void maukKateinenEiRiitaVaihto() {
        assertThat(k.syoMaukkaasti(1), is(1));
    }
    
    @Test
    public void maukKateinenEiRiitaMyydyt() {
        k.syoMaukkaasti(0);
        assertThat(k.maukkaitaLounaitaMyyty(), is(0));
    }
    
    @Test
    public void edullisestiKorttiKassa() {
        k.syoEdullisesti(m);
        assertThat(k.kassassaRahaa(), is(100000));
    }
    
    @Test
    public void edullisestiKorttiSaldo() {
        k.syoEdullisesti(m);
        assertThat(m.saldo(), is(160));
    }
    
    @Test
    public void edullisestiKorttiTrue() {
        assertThat(k.syoEdullisesti(m), is(true));
    }
    
    @Test
    public void edullisestiKorttiMyydyt() {
        k.syoEdullisesti(m);
        assertThat(k.edullisiaLounaitaMyyty(), is(1));
    }
    
    @Test
    public void edulKorttiEiRiitaSaldo() {
        k.syoEdullisesti(m);
        k.syoEdullisesti(m);
        assertThat(m.saldo(), is(160));
    }
    
    @Test
    public void edulKorttiEiRiitaFalse() {
        k.syoEdullisesti(m);
        assertThat(k.syoEdullisesti(m), is(false));
    }
    
    @Test
    public void edulKorttiEiRiitaMyydyt() {
        k.syoMaukkaasti(m);
        k.syoEdullisesti(m);
        assertThat(k.edullisiaLounaitaMyyty(), is(0));
    }
    
    @Test
    public void maukkaastiKorttiKassa() {
        k.syoMaukkaasti(m);
        assertThat(k.kassassaRahaa(), is(100000));
    }
    
    @Test
    public void maukkaastiKorttiSaldo() {
        k.syoMaukkaasti(m);
        assertThat(m.saldo(), is(0));
    }
    
    @Test
    public void maukkaastiKorttiTrue() {
        assertThat(k.syoMaukkaasti(m), is(true));
    }
    
    @Test
    public void maukkaastiKorttiMyydyt() {
        k.syoMaukkaasti(m);
        assertThat(k.maukkaitaLounaitaMyyty(), is(1));
    }
    
    @Test
    public void maukKorttiEiRiitaSaldo() {
        k.syoEdullisesti(m);
        k.syoMaukkaasti(m);
        assertThat(m.saldo(), is(160));
    }
    
    @Test
    public void maukKorttiEiRiitaFalse() {
        k.syoMaukkaasti(m);
        assertThat(k.syoMaukkaasti(m), is(false));
    }
    
    @Test
    public void maukKorttiEiRiitaMyydyt() {
        k.syoEdullisesti(m);
        k.syoMaukkaasti(m);
        assertThat(k.maukkaitaLounaitaMyyty(), is(0));
    }
    
    @Test
    public void lataaKorttiaKassa() {
        k.lataaRahaaKortille(m, 1);
        assertThat(k.kassassaRahaa(), is(100001));
    }
    
    @Test
    public void lataaKorttiaSaldo() {
        k.lataaRahaaKortille(m, 1);
        assertThat(m.saldo(), is(401));
    }
    
    @Test
    public void lataaKorttiaNegSaldo() {
        k.lataaRahaaKortille(m, -1);
        assertThat(m.saldo(), is(400));
    }
}
