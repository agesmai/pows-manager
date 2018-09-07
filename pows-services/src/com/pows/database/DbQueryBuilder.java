package com.pows.database;

import java.util.ArrayList;

public class DbQueryBuilder {
    public String ReadQuery(String fSelect, String fFrom, String fWhere) {
        String sql;
        if (fSelect.equals("")) {
            fSelect = "1";
        }
        if (fFrom.equals("")) {
            fFrom = "DUAL";
        }
        if ((!fSelect.equals("1")) && (!fFrom.equals("DUAL")) && (!fWhere.equals("")))
            sql = "SELECT " + fSelect + " FROM " + fFrom + " WHERE " + fWhere;
        else {
            sql = "SELECT " + fSelect + " FROM " + fFrom;
        }

        return sql;
    }

    public String generateColumnSet(ArrayList<String> columns) {
        StringBuilder columnSet = new StringBuilder();
        for (String column : columns) {
            columnSet.append(column).append(", ");
        }

        if (!columnSet.toString().equals("") && columnSet.length() > 0 && columnSet.charAt(columnSet.length() - 2) == ',') {
            columnSet = new StringBuilder(columnSet.substring(0, columnSet.length() - 2));
        }

        return columnSet.toString();
    }

    public String generateValueSet(ArrayList<String> values) {
        StringBuilder valueSet = new StringBuilder();
        for (String value : values) {
            valueSet.append("'").append(value).append("', ");
        }

        if (!valueSet.toString().equals("") && valueSet.length() > 0 && valueSet.charAt(valueSet.length() - 2) == ',') {
            valueSet = new StringBuilder(valueSet.substring(0, valueSet.length() - 2));
        }

        return valueSet.toString();
    }

    public String generateUpdatePair(String updateColumn, String updateValue) {
        String upair = "";
        if (updateColumn != null && updateValue != null) {
            upair = updateColumn + " = " + "'" + updateValue + "'";
        }
        return upair;
    }

    public String generateUpdatePair(String updateColumn, Number updateValue) {
        String upair = "";
        if (updateColumn != null && updateValue != null) {
            upair = updateColumn + " = " + String.valueOf(updateValue);
        }
        return upair;
    }

    public String generateUpdateSet(ArrayList<String> updatePairs) {
        StringBuilder uSet = new StringBuilder();
        for (String upair : updatePairs) {
            uSet.append(", ").append(upair);
        }
        if (!uSet.toString().equals("") && uSet.length() > 0 && uSet.charAt(0) == ',') {
            uSet = new StringBuilder(uSet.substring(2, uSet.length()));
        }
        return uSet.toString();
    }

    public String InsertQuery(String fInto, String columnSet, String valueSet) {
        String sql = "";
        if (!fInto.equals("")) {
            sql = "INSERT INTO " + fInto + " (" + columnSet + ") VALUES (" + valueSet + ")";
        }
        return sql;
    }

    public String DeleteQuery(String fFrom, String fWhere) {
        String sql = "";
        if ((fFrom != null) && (fWhere != null)) {
            sql = "DELETE FROM " + fFrom + " WHERE " + fWhere;
        }
        return sql;
    }

    public String UpdateQuery(String fTable, String fSet, String fWhere) {
        String sql = "";
        if (fTable != null && fSet != null && fWhere != null) {
            sql = "UPDATE " + fTable + " SET " + fSet + " WHERE " + fWhere;
        } else {
            return sql;
        }

        return sql;
    }

}
