class SingleResponsibility {
    public static void main(String[] args){
        Employee emp = new Employee("Avinash", "Software Developer");
        EmployeeReportGenerator reportGen = new EmployeeReportGenerator();
        EmployeeReportPrinter printer = new EmployeeReportPrinter();

        String report = reportGen.reportGenerate(emp);
        printer.print(report);
    }
}