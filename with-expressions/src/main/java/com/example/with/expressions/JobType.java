package com.example.with.expressions;

public enum JobType {
    Metadata(1, "metadata"),
    Media(2, "media");

    private final int value;
    private final String description;

    JobType(int value, String description) {
        this.value = value;
        this.description = description;

    }

    public static JobType getByDescription(String description){
        for (JobType value : JobType.values()) {
            if (value.description.equals(description)){
                return value;
            }
        }
        return null;
    }
}
