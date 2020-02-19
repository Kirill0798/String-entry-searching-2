package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validator.searchValidator")
public class SearchValidator implements Validator<String> {
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException{
        if (value.isEmpty()){
            FacesMessage message = new FacesMessage("Отсутствует значение");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            component.getAttributes().put("style", "border-color: red;");
            throw new ValidatorException(message);
        }

    }
}
