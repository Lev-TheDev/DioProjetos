package br.com.dio.model;

public enum GameStatusEnum {
    NON_STARTED("Non Started"),
    INCOMPLETE("Incomplete"),
    COMPLETE("Complete");

    private String label;
    GameStatusEnum(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
