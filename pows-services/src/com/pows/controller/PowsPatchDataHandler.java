package com.pows.controller;

import com.pows.entity.PowsPatchData;

import java.util.ArrayList;

public class PowsPatchDataHandler {
    public static Object getValueOfPath(ArrayList<PowsPatchData> pdata, String path) {

        for (PowsPatchData data : pdata) {
            if (data.getPath().equals(path)) {
                return data.getValue();
            }
        }
        return null;
    }
}
