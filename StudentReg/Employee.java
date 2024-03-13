package StudentReg;

public abstract class Employee extends Person implements Payment {
    private final String empId;
    private int startYear;
    private Payment payment;

    public Employee(String lname, String fname) {
        super(lname, fname);
        empId = getEmployeeIdString() + getRandomId(ConstantValues.MIN_EMP_ID, ConstantValues.MAX_EMP_ID);
        startYear = ConstantValues.getCurrentYear();
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(final int startYear) {
        if (ConstantValues.MIN_START_YEAR < startYear && startYear <= ConstantValues.getCurrentYear()) {
            this.startYear = startYear;
        }
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        if (payment != null) {
            this.payment = payment;
        }
    }

    @Override
    public String getIdString() {
        return empId;
    }

    @Override
    public double calculatePayment() {
        if (payment != null) {
            return payment.calculatePayment();
        }
        return 0.0;
    }

    protected abstract String getEmployeeIdString();
}
