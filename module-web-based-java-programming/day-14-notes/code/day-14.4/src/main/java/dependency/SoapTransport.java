package dependency;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//prototype , simple spring bean , derived bean id
@Component
@Scope("prototype")
public class SoapTransport implements Transport {
	public SoapTransport() {
		System.out.println("in cnstr of " +getClass().getName());
	}

	@Override
	public void informBank(byte[] data) {
		System.out.println("informing bank using " + getClass().getName() + " layer");

	}

}
