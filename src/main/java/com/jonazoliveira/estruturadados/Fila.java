package com.jonazoliveira.estruturadados;

public class Fila<E> {
    private E[] fila;
    private int tamanho = 0;

    public Fila(int capacidade) {
        this.fila = (E[]) new Object[capacidade];
    }

    public Fila() {
        this.fila = (E[]) new Object[10];
    }

    public boolean enfileirar(E elemento) {
        if(this.tamanho < this.fila.length) {
            this.fila[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        } else {
            return false;
        }
    }

    public boolean desenfileirar() {
        if(this.tamanho > 0) {
            for(int i = 0; i < this.tamanho - 1; i++) {
                this.fila[i] = this.fila[i+1];
            }
            this.fila[this.tamanho - 1] = null;
            this.tamanho--;
            return true;
        } else {
            return false;
        }
    }

    public E espiar() {
        return this.tamanho > 0 ? this.fila[0] : null;
    }

    public boolean estaVazio() {
        return this.tamanho == 0;
    }

    public boolean estaCheia() {
        return this.tamanho == this.fila.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < this.tamanho - 1; i++) {
            stringBuilder.append(this.fila[i]);
            stringBuilder.append(", ");
        }
        if(this.tamanho > 0) {
            stringBuilder.append(this.fila[this.tamanho - 1]);
        }
        return stringBuilder.toString();
    }
}
