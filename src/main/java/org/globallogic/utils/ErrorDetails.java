package org.globallogic.utils;

import java.util.List;

public class ErrorDetails {
    private final String timestamp;
    private final int codigo;
    private final List<String> details;

    public ErrorDetails(String timestamp, int codigo, List<String> details) {
        this.timestamp = timestamp;
        this.codigo = codigo;
        this.details = details;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public int getCodigo() {
        return codigo;
    }
    public List<String> getDetails() {
        return details;
    }
    public String toString() {
        return timestamp + ": " + codigo + "\n" + details;

    }
}