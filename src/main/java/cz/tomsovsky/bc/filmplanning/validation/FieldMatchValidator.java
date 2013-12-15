package cz.tomsovsky.bc.filmplanning.validation;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Třída slouží ke zjištění, jsou-li hodnoty dvou polí stejné. Slouží např. ke kontrole
 * hesla.
 * 
 * @author Martin Tomšovský
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Serializable>  {
	private String firstFieldName;
	private String secondFieldName;
	private String errorMessage;
	
	/**
	 * Inicializace instančních proměnných na základě hodnot uvedených 
	 * v konkrétním použití anotace.
	 * 
	 * @param constraintAnnotation nese informace o hodnotách, předaných v anotaci
	 */
	@Override
	public void initialize(FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
		errorMessage = constraintAnnotation.message();
	}

	/**
	 * Samotná kontrola, zdali jsou hodnoty polí shodné.
	 * 
	 * @param value hodnota, která se má kontrolovat
	 * @param context poskytuje kontextové údaje a operace při použití validátoru
	 * @return true: jsou shodné, false: nejsou shodné
	 */
	@Override
	public boolean isValid(Serializable value,
			ConstraintValidatorContext context) {
		try {
			final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
			final Object secondObj = BeanUtils.getProperty(value, secondFieldName);
			boolean fieldsMatch = true;
			
			fieldsMatch = (firstObj == null && secondObj == null) || (firstObj != null && firstObj.equals(secondObj));
			if(fieldsMatch==false) {
		        context.disableDefaultConstraintViolation();
		        context.buildConstraintViolationWithTemplate(errorMessage).addNode(secondFieldName).addConstraintViolation();
				return false;
			}
			return true;
		} 
		catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return false;
	}

}
