package app.validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("xValidator")
public class XValidator implements Validator<Object> {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        double x = (double) value;
        for (double i = -3; i <= 3; i += 0.5) {
            if (x == i) {
                return;
            }
        }
        FacesMessage msg = new FacesMessage("X validation failed.");
        throw new ValidatorException(msg);
    }
}

