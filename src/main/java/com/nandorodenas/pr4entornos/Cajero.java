/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to
change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this
template
 */
package com.nandorodenas.pr4entornos;

import java.util.ArrayList;

/**
 *
 * @author loren
 */
public class Cajero {

    public int getCantidad() {
        return cantidad;
    }

    public ArrayList<Producto> getLista() {
        return lista;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTotal() {
        return total;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setLista(ArrayList<Producto> lista) {
        this.lista = lista;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private String nombre;
    private int cantidad;
    private double total;
    private ArrayList<Producto> lista;

    public Cajero(String n) {
        this.nombre = n;
        this.cantidad = 0;
        this.total = 0;
        this.lista = new ArrayList<>();
    }

    public void aniadirProducto(Producto producto) {
        getLista().add(producto);
    }

    public void eliminarProducto(Producto producto) {
        getLista().remove(producto);
    }

    public void cobrar() {
        double subt = calcularSubtotal();
        double iva = calcularIva(subt);
        double tot = subt + iva;
        imprimirTicket(subt, iva, tot);
        setCantidad(getCantidad() + 1);
        setTotal(getTotal() + tot);
        getLista().clear();
    }

    private void imprimirTicket(double subt, double iva, double tot) {
        System.out.println("===== TICKET =====");
        System.out.println("Cajero: " + getNombre());
        for (Producto p : getLista()) {
            System.out.println(p.getNombre() + " x" + p.getCantidad()
                    + " = " + String.format("%.2f", p.calcularImporte()) + " EUR");
        }
        System.out.println("------------------");
        System.out.println("Subtotal: " + String.format("%.2f", subt) + " EUR");
        System.out.println("IVA (21%): " + String.format("%.2f", iva) + " EUR");
        System.out.println("TOTAL: " + String.format("%.2f", tot) + " EUR");
        System.out.println("==================");
    }

    private double calcularIva(double subt) {
        double iva = subt * IVA;
        return iva;
    }

    private double calcularSubtotal() {
        double subt = 0;
        for (Producto p : getLista()) {
            subt = subt + p.calcularImporte();
        }
        return subt;
    }
    private static final double IVA = 0.21;

    public void cierreCaja() {
        double ivaRec = calcularIva(getTotal() - (getTotal() / (1 + IVA)));
        System.out.println("===== CIERRE DE CAJA =====");
        System.out.println("Cajero: " + getNombre());
        System.out.println("--------------------------");
        System.out.println("Tickets emitidos: " + getCantidad());
        System.out.println("Total facturado: " + String.format("%.2f", getTotal()) + "EUR");
        System.out.println("IVA recaudado: " + String.format("%.2f", ivaRec) + "EUR");
        System.out.println("==========================");
    }

    public boolean ticketVacio() {
        return getLista().isEmpty();
    }

    public int getTicketsEmitidos() {
        return getCantidad();
    }

    public double getTotalDia() {
        return getTotal();
    }
}
