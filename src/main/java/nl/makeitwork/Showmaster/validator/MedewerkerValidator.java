package nl.makeitwork.Showmaster.validator;

import nl.makeitwork.Showmaster.model.Medewerker;
import nl.makeitwork.Showmaster.model.UitnodigingMedewerker;
import nl.makeitwork.Showmaster.service.MedewerkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MedewerkerValidator implements Validator {

        @Autowired
        private MedewerkerService medewerkerService;

        @Override
        public boolean supports(Class<?> aClass) {
            return Medewerker.class.equals(aClass);
        }

        public void validateEmail(Object object, Errors errors){
            UitnodigingMedewerker uitnodigingMedewerker = (UitnodigingMedewerker) object;



            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailadres","notEmpty");
            if (uitnodigingMedewerker.getEmailadres().length() <10){
                errors.rejectValue("emailadres", "Size.registratieFormulier.username");
                System.out.println(errors);
            }

        }

        @Override
        public void validate(Object object, Errors errors) {
            Medewerker medewerker = (Medewerker) object;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gebruikersnaam", "NotEmpty");
            if (medewerker.getGebruikersnaam().length() < 6 || medewerker.getGebruikersnaam().length() > 32) {
                errors.rejectValue("gebruikersnaam", "Size.registratieFormulier.username");
            }
            if (medewerkerService.findByUsername(medewerker.getGebruikersnaam()) != null) {
                errors.rejectValue("gebruikersnaam", "Duplicate.registratieFormulier.gebruikersnaam");
            }


            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "wachtwoord", "NotEmpty");
            if (medewerker.getWachtwoord().length() < 8 || medewerker.getWachtwoord().length() > 32) {
                errors.rejectValue("wachtwoord", "Size.registratieFormulier.wachtwoord");
            }

            if (!medewerker.getWachtwoordBevestigen().equals(medewerker.getWachtwoord())) {
                errors.rejectValue("wachtwoordBevestigen", "Diff.registratieFormulier.wachtwoordBevestigen");
            }
        }
    }


