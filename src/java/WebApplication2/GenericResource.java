
package WebApplication2;


import javax.json.JsonArray;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;


@Path("cegepgim")
public class GenericResource {

    @Context
    private UriInfo context;

    public GenericResource() {
    }

    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    
    @GET
    @Path("method1")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText1() {
        
        
        JSONArray mainArr = new JSONArray();
        JSONObject singleObj = new JSONObject();
        singleObj.accumulate("Name" , "Circle");
        singleObj.accumulate("NumberOfPara", "1");
        mainArr.add(singleObj);
        singleObj.clear();
        singleObj.accumulate("Name" , "Tringle");
        singleObj.accumulate("NumberOfPara", "2");
        mainArr.add(singleObj);
        singleObj.clear();
        singleObj.accumulate("Name" , "Square");
        singleObj.accumulate("NumberOfPara", "1");
        mainArr.add(singleObj);
        singleObj.clear();
        singleObj.accumulate("Name" , "Rectangle");
        singleObj.accumulate("NumberOfPara", "2");
        mainArr.add(singleObj);
        singleObj.clear();
        singleObj.accumulate("Name" , "Parallagrom");
        singleObj.accumulate("NumberOfPara", "2");
        mainArr.add(singleObj);
        singleObj.clear();
        singleObj.accumulate("Name" , "Trapezoid");
        singleObj.accumulate("NumberOfPara", "3");
        mainArr.add(singleObj);
        singleObj.clear();
        singleObj.accumulate("Name" , "Ecillipse");
        singleObj.accumulate("NumberOfPara", "2");
        mainArr.add(singleObj);
        singleObj.clear();
        singleObj.accumulate("Name" , "Sector");
        singleObj.accumulate("NumberOfPara", "1");
        mainArr.add(singleObj);
        singleObj.clear();
        
        return mainArr.toString();
    }
    
     @GET
    @Path("method2&{shapeName}&{value1}&{value2}&{value3}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText2(@PathParam("shapeName")String ShapeName,@PathParam("value1")int a, @PathParam("value2")int b,@PathParam("value3")int c) {
        
        
       JSONObject singleObj = new JSONObject();
       if(ShapeName.equals("Trapezoid")){
       
       singleObj.accumulate("Status","OK");
       singleObj.accumulate("TimeStamp", System.currentTimeMillis()/1000);
       singleObj.accumulate("Shape", ShapeName);
       singleObj.accumulate("base1", a);
       singleObj.accumulate("base2", b);
       singleObj.accumulate("Height", c);
       singleObj.accumulate("Area",0.5*(a+b)*c);
           
           
       }else{
        singleObj.accumulate("Status","Error");
       singleObj.accumulate("TimeStamp", System.currentTimeMillis()/1000);
       singleObj.accumulate("Shape", ShapeName);
       singleObj.accumulate("Message","Not Found");
       
       }
       
        return singleObj.toString();
    }
    @GET
    @Path("method3&{shapeName}&{value1}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText3(@PathParam("shapeName")String ShapeName,@PathParam("value1")int a) {
        
        
       JSONObject singleObj = new JSONObject();
       if(ShapeName.equals("Square")){
       
       singleObj.accumulate("Status","OK");
       singleObj.accumulate("TimeStamp", System.currentTimeMillis()/1000);
       singleObj.accumulate("Shape", ShapeName);
       singleObj.accumulate("base", a*a);
       }
       
      else if(ShapeName.equals("Circle")){
       singleObj.accumulate("Status","OK");
       singleObj.accumulate("TimeStamp", System.currentTimeMillis()/1000);
       singleObj.accumulate("Shape", ShapeName);
       singleObj.accumulate("base", 3.14*(a*a));
       
      }else{
        singleObj.accumulate("Status","Error");
       singleObj.accumulate("TimeStamp", System.currentTimeMillis()/1000);
       singleObj.accumulate("Shape", ShapeName);
       singleObj.accumulate("Message","Not Found");
       
       }
       
        return singleObj.toString();
    }
   
    @GET
    @Path("method4&{shapeName}&{value1}&{value2}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText4(@PathParam("shapeName")String ShapeName,@PathParam("value1")int a,@PathParam("value2")int b) {
        
        
       JSONObject singleObj = new JSONObject();
       if(ShapeName.equals("Tringle")){
       
       singleObj.accumulate("Status","OK");
       singleObj.accumulate("TimeStamp", System.currentTimeMillis()/1000);
       singleObj.accumulate("Shape", ShapeName);
       singleObj.accumulate("base", a);
       singleObj.accumulate("Height", b);
       singleObj.accumulate("Area", 0.5*a*b);
       }
       
      else if(ShapeName.equals("Rectangle")){
       singleObj.accumulate("Status","OK");
       singleObj.accumulate("TimeStamp", System.currentTimeMillis()/1000);
       singleObj.accumulate("Shape", ShapeName);
       singleObj.accumulate("base", a);
       singleObj.accumulate("Height", b);
       singleObj.accumulate("Area", a*b);
       
      }
       else if(ShapeName.equals("Ellipse")){
       singleObj.accumulate("Status","OK");
       singleObj.accumulate("TimeStamp", System.currentTimeMillis()/1000);
       singleObj.accumulate("Shape", ShapeName);
         singleObj.accumulate("base", a);
       singleObj.accumulate("Height", b);
       singleObj.accumulate("ARea", 3.14*(a*b));
       
      }
       else if(ShapeName.equals("Parallelogram")){
       singleObj.accumulate("Status","OK");
       singleObj.accumulate("TimeStamp", System.currentTimeMillis()/1000);
       singleObj.accumulate("Shape", ShapeName);  
       singleObj.accumulate("base", a);
       singleObj.accumulate("Height", b);
     
       singleObj.accumulate("Area", a*b);
       
      }
       else if(ShapeName.equals("Sector")){
       singleObj.accumulate("Status","OK");
       singleObj.accumulate("TimeStamp", System.currentTimeMillis()/1000);
       singleObj.accumulate("Shape", ShapeName);  
       singleObj.accumulate("base", a);
       singleObj.accumulate("Height", b);
     
       singleObj.accumulate("Area", 0.5*(a*a)*10);
       
      }
      else{
        singleObj.accumulate("Status","Error");
       singleObj.accumulate("TimeStamp", System.currentTimeMillis()/1000);
       singleObj.accumulate("Shape", ShapeName);
       singleObj.accumulate("Message","Not Found");
       
       }
       
        return singleObj.toString();
    }
    
}
