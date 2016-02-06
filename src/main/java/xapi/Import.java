package xapi;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import gov.adlnet.xapi.model.Statement;


public class Import {
	private static Statement _statement;
	private static JAXBContext _jaxbInstance;
	
public static void ImportStatement(Statement statement){
	_statement = statement;	
}

public static JAXBContext getInstance(){
	if(_jaxbInstance == null){
		try {
			_jaxbInstance = JAXBContext.newInstance("gov.adlnet.xapi.model:gov.adlnet.xapi.model.Statement" );
			Marshaller marsh = _jaxbInstance.createMarshaller();
			//XML Page beeing created here into sitemap2.xml (gonna change later or pushed into hbm file!
			//TODO check if sitemap2 beeing created
			//TODO try to push into statement.hbm.xml
			marsh.marshal(_jaxbInstance, new File("sitemap2.xml"));
			
		} catch (JAXBException e) {
			System.out.println("xapi model class not found");
			e.printStackTrace();
		} 

	}
	return _jaxbInstance;
}


}
