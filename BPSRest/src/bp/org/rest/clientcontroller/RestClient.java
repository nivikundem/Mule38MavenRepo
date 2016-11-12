package bp.org.rest.clientcontroller;


import javax.ws.rs.core.MediaType;

import bp.org.rest.request.BPRestInput;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;


// http://localhost:8080/BPSRest/api/BPLoad/Get

public class RestClient {

  public static void main(String[] args) {
	  try {

			Client client = Client.create();		
			
			//WebResource webResource = client.resource("http://localhost:8080/BPSRest/api/BPLoad/Get");		
			WebResource webResource = client.resource("http://localhost:8080/BPSRest/api/BPLoad/Post");		
			
			BPRestInput bpReq = new BPRestInput();
			bpReq.setTransactionNumber("abc");			
			bpReq.setTransactionRef("def");					
		
			ClientResponse response = webResource.type("application/xml").post(ClientResponse.class, bpReq);
		//	ClientResponse response = webResource.type("application/xml").post(ClientResponse.class);

				
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			
			
			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		  } catch (Exception e) {
			e.printStackTrace();
		  }
  }
} 