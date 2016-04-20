
package validator;

import Person.Member;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegistrationValidator implements Validator{
    private static final String EMAIL_PATTERN = 
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    @Override
    public void validate(Object obj, Errors errors) {
        Member member = (Member) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "valid.userName");
        if(!member.getEmail().matches(EMAIL_PATTERN)) {
            errors.rejectValue("email","valid.email");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConf", "valid.passwordConf");
        if (!member.getPassword().equals(member.getPasswordConf())) {
            errors.rejectValue("passwordConf", "valid.passwordConfDiff");
        }
        
    }

 
    
    
    
    @Override
    public boolean supports(Class<?> paramClass) {
       return Member.class.equals(paramClass);
    }
    
}
