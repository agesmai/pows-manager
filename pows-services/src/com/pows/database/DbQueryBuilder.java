package com.pows.database;

import java.util.ArrayList;

public class DbQueryBuilder {
    public String ReadQuery(String fSelect, String fFrom, String fWhere) {
        String sql = "";
        if (fSelect.equals("")) {
            fSelect = "1";
        }
        if (fFrom.equals("")) {
            fFrom = "DUAL";
        }
        if ((!fSelect.equals("1")) && (!fFrom.equals("DUAL")) && (!fWhere.equals(""))) {
            sql = "SELECT " + fSelect + " FROM " + fFrom + " WHERE " + fWhere;
        } else {
            sql = "SELECT " + fSelect + " FROM " + fFrom;
        }

        return sql;
    }

    public String generateColumnSet(ArrayList<String> columns) {
        String columnSet = "";
        for (String column : columns) {
            columnSet = columnSet + column + ", ";
        }

        if (!columnSet.equals("") && columnSet.length() > 0 && columnSet.charAt(columnSet.length() - 2) == ',') {
            columnSet = columnSet.substring(0, columnSet.length() - 2);
        }

        return columnSet;
    }

    public String generateValueSet(ArrayList<String> values) {
        String valueSet = "";
        for (String value : values) {
            valueSet = valueSet + "'" + value + "', ";
        }

        if (!valueSet.equals("") && valueSet.length() > 0 && valueSet.charAt(valueSet.length() - 2) == ',') {
            valueSet = valueSet.substring(0, valueSet.length() - 2);
        }

        return valueSet;
    }

    public String InsertQuery(String fInto, String columnSet, String valueSet) {
        String sql = "";
        if (!fInto.equals("")) {
            sql = "INSERT INTO " + fInto + " (" + columnSet + ") VALUES (" + valueSet + ")";
        }
        return sql;
    }

    public String DeleteQuery() {
        String sql = "";
        return sql;
    }

    public String UpdateQuery() {
        String sql = "";
        return sql;
    }

    public String InsertOrUpdateQuery() {
        String sql = "";
        return sql;
    }
}
