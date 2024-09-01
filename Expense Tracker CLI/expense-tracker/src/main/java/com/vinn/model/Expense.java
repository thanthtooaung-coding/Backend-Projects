package com.vinn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Expense {
    private int id;
    private String date;
    private String description;
    private double amount;

    public static Expense fromString(String str) {
        String[] parts = str.split(",");
        return new Expense(
                Integer.parseInt(parts[0]),
                parts[1],
                parts[2],
                Double.parseDouble(parts[3])
        );
    }
}
