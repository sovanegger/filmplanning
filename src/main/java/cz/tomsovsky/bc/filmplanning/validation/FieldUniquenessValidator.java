package cz.tomsovsky.bc.filmplanning.validation;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cz.tomsovsky.bc.filmplanning.dto.IDomain;
import cz.tomsovsky.bc.filmplanning.service.ValidationService;

/**
 * Třída slouží k validaci atributu označeného anotací <code>@FieldUniqueness</code>. Kontroluje,
 * zdali hodnota tohoto atributu již není obsažena v databázi.
 * 
 * @author Martin Tomšovský
 */
public class FieldUniquenessValidator implements ConstraintValidator<FieldUniqueness, Serializable> {
	@Autowired
	private ValidationService validationService;
	
	private Field[] fieldNames;
	
	/**
	 * Inicializace instančních proměnných na základě hodnot uvedených 
	 * v konkrétním použití anotace.
	 * 
	 * @param constraintAnnotation nese informace o hodnotách, předaných v anotaci
	 */
	@Override
	public void initialize(FieldUniqueness constraintAnnotation) {
		fieldNames = constraintAnnotation.fields();
	}

	/**
	 * Samotná kontrola, zdali je hodnota pole jedinečná oproti hodnotám v databázi.
	 * 
	 * @param value hodnota, která se má kontrolovat
	 * @param context poskytuje kontextové údaje a operace při použití validátoru
	 * @return true: hodnota je jedinečná, false: hodnota je již v databázi
	 */
	@Override
	public boolean isValid(Serializable value, ConstraintValidatorContext context) {
		String fieldName = "";
		IDomain domain = (IDomain) value;
		boolean isUnique = true;
		try {
			for (int i=0; i<fieldNames.length; i++) {
				fieldName = fieldNames[i].fieldName();
				Object fieldValue = BeanUtils.getProperty(value, fieldName);
				if (!validationService.isFieldValueUnique(domain.getClass(), fieldName, fieldValue)) {
					context.disableDefaultConstraintViolation();
			        context.buildConstraintViolationWithTemplate(fieldNames[i].errorMessage()).addNode(fieldName).addConstraintViolation();
			        if (isUnique)
			        	isUnique = false;
				}
			}
		}
		catch (NoSuchMethodException exc) {
			exc.printStackTrace();
		}
		catch (InvocationTargetException exc) {
			exc.printStackTrace();
		}
		catch (IllegalAccessException exc) {
			exc.printStackTrace();
		}
		return isUnique;
	}

	public ValidationService getValidationService() {
		return validationService;
	}
	public void setValidationService(ValidationService validationService) {
		this.validationService = validationService;
	}
}
