package validator;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Table;

public class SudokuValidator {

	public void validate(File file) throws JAXBException{
		Table table = new Table();
        JAXBContext context = JAXBContext.newInstance(Table.class);
        Unmarshaller um = context.createUnmarshaller();
        table = (Table) um.unmarshal(file);
 
        System.out.println(Messages.VALIDATING);
        boolean isValid = table.validateSudoku();
        if(isValid){
        	System.out.println(Messages.SUCCESS);
        }else{
        	System.out.println(Messages.FAILED);
        	System.out.println(table.getErrors());
        }
        
	}
	
}
