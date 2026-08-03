package com.david.restaurante.model;

public class Pedido {

    private int id;
    private Cliente cliente;
    private Mesa mesa;
    private Producto producto;
    private int cantidad;

    public Pedido() {
    }

    public Pedido(int id, Cliente cliente, Mesa mesa, Producto producto, int cantidad) {
        this.id = id;
        this.cliente = cliente;
        this.mesa = mesa;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}