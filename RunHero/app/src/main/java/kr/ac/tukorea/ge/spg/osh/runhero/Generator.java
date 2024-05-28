package kr.ac.tukorea.ge.spg.osh.runhero;

import android.graphics.Canvas;

import java.util.ArrayList;

public class Generator implements IRHGameObject{
    private ArrayList<Generator> generators = new ArrayList<>();
    protected float genTime;
    protected float genInterval;
    protected static GenType genType;
    protected enum GenType {
        MONSTER, SELECTOR
    }


    public void addGenerator(Generator gen) {
        generators.add(gen);
    }


    protected GenType getGenType() {
        return genType;
    }

    @Override
    public void update(float elapsedSeconds) {
        for(int i = generators.size() - 1; i >=0; --i) {
            generators.get(i).update(elapsedSeconds);
        }
    }


    @Override
    public void draw(Canvas canvas) {

    }
}
