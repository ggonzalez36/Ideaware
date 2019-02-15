package SpringCycle;


import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SortingController {
	

	

	
	@RequestMapping(value = "/Sorting", method=RequestMethod.POST)
	public List<String> foo(@RequestParam("number") List<String> to) {
	
	 
	    Collections.sort(to, Collections.reverseOrder());
	    for(String number : to) {
	        System.out.println(number);
	    }
	    
	   return to;
	}

	
	

	
	

}
