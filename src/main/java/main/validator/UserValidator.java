package main.validator;

import main.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {
    private ValidationResponse validationResponse;

    /**
     *
     * @param name
     * @param type First name / Last name
     */
    private void nameValidator(String name, String type) {
        if (StringUtils.isEmpty(name)) {
            this.validationResponse.addMessage(type + "\nfield is empty");
        } else {
            final String nameExpression = "^[A-Z][a-z]*$";
            if (!name.matches(nameExpression)) {
                this.validationResponse.addMessage("\nWrong " + type +" format: must start with capital letter and contain only letters");
            }
        }
    }

    private void emailValidator(String email) {
        if (StringUtils.isEmpty(email)) {
            this.validationResponse.addMessage("\nEmail field is empty");
        } else {
            final String emailExpression = "^(.+)@(.+)$";
            if (!email.matches(emailExpression)) {
                this.validationResponse.addMessage("\nWrong email format");
            }
        }
    }

    private void passwordValidator(String password) {
        if (StringUtils.isEmpty(password)) {
            this.validationResponse.addMessage("\nPassword field is empty");
        }
    }

    public ValidationResponse validate(User user) {
        this.validationResponse = new ValidationResponse();
        nameValidator(user.getFirstName(),"First name");
        nameValidator(user.getLastName(), "Last name");
        emailValidator(user.getEmail());
        passwordValidator(user.getPassword());

        if (!this.validationResponse.getMessages().isEmpty()) {
            this.validationResponse.setIsValid(false);
        }

        return this.validationResponse;
    }
}
