package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	public static int calculateTax(Employee employee, int numberOfMonthWorking) {
		
		int tax = 0;
		int numberOfChildren = employee.getNumberOfChildren();
		
		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}
		
		if (employee.getStatusMarried() && tax >= 0 ) {
			tax = (int) Math.round(0.05 * (((employee.getMonthlySalary() + employee.getOtherMonthlyIncome()) * numberOfMonthWorking) - employee.getAnnualDeductible() - (54000000 + 4500000 + (numberOfChildren * 1500000))));
		} else if (!employee.getStatusMarried() && tax >= 0) {
			tax = (int) Math.round(0.05 * (((employee.getMonthlySalary() + employee.getOtherMonthlyIncome()) * numberOfMonthWorking) - employee.getAnnualDeductible() - 54000000));
		}
		
		return tax;
			 
	}
	
}
