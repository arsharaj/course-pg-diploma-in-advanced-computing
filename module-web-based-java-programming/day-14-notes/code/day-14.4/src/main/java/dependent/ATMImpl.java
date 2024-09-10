package dependent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dependency.Transport;
//singleton n eager
@Component("my_atm")
public class ATMImpl implements ATM {
	//field level annotation
	//dep : soap layer 
	@Autowired
	@Qualifier("soapTransport")//byName
	private Transport myTransport;
	//Transport myTransport=new SoapTranport();

	public ATMImpl() {
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj is calling dependency's method to inform the bank
	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}
		// custom init method
	@PostConstruct
	public void myInit() {
		System.out.println("in init " + myTransport);// not null
	}

	// custom destroy method
	@PreDestroy
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}

}
