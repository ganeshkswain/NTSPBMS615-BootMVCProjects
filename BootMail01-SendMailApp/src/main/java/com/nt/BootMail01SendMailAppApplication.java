package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.nt.service.IPurchaseOrder;

@SpringBootApplication
public class BootMail01SendMailAppApplication {

	public static void main(String[] args) {
		// get IOC Container
		ConfigurableApplicationContext ctx = SpringApplication.run(BootMail01SendMailAppApplication.class, args);
		//get service class object reference
		IPurchaseOrder order=ctx.getBean("purchaseService",IPurchaseOrder.class);
		//invoke method
		try {
			String msg=order.purchase(new String[] {"shirt","trouser","watch"},new Double[] {5000.0,6000.0,7000.0},
					new String[] {"ganeshkswain@gmail.com","swaintch@gmail.com","pradhanbadal4@gmail.com"});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		ctx.close();
	}

}
