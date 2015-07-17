package jsf_module;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloWorld2", eager = true)
public class HelloController {
	public HelloController() {
	      System.out.println("HelloWorld started!");
   }
	
   public String getMessage() {
      return "Hello World2222!";
   }
}
