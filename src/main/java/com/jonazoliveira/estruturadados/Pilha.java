package com.jonazoliveira.estruturadados;

public class Pilha<E> {
    private E[] pilha;
    private int tamanho = 0;

    public Pilha(int capacidade) {
        this.pilha = (E[]) new Object[capacidade];
    }

    public Pilha() {
        this.pilha = (E[]) new Object[10];
    }

    public boolean empilhar(E elemento) {
        if(this.tamanho < this.pilha.length) {
            this.pilha[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        } else {
            return false;
        }
    }

    public boolean desempilhar() {
        if(this.tamanho > 0) {
            this.pilha[this.tamanho - 1] = null;
            this.tamanho--;
            return true;
        } else {
            return false;
        }
    }

    public E espiar() {
        return this.tamanho > 0 ? this.pilha[this.tamanho - 1] : null;
    }

    public boolean estaVazio() {
        return this.tamanho == 0;
    }

    public boolean estaCheia() {
        return this.tamanho == this.pilha.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = this.tamanho-1; i > 0; i--) {
            stringBuilder.append(this.pilha[i]);
            stringBuilder.append("\n");
        }
        if(this.tamanho > 0) {
            stringBuilder.append(this.pilha[0]);
        }
        return stringBuilder.toString();
    }
}
