package data;

public enum PetStoreTestData {
    AVAILABLE_STATUS("available"),
    PENDING_STATUS("pending"),
    SOLD_STATUS("sold"),
    UNKNOWN_STATUS("unknown");

    private String value;
    PetStoreTestData(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
