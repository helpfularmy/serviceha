package army.helpful.app.actions;

import army.helpful.app.model.BasicModel;
import army.helpful.app.model.Content;


public class ProblemAction extends BasicModel {
    String type;
    String description;

    Object payloadObject;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getPayloadObject() {
        return payloadObject;
    }

    public void setPayloadObject(Object payloadObject) {
        this.payloadObject = payloadObject;
    }

}
