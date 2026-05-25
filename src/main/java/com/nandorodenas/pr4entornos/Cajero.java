
package com.nandorodenas.pr4entornos;

import java.util.ArrayList;

/**
 * Representa un cajero automático para gestionar operaciones bancarias
 * @author nando
 */
public class Cajero {
/**
 * Nombre del cajero
 */
    String n;
/**
 * Contador de la cantidad de tickets emitido
 */
    int c;
/** 
 * Total acumulado de dinero facturado en el dia
 */
    double t;
/**
 * Lista de los productos
 */
    ArrayList<Producto> ps;

/**
 * Constructor de cajero
 * @param n es el nombre que recibe el cajero
 */
    public Cajero(String n) {
        this.n = n;
        this.c = 0;
        this.t = 0;
        this.ps = new ArrayList<>();
    }
/**
 * Añade el producto a la lista
 * @param p Es el producto que recibe y que se añade 
 */
    public void ANADIRPRODUCTO(Producto p) {
        ps.add(p);
    }
/**
 * Elimina el producto a la lista 
 * @param p Es el producto que se elimina
 */
    public void eliminarProDUCTO(Producto p) {
        ps.remove(p);
    }
/**
 * El metodo calcula el importe y devuelve un mensaje con lo que va a cobrar
 */
    public void cobrar() {
        double subt = 0;
        for (Producto p : ps) {
            subt = subt + p.calcularImporte();
        }
        double iva = subt * 0.21;
        double tot = subt + iva;
        System.out.println("===== TICKET =====");
        System.out.println("Cajero: " + n);
        for (Producto p : ps) {
            System.out.println(p.getNombre() + " x" + p.getCantidad()
                    + " = " + String.format("%.2f", p.calcularImporte()) + " EUR");
        }
        System.out.println("------------------");
        System.out.println("Subtotal: " + String.format("%.2f", subt) + " EUR");
        System.out.println("IVA (21%): " + String.format("%.2f", iva) + " EUR");
        System.out.println("TOTAL: " + String.format("%.2f", tot) + " EUR");
        System.out.println("==================");
        c = c + 1;
        t = t + tot;
        ps.clear();
    }
/** 
 * Saca por pantalla el cajero que es con sus tickets emitidos, el total facturado y el iva recuadado
 */
    public void cierreCaja() {
        double ivaRec = t - (t / (1 + 0.21));
        System.out.println("===== CIERRE DE CAJA =====");
        System.out.println("Cajero: " + n);
        System.out.println("--------------------------");
        System.out.println("Tickets emitidos: " + c);
        System.out.println("Total facturado: " + String.format("%.2f", t) + "EUR");
        System.out.println("IVA recaudado: " + String.format("%.2f", ivaRec) + "EUR");
        System.out.println("==========================");
    }
/**
 * 
 * @return true si esta vacio, false si no
 */
    public boolean ticketVacio() {
        return ps.isEmpty();
    }
/**
 * 
 * @return Devuelve la cantidad de tickets emitidos
 */
    public int getTicketsEmitidos() {
        return c;
    }
/**
 * 
 * @return Devuelve el total del dia
 */
    public double getTotalDia() {
        return t;
    }
}
