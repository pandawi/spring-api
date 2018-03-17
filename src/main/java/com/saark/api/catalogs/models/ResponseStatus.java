package com.saark.api.catalogs.models;

public enum ResponseStatus {
    FAILURE("FAILURE"),
    SUCCESS("SUCCESS"),
    PARTIAL_FAILURE("PARTIAL_FAILURE");

    private final String text;

    /**
     * @param text
     */
    ResponseStatus(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
