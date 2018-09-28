package mocks;

import java.util.List;

import ar.edu.untref.dyasc.interfaces.FibonacciInterface;

public class FibonacciMock implements FibonacciInterface{
    
    private List<Long> sucesion;
    private int dimension;
    private long sumatoria;

    @Override
    public void generarSucesion(int n) {
        this.setDimension(n);
    }

    public List<Long> getSucesion() {
        return this.sucesion;
    }

    public void setSucesion(List<Long> sucesion) {
        this.sucesion = sucesion;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void setSumatoria(long sumatoria) {
        this.sumatoria = sumatoria;
    }

    @Override
    public Long getSumatoria() {
        return this.sumatoria;
    }

    @Override
    public int getN() {
        return this.dimension;
    }

}
