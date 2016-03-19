package jackson_demo;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author jingchen
 *
 */
public class EmployeeTest {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			Employee em = mapper.readValue(
					"{\"id\":1,\"firstName\":\"Lokesh\",\"lastName\":\"Gupta\",\"roles\":[\"ADMIN\",\"MANAGER\"]}",
					Employee.class);
			System.out.println(em);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*-----------------------------Output-----------------------------* 

Employee [id=1, firstName=Lokesh, lastName=Gupta, roles=[ADMIN, MANAGER]]

*——*/