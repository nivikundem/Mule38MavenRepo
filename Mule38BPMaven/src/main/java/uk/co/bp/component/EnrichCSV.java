package uk.co.bp.component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;




import uk.co.bp.bean.BPCSVPojo;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;

public class EnrichCSV implements Callable {


	

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {		
		
		BPCSVPojo bp = eventContext.getMessage().getProperty("bp", PropertyScope.SESSION);			
		BPCSVPojo bpUpdated = new BPCSVPojo();
		
		
		
		bpUpdated.setAmount(bp.getAmount()+100);
		bpUpdated.setFirstName(bp.getFirstName());
		bpUpdated.setLastName(bp.getLastName());
		bpUpdated.setTransactionRef(bp.getTransactionRef());
		bpUpdated.setTransactionType(bp.getTransactionType());
		bpUpdated.setTransactionNumber(bp.getTransactionNumber());			
			
		
	
    	return bpUpdated;
	}
	
	/*@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {		
		
		List<BPCSVPojo> bpList = eventContext.getMessage().getProperty("bpList", PropertyScope.SESSION);			
		List<BPCSVPojo> bpUpdatedList = new ArrayList<BPCSVPojo>();
		
		
		for(BPCSVPojo bp : bpList){			
			
			BPCSVPojo cp = new BPCSVPojo();	
			cp.setAmount(bp.getAmount()+100);
			cp.setFirstName(bp.getFirstName());
			cp.setLastName(bp.getLastName());
			cp.setTransactionRef(bp.getTransactionRef());
			cp.setTransactionType(bp.getTransactionType());
			cp.setTransactionNumber(bp.getTransactionNumber());			
			
			bpUpdatedList.add(cp);
			
		}		
		
		return bpUpdatedList;
	}*/

/*	private List<VRMResponsePojo> getVRMDetails(ArrayList<String> regList, URL wsdlURL) {
		 //  URL wsdlURL = IEnquiryService.WSDL_LOCATION;
	        IEnquiryService ss = new IEnquiryService(wsdlURL, SERVICE_NAME);
	        IEnquiry port = ss.getIEnquiryPort();  
	        
	        List<VRMResponsePojo>  vrmResList =  new ArrayList<VRMResponsePojo>();
	        VRMResponsePojo vrmRes = new VRMResponsePojo();
    	   
    	   vrmRes =   getVrmResHeader();    		       
	       vrmResList.add(vrmRes);
	        
	        {
	   
	        equityesbenquiry.equity.co.uk.EnquiryRequest _enquire_parameters = new equityesbenquiry.equity.co.uk.EnquiryRequest();
	        for(String registrationNum : regList){	
	        	
	        	System.out.println("before : "+registrationNum);
	        	if(registrationNum != null){
	        		registrationNum = registrationNum.replaceAll("\\s+","").replaceAll("\\-","" );;
	        		System.out.println("after : "+registrationNum);
		          _enquire_parameters.setVehicleRegistration(registrationNum);
		          equityesbenquiry.equity.co.uk.EnquiryResponse res = port.enquire(_enquire_parameters);		     
	
		          System.out.println("response:  "+res.getWarningType().getResponse());
		          
		          List<TranslatePlusType>  tptList = new ArrayList<TranslatePlusType>();;
		         // if(("SUCCESS").equalsIgnoreCase(res.getWarningType().getResponse())){
		        	  
		        	  if(res.getRequestResults() != null   && res.getRequestResults().getAsset() != null && res.getRequestResults().getAsset().getPrimaryAssetData() != null){
		       
				         tptList =  res.getRequestResults().getAsset().getPrimaryAssetData().getTranslatePlus();
				        
		        	  }  
				        
		          if(res.getRequestResults() != null) {
		        	      if(res.getRequestResults().getAsset() != null && res.getRequestResults().getAsset().getPrimaryAssetData() != null){
		        	    	  tptList =  res.getRequestResults().getAsset().getPrimaryAssetData().getTranslatePlus();
		        	    	  
		        	      }
		        	  
		        	  
				        	  vrmRes = new VRMResponsePojo();
					    	   
					    	   vrmRes.setRegistration(registrationNum);    
						    	      
						       if(tptList.size()>0){
							       for(TranslatePlusType tpt : tptList){				
							    	   
							    	  if(tpt.getInstep() != null){				  
							    	   vrmRes.setCode(tpt.getInstep().getCode());
							    	
							    	   
							  		 vrmRes.setMatchLevel(Byte.toString(tpt.getInstep().getMatchLevel()));
									 vrmRes.setMakeDescription(tpt.getInstep().getMakeDescription());
									 vrmRes.setModelDescription(tpt.getInstep().getModelDescription());
									 vrmRes.setNumberofDoors(Byte.toString(tpt.getInstep().getNumberOfDoors()));
									 vrmRes.setEngineSize(String.valueOf(tpt.getInstep().getEngineSize()));
									 vrmRes.setBodyCode(tpt.getInstep().getBody().getCode());
									 vrmRes.setBodyDescription(tpt.getInstep().getBody().getDescription());
									 vrmRes.setFuelCode(tpt.getInstep().getFuel().getCode());
									 vrmRes.setFuelDescription(tpt.getInstep().getFuel().getDescription());
									 vrmRes.setTransmissionCode(tpt.getInstep().getTransmission().getCode());
									 vrmRes.setTransmissionCode(tpt.getInstep().getTransmission().getDescription());
									 vrmRes.setVersion(Byte.toString(tpt.getInstep().getVersion()));
									 vrmRes.setManufacturedStartYear(String.valueOf(tpt.getInstep().getManufactured().getStartYear()));
									 vrmRes.setManufacturedEndYear(Byte.toString(tpt.getInstep().getManufactured().getEndYear()));
									 
							    	  }
									 vrmRes.setInsuranceGroup(Byte.toString(tpt.getInsuranceGroup()));
							    	 vrmRes.setInsuranceGroupSuffix(tpt.getInsuranceGroupSuffix());
									 vrmRes.setSecurityCode(tpt.getSecurityCode());
							         }
								 
						       }
								 vrmRes.setAssetIdentificationVRM(res.getRequestResults().getAsset().getAssetIdentification().getVrm());
								 vrmRes.setAssetIdentificationVIN(res.getRequestResults().getAsset().getAssetIdentification().getVin());
								 vrmRes.setAssetIdentificationMileage(res.getRequestResults().getAsset().getAssetIdentification().getReference());
								 
								
								 
								 if(res.getRequestResults().getAsset() != null  && res.getRequestResults().getAsset().getPrimaryAssetData() != null && res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA() != null){		
										 
										 if(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getMake() != null){						 
											 vrmRes.setdVLAMakeCode(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getMake().getCode());
											 vrmRes.setdVLAMakeDescription(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getMake().getDescription());
										 }
										 
										 if(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getModel() != null){
										 vrmRes.setdVLAModelCode(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getModel().getCode());
										 vrmRes.setdVLAModelDescription(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getModel().getDescription());
						                 }    
						          
						          
						          		 if(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody() != null){			
										 vrmRes.setdVLABodyCode(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getCode());
										 vrmRes.setdVLABodyDescription(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getDescription());
										 
										 if(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getColour() != null){			
										 vrmRes.setdVLABodyColourNumberPreviousColours(Byte.toString(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getColour().getNumberPreviousColours()));
										 vrmRes.setdVLABodyColourCurrentCode(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getColour().getCurrent().getCode());
										 vrmRes.setdVLABodyColourCurrentDescription(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getColour().getCurrent().getDescription());
										 vrmRes.setdVLABodyColourCurrentDateChanged(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getColour().getCurrent().getDateChanged());
										 vrmRes.setdVLABodyColourPrevious(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getColour().getPrevious());
										 vrmRes.setdVLABodyColourOriginal(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getColour().getOriginal());
										 }
										 
										 if(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getWheelPlan() != null){			
										 vrmRes.setdVLABodyWheelPlanCode(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getWheelPlan().getCode());
										 vrmRes.setdVLABodyWheelplanDescription(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getWheelPlan().getDescription());
										 }
										 
										 if(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getWeight() != null){
										 vrmRes.setdVLABodyWeight(Byte.toString(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getBody().getWeight()));
						          		 }
						          		 }
										 
				
										 
										 
						          		 if(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getEngine() != null){
						          			
											 vrmRes.setdVLAEngineSize(String.valueOf(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getEngine().getSize()));
						          			
											 if(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getEngine().getNumber() != null){
											 vrmRes.setdVLAEngineNumber(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getEngine().getNumber());
											 }
											 if(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getEngine().getFuel() != null){
											 vrmRes.setdVLAEngineFuelCode(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getEngine().getFuel().getCode());
											 vrmRes.setdVLAEngineFuelDescription(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getEngine().getFuel().getDescription());
											 }
						          		  }
										 
										 vrmRes.setdVLAKeepers(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getKeepers());	
										 vrmRes.setdVLAKeydatesFirstRegisteredDate(getXMLToString(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getKeyDates().getFirstRegistered().getDate()));
										 vrmRes.setdVLAKeydatesFirstRegisteredVinVrmIndicatorCode(Byte.toString(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getKeyDates().getFirstRegistered().getVinVrmIndicator().getCode()));
										 vrmRes.setdVLAKeydatesFirstRegisteredVinVrmIndicatorDescription(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getKeyDates().getFirstRegistered().getVinVrmIndicator().getDescription());
										 vrmRes.setdVLAKeydatesManufacturedYear(String.valueOf(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getKeyDates().getManufactured().getYear()));
										 vrmRes.setdVLAKeydatesScrapped(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getKeyDates().getScrapped());
										 vrmRes.setdVLAKeydatesExported(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getKeyDates().getExported());
										 vrmRes.setdVLAKeydatesIsImported(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getKeyDates().getIsImported());
										 vrmRes.setdVLAIsFromNorthernIreland(res.getRequestResults().getAsset().getPrimaryAssetData().getDVLA().getIsFromNorthernIreland());
										 if(res.getRequestResults().getAsset().getPrimaryAssetData().getSMMT().getMake() != null){
										 vrmRes.setsMMTMakeCode(res.getRequestResults().getAsset().getPrimaryAssetData().getSMMT().getMake().getCode());
										 vrmRes.setsMMTMakeDescription(res.getRequestResults().getAsset().getPrimaryAssetData().getSMMT().getMake().getDescription());
										 }
										 
										 if(res.getRequestResults().getAsset().getPrimaryAssetData().getSMMT().getModel() != null){
										 vrmRes.setsMMTModelCode(res.getRequestResults().getAsset().getPrimaryAssetData().getSMMT().getModel().getCode());
										 vrmRes.setsMMTModelDescription(res.getRequestResults().getAsset().getPrimaryAssetData().getSMMT().getModel().getDescription());
										 }
										 if(res.getRequestResults().getAsset().getPrimaryAssetData().getSMMT().getBody() != null){
										 vrmRes.setsMMTBodyCode(res.getRequestResults().getAsset().getPrimaryAssetData().getSMMT().getBody().getCode());
										 vrmRes.setsMMTBodyDescription(res.getRequestResults().getAsset().getPrimaryAssetData().getSMMT().getBody().getDescription());
										 }
										 if(res.getRequestResults().getAsset().getPrimaryAssetData().getSMMT().getTransmission() != null){
										 vrmRes.setsMMTTransmissionCode(res.getRequestResults().getAsset().getPrimaryAssetData().getSMMT().getTransmission().getCode());
										 vrmRes.setsMMTTransmissionDescription(res.getRequestResults().getAsset().getPrimaryAssetData().getSMMT().getTransmission().getDescription());
										 }
										 
										 vrmRes.setCrossReference(res.getRequestResults().getAsset().getPrimaryAssetData().getCrossReference());
										 vrmRes.setcO2Rating(String.valueOf(res.getRequestResults().getAsset().getPrimaryAssetData().getAdditionalInformation().getCO2Rating()));
										 vrmRes.setPlateTransferindicator(res.getRequestResults().getAsset().getPrimaryAssetData().getAdditionalInformation().getPlateTransferIndicator());
								    	   
						    	   
						    	       	   
								 }
						    	   
						    	   vrmResList.add(vrmRes);
						    	   
								
						    
				              }
		          
	        	        }
				        
			        }
			        }
	       // }

	       
	        return vrmResList;
		
	}

	private String getXMLToString(XMLGregorianCalendar xmlDate) {
		Date date;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate ; 
		
		 if(xmlDate == null) {
	            return null;
	       }
		 else{
			 date = xmlDate.toGregorianCalendar().getTime();
			 strDate = sdf.format(date);
		 }
		
		
		return strDate;
	}

	private VRMResponsePojo getVrmResHeader() {
		 VRMResponsePojo vrmRes = new VRMResponsePojo();
		 vrmRes.setRegistration("RegistrationNumber");
		 vrmRes.setCode("Code");
		 vrmRes.setMatchLevel("MatchLevel");
		 vrmRes.setMakeDescription("MakeDescription");
		 vrmRes.setModelDescription("ModelDescription");
		 vrmRes.setNumberofDoors("NumberofDoors");
		 vrmRes.setEngineSize("EngineSize");
		 vrmRes.setBodyCode("Body_Code");
		 vrmRes.setBodyDescription("Body_Description");
		 vrmRes.setFuelCode("Fuel_Code");
		 vrmRes.setFuelDescription("Fuel_Description");
		 vrmRes.setTransmissionCode("Transmission_Code");
		 vrmRes.setTransmissionCode("Transmission_Description");
		 vrmRes.setVersion("Version");
		 vrmRes.setManufacturedStartYear("Manufactured_StartYear");
		 vrmRes.setManufacturedEndYear("Manufactured_EndYear");
		 vrmRes.setInsuranceGroup("InsuranceGroup");
		 vrmRes.setInsuranceGroupSuffix("InsuranceGroupSuffix");
		 vrmRes.setSecurityCode("SecurityCode");
		 vrmRes.setAssetIdentificationVRM("AssetIdentification_VRM");
		 vrmRes.setAssetIdentificationVIN("AssetIdentification_VIN");
		 vrmRes.setAssetIdentificationMileage("AssetIdentification_Mileage");
		 vrmRes.setdVLAMakeCode("DVLA_Make_Code");
		 vrmRes.setdVLAMakeDescription("DVLA_Make_Description");
		 vrmRes.setdVLAModelCode("DVLA_Model_Code");
		 vrmRes.setdVLAModelDescription("DVLA_Model_Description");
		 vrmRes.setdVLABodyCode("DVLA_Body_Code");
		 vrmRes.setdVLABodyDescription("DVLA_Body_Description");
		 vrmRes.setdVLABodyColourNumberPreviousColours("DVLA_Body_Colour_NumberPreviousColours");
		 vrmRes.setdVLABodyColourCurrentCode("DVLA_Body_Colour_Current_Code");
		 vrmRes.setdVLABodyColourCurrentDescription("DVLA_Body_Colour_Current_Description");
		 vrmRes.setdVLABodyColourCurrentDateChanged("DVLA_Body_Colour_Current_DateChanged");
		 vrmRes.setdVLABodyColourPrevious("DVLA_Body_Colour_Previous");
		 vrmRes.setdVLABodyColourOriginal("DVLA_Body_Colour_Original");
		 vrmRes.setdVLABodyWheelPlanCode("DVLA_Body_WheelPlan_Code");
		 vrmRes.setdVLABodyWheelplanDescription("DVLA_Body_Wheelplan_Description");
		 vrmRes.setdVLABodyWeight("DVLA_Body_Weight");
		 vrmRes.setdVLAEngineSize("DVLA_Engine_Size");
		 vrmRes.setdVLAEngineNumber("DVLA_Engine_Number");
		 vrmRes.setdVLAEngineFuelCode("DVLA_Engine_Fuel_Code");
		 vrmRes.setdVLAEngineFuelDescription("DVLA_Engine_Fuel_Description");
		 vrmRes.setdVLAKeepers("DVLA_Keepers");
		 vrmRes.setdVLAKeydatesFirstRegisteredDate("DVLA_Keydates_FirstRegistered_Date");
		 vrmRes.setdVLAKeydatesFirstRegisteredVinVrmIndicatorCode("DVLA_Keydates_FirstRegistered_VinVrmIndicator_Code");
		 vrmRes.setdVLAKeydatesFirstRegisteredVinVrmIndicatorDescription("DVLA_Keydates_FirstRegistered_VinVrmIndicator_Description");
		 vrmRes.setdVLAKeydatesManufacturedYear("DVLA_Keydates_Manufactured_Year");
		 vrmRes.setdVLAKeydatesScrapped("DVLA_Keydates_Scrapped");
		 vrmRes.setdVLAKeydatesExported("DVLA_Keydates_Exported");
		 vrmRes.setdVLAKeydatesIsImported("DVLA_Keydates_IsImported");
		 vrmRes.setdVLAIsFromNorthernIreland("DVLA_IsFromNorthernIreland");
		 vrmRes.setsMMTMakeCode("SMMT_Make_Code");
		 vrmRes.setsMMTMakeDescription("SMMT_Make_Description");
		 vrmRes.setsMMTModelCode("SMMT_Model_Code");
		 vrmRes.setsMMTModelDescription("SMMT_Model_Description");
		 vrmRes.setsMMTBodyCode("SMMT_Body_Code");
		 vrmRes.setsMMTBodyDescription("SMMT_Body_Description");
		 vrmRes.setsMMTTransmissionCode("SMMT_Transmission_Code");
		 vrmRes.setsMMTTransmissionDescription("SMMT_Transmission_Description");
		 vrmRes.setCrossReference("CrossReference");
		 vrmRes.setcO2Rating("CO2Rating");
		 vrmRes.setPlateTransferindicator("PlateTransferindicator");


		 
		 
		 return vrmRes;
	}

	*/
	
}
