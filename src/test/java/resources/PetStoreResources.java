package resources;

public enum PetStoreResources {
    PET("/pet/"),
    ORDER("/store/order/"),
    USER("/user/");


    private String resource;

    PetStoreResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
