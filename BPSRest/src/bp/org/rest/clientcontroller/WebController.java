package bp.org.rest.clientcontroller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import bp.org.rest.request.BPRestInput;
import bp.org.rest.response.Bp;


//  http://localhost:8080/BPSRest/api/BPLoad/Get
// http://localhost:8080/BPSRest/api/BPLoad/Post

@Path("/BPLoad")
public class WebController {
	
	@POST
	    @Path("/Post/")
	    @Produces("application/xml")
	    public Bp getBPLoadXML(BPRestInput bpRestInput){
	    	System.out.println("in the WebController GET");
	    	Bp bp = new Bp();
	    	bp.setAmount(20);
	    	bp.setFirstName("Nivi Using post");
	       	bp.setTransactionReference(bpRestInput.getTransactionRef());
	       	bp.setTrasactionNumber(bpRestInput.getTransactionNumber());
	        return bp;
	    }
	    
	    @GET
	    @Path("/Get/")
	    @Produces("application/xml")
	    public Bp getBPLoadXML(){
	    	System.out.println("in the WebController GET");
	    	Bp bp = new Bp();
	    	bp.setAmount(100);
	    	bp.setFirstName("Nivi");
	      	return bp;
	    }

	 
		
}
