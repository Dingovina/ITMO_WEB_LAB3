package app;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("yValidator")
public class YValidator implements Validator<Object> {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        double y = (double) value;
        if (y < -3 || y > 5) {
            FacesMessage msg =
                    new FacesMessage("Point validation failed.",
                            "Y must be between -3 and 5");
            FacesContext.getCurrentInstance().addMessage("form:y-input", msg);
            throw new ValidatorException(msg);
        }
    }
    
}

