package com.jonazoliveira.estruturadados;

public class ListaEncadeada<E> {
    private No<E> inicio;
    private No<E> ultimo;
    private int tamanho;

    public void adiciona(E elemento) {
        No<E> celula = new No<>(elemento);
        if(this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        if(this.tamanho == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        No<E> atual = this.inicio;

        for(int i = 0; i < this.tamanho -1 ; i++) {
            builder.append(atual.getElemento()).append(", ");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");

        return builder.toString();
    }

}

class No<E> {
    private E elemento;
    private No<E> proximo;

    public No(E elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public No(E elemento, No<E> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public No<E> getProximo() {
        return proximo;
    }

    public void setProximo(No<E> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "No[" +
                "elemento=" + elemento +
                ", proximo=" + proximo +
                ']';
    }
}