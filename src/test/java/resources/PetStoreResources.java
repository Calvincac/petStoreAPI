package resources;

public enum PetStoreResources {
    PET("/pet");


    private String resource;

    PetStoreResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
