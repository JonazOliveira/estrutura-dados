package com.jonazoliveira.estruturadados;

/**
 *  Uma estrutura de dados que armazena uma coleção de elementos do mesmo tipo
 *  e os organiza  em posições consecutivas na memória.
 *
 * @author Jonaz_Oliveira
 */

public class Vetor<E> {
    private E[] vetor;
    private int tamanho;
    private int garanteCapacidade;


    public Vetor(int capacidade) {
        this.vetor = (E[]) new Object[capacidade];
        this.tamanho = 0;
        this.garanteCapacidade = 1;
    }

    public Vetor(int capacidade, int aumentoAdicao) {
        this.vetor = (E[]) new Object[capacidade];
        this.tamanho = 0;
        this.garanteCapacidade = aumentoAdicao;
    }

    public boolean adiciona(E elemento) {
        this.aumentaCapacidade();
        this.vetor[this.tamanho] = elemento;
        this.tamanho++;
        return true;
    }

    public boolean adiciona(int posicao, E elemento) {
        if(!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        this.aumentaCapacidade();
        for (int i = this.tamanho; i > posicao; i--) {
            this.vetor[i] = this.vetor[i - 1];
        }
        this.vetor[posicao] = elemento;
        this.tamanho++;
        return true;
    }

    private void aumentaCapacidade() {
        if(this.tamanho == this.vetor.length) {
            E[] novoVetor = (E[]) new Object[this.vetor.length + this.garanteCapacidade];
            System.arraycopy(this.vetor, 0, novoVetor, 0, this.tamanho);
            this.vetor = novoVetor;
        }
    }

    public void garanteCapacidade(int valor) {
        this.garanteCapacidade = valor;
    }

    public boolean remove(int posicao) {
        if(!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for(int i = posicao; i < this.tamanho - 1; i++) {
            this.vetor[i] = this.vetor[i + 1];
        }
        this.tamanho--;
        this.vetor[this.tamanho] = null;
        return true;
    }

    public boolean remove(E elemento) {
       int posicao = this.busca(elemento);
       if(posicao != -1) {
           this.remove(posicao);
       }
       return true;
    }

    public E busca(int posicao) {
        if(!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.vetor[posicao];
    }

    public int busca(E elemento) {
        for(int i = 0; i < this.tamanho; i++) {
            if(this.vetor[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public boolean estaVazio() {
        return this.tamanho == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for(int i = 0; i < this.tamanho-1; i++) {
            builder.append(vetor[i]);
            builder.append(", ");
        }
        if(this.tamanho > 0) {
            builder.append(vetor[this.tamanho-1]);
        }
        builder.append("]");
        return builder.toString();
    }
}
