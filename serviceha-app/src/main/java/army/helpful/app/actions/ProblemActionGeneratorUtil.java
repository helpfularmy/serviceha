package army.helpful.app.actions;

import army.helpful.app.actions.EnumActionTypes;
import army.helpful.app.actions.ProblemAction;

public class ProblemActionGeneratorUtil {
    public   ProblemAction generateProblemAction(Object payloadObject,
                                                  EnumActionTypes type){


        ProblemAction problemAction= new ProblemAction();
        problemAction.setType(type.name());
        problemAction.setDescription(type.getDescription());
        problemAction.setPayloadObject(payloadObject);

        return problemAction;
    }
}
