package modelo;

public class SavingsAccount extends Account {

	//por defecto se dejo en 10 como porcentaje de ganancia por cada deposito
	private double interestPercentage = 10; 
	
	public SavingsAccount(int a) {
		super(a);
	}
	
	public double getInterest() {
		return interestPercentage;
	}

	public void setInterest(double interestPercentage) {
		this.interestPercentage = interestPercentage;
	}
	
	public double calculateInterest () {
		double balance = super.getBalance();
		double interes = (balance*interestPercentage)/100;
		return interes;
	}
	
	@Override 
	public void deposit(double sum) {
		double interes = calculateInterest();
		super.deposit(sum+interes);
	} 
	
}