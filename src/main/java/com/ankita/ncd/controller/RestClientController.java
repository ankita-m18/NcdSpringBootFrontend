package com.ankita.ncd.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.ankita.ncd.dto.Patient;
import com.ankita.ncd.dto.Search;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ankita.ncd.dto.Score;

@Controller
@RequestMapping
public class RestClientController {
	
	public static final String CREATE_PATIENT_API = "http://localhost:9292/api/patients/";
	public static final String UPDATE_PATIENT_API = "http://localhost:9292/api/patients/{patientid}";
	public static final String GET_ALL_PATIENTS_API = "http://localhost:9292/api/patients/";
	public static final String GET_PATIENT_BY_ID_API = "http://localhost:9292/api/patients/id/{patientid}";
	public static final String GET_PATIENT_BY_FIRSTNAME_API = "http://localhost:9292/api/patients/firstname/{firstname}";
	public static final String GET_PATIENT_BY_LASTNAME_API = "http://localhost:9292/api/patients/lastname/{lastname}";
	Patient globalPatient;
	
	static RestTemplate restTemplate = new RestTemplate();
	
	/*public static void main(String[] args) {
		
		callGetAllPatientsAPI();
		//callGetPatientByIdAPI();
	    //callGetPatientByFirstnameAPI();
		//callGetPatientByLastnameAPI();
		//callCreatePatientAPI();
		//callUpdatePatientAPI();
		
	}*/
	

	private static List<Patient> callGetAllPatientsAPI()
	{
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		
//		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
//		
//		System.out.println(restTemplate.exchange(GET_ALL_PATIENTS_API, HttpMethod.GET, entity, String.class).getClass().getSimpleName());
		//ResponseEntity<List> result = restTemplate.getForEntity(GET_ALL_PATIENTS_API, List.class);
		
		//String patient = EntityUtils.toString (result); 
		Patient[] result = restTemplate.getForObject(GET_ALL_PATIENTS_API, Patient[].class);
		List<Patient> patient = Arrays.asList(result); 
		
		//Patient result = restTemplate.getForObject(GET_ALL_PATIENTS_API, Patient.class);
		//List<Patient> patient = Arrays.asList(result); 
		
		for(Patient p: patient)
		{
			System.out.println(p.getPatientid());
			System.out.println(p.getFirstname());
			System.out.println(p.getLastname());
			System.out.println(p.getGender());
			System.out.println(p.getPhone());
			System.out.println(p.getBirthday());
			System.out.println(p.getPincode());
			System.out.println(p.getScore());
			System.out.println(p.getScreening());
		}
		
		System.out.println(patient);
		
		return patient;
		
//		System.out.println(result.getBody());
//		return result.getBody();
		
	}
	
	private static List<Patient> callGetPatientByIdAPI(String patientid)
	{
		Map<String, String> param = new HashMap<>();
		param.put("patientid",patientid );
		
		Patient[] result = restTemplate.getForObject(GET_PATIENT_BY_ID_API, Patient[].class, param);
		List<Patient> patient = Arrays.asList(result); 
		
		for(Patient p: patient)
		{
			System.out.println(p.getPatientid());
			System.out.println(p.getFirstname());
			System.out.println(p.getLastname());
			System.out.println(p.getGender());
			System.out.println(p.getPhone());
			System.out.println(p.getBirthday());
			System.out.println(p.getPincode());
			System.out.println(p.getScore());
			System.out.println(p.getScreening());
		}
		
		
		System.out.println(patient);
		
		return patient;
		//return patient.toString();
	
	}
	
	private static List<Patient> callGetPatientByFirstnameAPI(String firstname)
	{	
		Map<String, String> param = new HashMap<>();
		param.put("firstname",firstname );
		
		Patient[] result = restTemplate.getForObject(GET_PATIENT_BY_FIRSTNAME_API, Patient[].class, param);
		List<Patient> patient = Arrays.asList(result); 
		
		for(Patient p: patient)
		{
			System.out.println(p.getPatientid());
			System.out.println(p.getFirstname());
			System.out.println(p.getLastname());
			System.out.println(p.getGender());
			System.out.println(p.getPhone());
			System.out.println(p.getBirthday());
			System.out.println(p.getPincode());
			System.out.println(p.getScore());
			System.out.println(p.getScreening());
		}
		
		System.out.println(patient);
		return patient;
		//return patient.toString();
	}
	
	private static List<Patient> callGetPatientByLastnameAPI(String lastname)
	{
		Map<String, String> param = new HashMap<>();
		param.put("lastname",lastname );
		
		Patient[] result = restTemplate.getForObject(GET_PATIENT_BY_LASTNAME_API, Patient[].class, param);
		List<Patient> patient = Arrays.asList(result); 
		
		for(Patient p: patient)
		{
			System.out.println(p.getPatientid());
			System.out.println(p.getFirstname());
			System.out.println(p.getLastname());
			System.out.println(p.getGender());
			System.out.println(p.getPhone());
			System.out.println(p.getBirthday());
			System.out.println(p.getPincode());
			System.out.println(p.getScore());
			System.out.println(p.getScreening());
		}
		
		System.out.println(patient);
		return patient;
		
		//return patient.toString();
	}
	
	private static void callCreatePatientAPI(Patient patient)
	{
		 
		System.out.println(((Object)patient).getClass().getSimpleName());
		
		
		ResponseEntity<Patient> newPatient = restTemplate.postForEntity(CREATE_PATIENT_API, patient , Patient.class);
		
		System.out.println(newPatient);
	}
	
	private static void callUpdatePatientAPI(Score score, String patientid)
	{
		Map<String, String> param = new HashMap<String, String>();
		param.put("patientid",patientid);
		
		restTemplate.put(UPDATE_PATIENT_API, score, param);
		
	}
	
	

	@RequestMapping("/")
	public String home() 
	{
		return "index";
	}
	
	@RequestMapping("/index")
	public String homeback() 
	{
		return "index";
	}
	
	@RequestMapping("/about")
	public String about() 
	{
		return "about";
	}
	
	@RequestMapping("/contacts")
	public String contacts() 
	{
		return "contacts";
	}
	
	@RequestMapping("/registration")
	public String registrationpage() 
	{
		return "registration";
	}
	
	//Creating Patient through registration
	@RequestMapping(value="/register",method =RequestMethod.POST )
	public String addPatient(Patient patient,Model model)
	{		
		//Patient pat = new Patient();
		
		globalPatient=patient;
		
		String error_firstname="",error_lastname="",error_gender="",error_phone="";
		String error_dob="",error_pincode="",error_head="";
		String error_display_firstname="none",error_display_lastname="none";
		String error_display_gender="none";
		String error_display_phone="none",error_display_pincode="none",error_display_dob="none";
		String error_display_head="none";
	    int flag_error=0;
		
	    String patid=String.valueOf((long)(Math.random()*(99999999999999L-10000000000000L+1)+10000000000000L));
	    String firstname=patient.getFirstname();
	    String lastname=patient.getLastname();
	    String gender=patient.getGender();
	    String phone=patient.getPhone();
	    String birthday=patient.getBirthday();
	    String pincode=String.valueOf(patient.getPincode());
	    
	    System.out.println(patid);
	    System.out.println(firstname);
	    System.out.println(lastname);
	    System.out.println(gender);
	    System.out.println(phone);
	    System.out.println(birthday);
	    System.out.println(pincode);
	    
		if(firstname.isEmpty())
		{
            flag_error=1;
            System.out.println("1"+flag_error);
            error_display_firstname="block";
            error_firstname="Error: First Name is required";
            
            model.addAttribute("error_display_firstname",error_display_firstname);
            model.addAttribute("error_firstname",error_firstname);
            
            return "registration";
		}
             
        else
        {
            final_touch(firstname);
            if(firstname.isBlank())
            {
                flag_error=1;
                System.out.println("2"+flag_error);
                error_display_firstname="block";
                error_firstname="Error: First Name can't start with a SPACE";
                
                model.addAttribute("error_display_firstname",error_display_firstname);
                model.addAttribute("error_firstname",error_firstname);
                
                return "registration";
            }
        }
		
		if(lastname.isEmpty())
		{
            flag_error=1;
            System.out.println("3"+flag_error);
            error_display_lastname="block";
            error_lastname="Error: Last Name is required";
            
            model.addAttribute("error_display_lastname",error_display_lastname);
            model.addAttribute("error_lastname",error_lastname);
            
            return "registration";
		}     
        else
        {
            final_touch(lastname);
            if(lastname.isBlank())
            {
                flag_error=1;
                System.out.println("4"+flag_error);
                error_display_lastname="block";
                error_lastname="Error: Last Name can't start with a SPACE";
                
                model.addAttribute("error_display_lastname",error_display_lastname);
                model.addAttribute("error_lastname",error_lastname);
                
                return "registration";
            }
        }
		
		if(gender.isEmpty())
		{
			flag_error=1;
			System.out.println("5"+flag_error);
			error_display_gender="block";
			error_gender="Error: Select your gender";
					
		    model.addAttribute("error_display_gender",error_display_gender);
			model.addAttribute("error_gender",error_gender);
			
			
			return "registration";
			
		}
		else
		{
			gender = final_touch(gender);
		}
		
		if(phone.isEmpty())
		{
			flag_error=1;
			System.out.println("8"+flag_error);
			error_display_phone="block";
			error_phone="Error: Phone No. is required";
			
			model.addAttribute("error_display_phone",error_display_phone);
			model.addAttribute("error_phone",error_phone);
			
			return "registration";
		}
        else
        {
        	phone = final_touch(phone);
        	//System.out.println("----------------------------"+phone);
        	if(phone.length() <10)
        	{
        		flag_error=1;
        		System.out.println("9"+flag_error);
        		error_display_phone="block";
        		error_phone="Error: Phone No. must be 10 digits long";
        		
        		model.addAttribute("error_display_phone",error_display_phone);
        		model.addAttribute("error_phone",error_phone);
        		
        		return "registration";
        	}
        }
		 
		if(birthday.isEmpty())
		{
			flag_error=1;
			System.out.println("10"+flag_error);
			error_display_dob="block";
			error_dob="Error: Date fo Birth is required";
			
			model.addAttribute("error_display_dob",error_display_dob);
			model.addAttribute("error_dob",error_dob);
			
			return "registration";
		}
	    else 
	    {
	    	birthday = final_touch(birthday);
	    }
	    
		if(pincode.isEmpty())
		{
			flag_error=1;
			System.out.println("11"+flag_error);
			error_display_pincode="block";
			error_pincode="Error: Pincode. is required";
			
			model.addAttribute("error_display_pincode",error_display_pincode);
			model.addAttribute("error_pincode",error_pincode);
			
			return "registration";
		}
        else
        {
        	pincode = final_touch(pincode);
        	if(pincode.length()<6)
        	{
        		flag_error=1;
        		System.out.println("12"+flag_error);
        		error_display_pincode="block";
        		error_pincode="Error: Pincode. must be 10 digits long";
        		
        		model.addAttribute("error_display_pincode",error_display_pincode);
        		model.addAttribute("error_pincode",error_pincode);
        		
        		return "registration";
        	}
        }
            
		if(flag_error==0)
		{
			System.out.println("Overall 0"+flag_error);
			error_display_firstname="none";
			error_display_lastname="none";
			error_display_gender="none";
			error_display_phone="none";;
			error_display_pincode="none";
			error_display_dob="none";
			
			patient.setPatientid(patid);
			patient.setFirstname(firstname);
			patient.setLastname(lastname);
			patient.setGender(gender);
			patient.setPhone(phone);
			patient.setBirthday(birthday);
			patient.setPincode(Integer.parseInt(pincode));
			
			callCreatePatientAPI(patient);
			
			model.addAttribute("patient",patient);
			
		}
            
        if(flag_error==1)
        {
        	System.out.println("Overall 1"+flag_error);
        	error_display_head="block";
        	error_head="There are one or more errors in your form. Correct them and register again !";
        	
        	model.addAttribute("error_display_head",error_display_head);
        	model.addAttribute("error_head",error_head);
        	
        	return "registration";
        }
        
		return "checklist";
	}
	
	@RequestMapping("/checklist")
	public String ChecklistPage(Model model)
    {
        model.addAttribute("Score", new Score());
  
        return "checklist";
    }
	
	
	@RequestMapping(value="/submit")
	public String ChecklistPage(@ModelAttribute Patient patient,BindingResult result1,@ModelAttribute Score score,BindingResult result,Model model)
    {
		int age=score.getAge();
	    int smoke=score.getSmoke();
	    int alcohol=score.getAlcohol();
	    int waist=score.getWaist();
		int phy_act=score.getPhy_act();
		int fam_his=score.getFam_his();
		
		System.out.println(age);
		System.out.println(smoke);
		System.out.println(alcohol);
		System.out.println(waist);
		System.out.println(phy_act);
		System.out.println(fam_his);
		
		int total = score.getAge() + score.getSmoke() + score.getAlcohol() + score.getWaist() + score.getPhy_act() + score.getFam_his();
		//String screening = "";
		if (total > 4)
		{
			//screening ="Yes";
		    model.addAttribute("result","The person may be at higher risk of NCDs and needs to be prioritized for attending screening.");
		}
		else
		{
			//screening="No";
			model.addAttribute("result","The person is not at risk of NCDs and doesn't need screening.");
		}
		
		model.addAttribute("total_score",total);
		System.out.println("-------------------"+patient.getPatientid());
		System.out.println("-------------------"+globalPatient.getPatientid());
		callUpdatePatientAPI(score,globalPatient.getPatientid());
        model.addAttribute(globalPatient);
        return "result";
    }
	
	@RequestMapping("/searchpage")
	public String searchpage() 
	{
		return "search";
	}
	
	
	
	
	@RequestMapping("/alldata")
	public String viewAllData(Model model) 
	{
		List<Patient> patient = callGetAllPatientsAPI();
		System.out.println("This is inside all data function "+patient);
		System.out.println("records is of type "+patient.getClass());
		
		
		//System.out.println("This is inside all data function printing patient "+patients);
		
		
		model.addAttribute("records",patient);
		
		return "search";
	}
	
	
	
	
	
	@RequestMapping("/search")
	public String search(Patient patient,Search sp,Model model) 
	{
		String error_firstname="",error_lastname="",error_patient_id="";
		String error_display_firstname="none",error_display_lastname="none",error_display_patient_id="none";
		
		String inputvalue=sp.getPk();
	    String option=sp.getChoice();
		
		
		System.out.println("search input value :"+sp.getPk());
        System.out.println("drop downlist  value :"+sp.getChoice());
	
        if("PATIENT ID".equals(option))
    	{
    		if(inputvalue.isEmpty())
    		{
    			error_display_patient_id="block";
    			error_patient_id="Error: Patient ID is required";
    			
    			model.addAttribute("error_display_patient_id",error_display_patient_id);
                model.addAttribute("error_patient_id",error_patient_id);
    		
    		}
    		else
    		{
    			final_touch(inputvalue);
    			if(inputvalue.isBlank())
    			{
    				error_display_patient_id="block";
        			error_patient_id="Error: Patient ID doesn't start with a SPACE";
        			
        			model.addAttribute("error_patient_id",error_display_patient_id);
                    model.addAttribute("error_patient_id",error_patient_id);
    			}
    			else if(inputvalue.length()<14)
    			{
    				error_display_patient_id="block";
        			error_patient_id="Error: Patient ID must be less than 14 digits";
        			
        			model.addAttribute("error_display_patient_id",error_display_patient_id);
                    model.addAttribute("error_patient_id",error_patient_id);
    			}
    			else
    			{
    				inputvalue=final_touch(inputvalue);
    				if(inputvalue.matches("-?\\d+(\\.\\d+)?"))
    				{
    					
    					try
    					{
    						List<Patient> records=callGetPatientByIdAPI(inputvalue);
    						model.addAttribute("records",records);
    						
    					}
    						
    					catch(Exception e) 
    					{
    						System.out.println(e.toString());
    						
    						error_display_patient_id="block";
	            			error_patient_id="Error: Patient ID is not present in the database.";
	            			
	            			model.addAttribute("error_display_patient_id",error_display_patient_id);
	                        model.addAttribute("error_patient_id",error_patient_id);
    					}
    						
		        			
    				}
    				else 
    				{
    					error_display_patient_id="block";
            			error_patient_id="Error: Enter digits only";
            			
            			model.addAttribute("error_display_patient_id",error_display_patient_id);
                        model.addAttribute("error_patient_id",error_patient_id);
    				}
    			}
    		}
    		
    	}
       
        if("FIRST NAME".equals(option))
    	{
    		inputvalue = StringUtils.capitalize(inputvalue);
    		if(inputvalue.isEmpty())
    		{
    			error_display_firstname="block";
    			error_firstname="Error: First Name is required";
    			
    			model.addAttribute("error_display_firstname",error_display_firstname);
                model.addAttribute("error_firstname",error_firstname);
    		
    		}
    		else
    		{
    			final_touch(inputvalue);
    			if(inputvalue.isBlank())
    			{
    				error_display_firstname="block";
        			error_firstname="Error: First Name doesn't start with a SPACE";
        			
        			model.addAttribute("error_display_firstname",error_display_firstname);
                    model.addAttribute("error_firstname",error_firstname);
    			}
    			else
    			{
    				inputvalue = final_touch(inputvalue);
    				if(inputvalue.matches("^[a-zA-Z\\s]+$"))
    				{
    					
    					try
    					{
    						List<Patient> records=callGetPatientByFirstnameAPI(inputvalue);
    						model.addAttribute("records",records);
    					}
    					
    					catch(Exception e)
    					{
    						System.out.println(e.toString());
    						
    	        			error_display_firstname="block";
                			error_firstname="Error: First Name is not present in the database.";
                			
                			model.addAttribute("error_display_firstname",error_display_firstname);
                			model.addAttribute("error_firstname",error_firstname);
    					}  		
    				}
    				else
    				{
    					error_display_firstname="block";
            			error_firstname="Error: Enter alphabets only.";
            			
            			model.addAttribute("error_display_firstname",error_display_firstname);
                        model.addAttribute("error_firstname",error_firstname);
    				}
    			}
    		}
    	}
        
        if("LAST NAME".equals(option))
    	{
    		inputvalue = StringUtils.capitalize(inputvalue);
    		if(inputvalue.isEmpty())
    		{
    			error_display_firstname="block";
    			error_firstname="Error: Last Name is required";
    			
    			model.addAttribute("error_display_lastname",error_display_lastname);
                model.addAttribute("error_lastname",error_lastname);
    		
    		}
    		else
    		{
    			final_touch(inputvalue);
    			if(inputvalue.isBlank())
    			{
    				error_display_lastname="block";
        			error_lastname="Error: Last Name doesn't start with a SPACE";
        			
        			model.addAttribute("error_display_lastname",error_display_lastname);
                    model.addAttribute("error_lastname",error_lastname);
    			}
    			else
    			{
    				inputvalue = final_touch(inputvalue);
    				if(inputvalue.matches("^[a-zA-Z\\s]+$"))
    				{
    					
    					try
    					{
    						List<Patient> records = callGetPatientByLastnameAPI(inputvalue);
    						model.addAttribute("records",records);
    					}
    					
    					catch(Exception e)
    					{
    						System.out.println(e.toString());
    						
    						error_display_lastname="block";
                			error_lastname="Error: Last Name is not present in the database.";
                			
                			model.addAttribute("error_display_lastname",error_display_lastname);
                            model.addAttribute("error_lastname",error_lastname);
    					}
    	        		
    				}
    				else
    				{
    					error_display_lastname="block";
            			error_lastname="Error: Enter alphabets only";
            			
            			model.addAttribute("error_display_lastname",error_display_lastname);
                        model.addAttribute("error_lastname",error_lastname);
    				}
    			}
    		}
    	}
        
		return "search";
	}
	
	@RequestMapping("/hidedata")
	public String hidedata()
	{
		return "search";
	}
	
	@Controller
	public class MyErrorController implements ErrorController  {

		@RequestMapping("/error")
		public String handleError(HttpServletRequest request) {
		    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		    
		    if (status != null) {
		        Integer statusCode = Integer.valueOf(status.toString());
		    
		        if(statusCode == HttpStatus.NOT_FOUND.value()) {
		            return "404";
		        }
		        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
		            return "500";
		        }
		    }
		    return "error";
		}
	}

	public String final_touch(String field)
	{
	    String field1,field2,field3;
		field1 = field.strip();
	    field2 = field1.replace("\\", "");
	    field3 = field2.replace("<.*?\\>", "");
	    return field3;
	}
	
}


















//private static void callGetPatientByFirstnameAPI()
//{	
//	HttpHeaders headers = new HttpHeaders();
//	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	
//	Map<String, String> param = new HashMap<>();
//	param.put("firstname","Ankita" );
//	
//	HttpEntity<Map<String, String>> entity = new HttpEntity<>("firstname",headers);
//	
//	ResponseEntity<Patient> patient  = restTemplate.exchange(GET_PATIENT_BY_FIRSTNAME_API, HttpMethod.GET, entity, Patient.class);
//
//	System.out.println(patient);
	
	
	//Patient patient = restTemplate.getForObject(GET_PATIENT_BY_FIRSTNAME_API, Patient.class, param);
	
//	System.out.println(patient.getPatientid());
//	System.out.println(patient.getFirstname());
//	System.out.println(patient.getLastname());
//	System.out.println(patient.getGender());
//	System.out.println(patient.getPhone());
//	System.out.println(patient.getBirthday());
//	System.out.println(patient.getPincode());
//	System.out.println(patient.getScore());
//	System.out.println(patient.getScreening());

//}


//private static void callGetPatientByFirstnameAPI()
//{	
//	String queryParam = "Ankita";
//	URI uri = UriComponentsBuilder
//	        .fromUri(URI.create(GET_PATIENT_BY_FIRSTNAME_API))
//	        .queryParam(queryParam)
//	        .build()
//	        .toUri();
//
//	 Patient patient= restTemplate.exchange(uri , HttpMethod.GET, null, Patient.class).getBody();
//	 
//	 System.out.println(patient);
//}
