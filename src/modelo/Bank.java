package modelo;
import java.util.ArrayList;
public class Bank {

	ArrayList <Account> cuentas = new ArrayList <>();
	
	public void openAccount (char tipo, int numeroCuenta) {
		
		if (tipo == 'A') {
			SavingsAccount cunetaAhorros = new SavingsAccount(numeroCuenta);
			cuentas.add(cunetaAhorros);
			return;
		}
		
		if (tipo == 'C') {
			CurrentAccount cuentaCorriente = new CurrentAccount(numeroCuenta);
			cuentas.add(cuentaCorriente);
			return;
		}
		
		else System.out.println("Caraceter incorrecto (A: ahorro, C: corriente)");
			
	}
	
	public void payDividend (int numeroCuenta, int monto) {
		
		for (Account i: cuentas) {
			if (i.getAccountNumber() == numeroCuenta) {
				i.deposit(monto);
				return;
			}
		}
		System.out.println("Cuenta no existe");
	}
	
	public double getBalanceAccount (int numeroCuenta) {
		
		for (Account i: cuentas) {
			if (i.getAccountNumber() == numeroCuenta) {
				return i.getBalance();
			}
		}
		System.out.println("Cuenta no existe");
		return-11;
		
	}
	
	public void withdrawAccount (int numeroCuenta, double monto) {
		
		for (Account i: cuentas) {
			if (i.getAccountNumber() == numeroCuenta) {
				i.withdraw(monto);
				return;
			}
		}
		System.out.println("Cuenta no existe");
		
	}
	
	public void sendLetterToOverdraftAccounts() {
		for (Account i : cuentas) {
			if(i instanceof CurrentAccount) {
				if(((CurrentAccount)i).isOverdraft()) i.print();
			}
		}

	}
	
	
}
