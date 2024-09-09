package enums;

public enum ServicePlan {
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);
	
	private double servicePlanCost;
	
	private ServicePlan(int servicePlanCost) {
		this.servicePlanCost = servicePlanCost;
	}
	
	public double getServicePlanCost() {
		return servicePlanCost;
	}
	
	@Override
	public String toString() {
		return this.name();
	}
}