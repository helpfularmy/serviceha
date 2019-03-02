package army.helpful.app.actions;

public enum EnumActionTypes {

    CONTENT_ADD_SUCCESS("success"),
    CONTENT_ADD_FAILURE("failure");
    String description;
    EnumActionTypes(String description){
        this.description= description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
