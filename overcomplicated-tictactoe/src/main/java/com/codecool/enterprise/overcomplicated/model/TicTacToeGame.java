package com.codecool.enterprise.overcomplicated.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class TicTacToeGame {

    private int field1, field2, field3, field4, field5, field6, field7, field8, field9;

    private ArrayList<Integer> fields = new ArrayList<>();

    private void addFields() {
        fields.add(getField1());
        fields.add(getField2());
        fields.add(getField3());
        fields.add(getField4());
        fields.add(getField5());
        fields.add(getField6());
        fields.add(getField7());
        fields.add(getField8());
        fields.add(getField9());
    }

    public TicTacToeGame() {
        addFields();
    }

}