public class Payroll {

    private Worker worker;

    public Payroll(){}

    public void processPayments(Worker worker){
        System.out.println("Payroll processed for worker" + worker.getName());
    }
}
