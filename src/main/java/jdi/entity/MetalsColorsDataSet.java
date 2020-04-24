package jdi.entity;



import java.util.Arrays;

import static java.lang.String.*;
import static java.util.Arrays.stream;


public class MetalsColorsDataSet {
    private int[] summary;
    private String color;
    private String metals;
    private String[] vegetables;
    private String[] elements;

    public int getOdd() {
        return this.summary[0];
    }

    public int getEven() {
        return this.summary[1];
    }

    public String getVegetablesToString() {
        return getToString(vegetables);

    }

    public String getElementsToString() {
        return getToString(elements);
    }

    public String getExpectedResult() {
        return format(
                "Summary: %s\n" +
                        "Elements: %s\n" +
                        "Color: %s\n" +
                        "Metal: %s\n" +
                        "Vegetables: %s",
                stream(this.summary).sum(), this.getElementsToString(), this.color, this.metals, this.getVegetablesToString());
    }

    private String getToString(String[] elements) {
        StringBuilder stringBuilder = new StringBuilder();
        return String.join(", ", elements);
    }


    public int[] getSummary() {
        return summary;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public MetalsColorsDataSet() {
    }

    public MetalsColorsDataSet(int[] summary, String color, String metals, String[] vegetables, String[] elements) {
        this.summary = summary;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "MetalsColorsDataSet{" +
                "summary=" + Arrays.toString(summary) +
                ", color='" + color + '\'' +
                ", metals='" + metals + '\'' +
                ", vegetables=" + Arrays.toString(vegetables) +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}




