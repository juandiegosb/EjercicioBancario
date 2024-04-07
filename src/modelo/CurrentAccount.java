package modelo;

public class CurrentAccount extends Account{
	
	//se dejo en 10 como constante
	private double overdraft = 10;
	private boolean isOverdraft = false;
	
	public CurrentAccount (int a) {
		super (a);
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	public boolean isOverdraft() {
		return isOverdraft;
	}

	public void setOverdraft(boolean isOverdraft) {
		this.isOverdraft = isOverdraft;
	}

	
	@Override 
	public void withdraw(double sum) {
		if (sum > (super.getBalance()+overdraft))  System.out.println("Superaste el monto de sobregiro (retiro erroneo)");
		else {
			if ((super.getBalance()-sum) < 0) this.isOverdraft=true;
			super.withdraw(sum);
		}
	}
	
}
