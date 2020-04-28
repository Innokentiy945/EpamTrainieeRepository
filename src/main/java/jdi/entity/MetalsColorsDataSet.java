package jdi.entity;



import lombok.*;

import java.util.Arrays;


import static java.lang.String.*;
import static java.util.Arrays.stream;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

}




