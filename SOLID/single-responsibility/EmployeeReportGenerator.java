class EmployeeReportGenerator {

    public String reportGenerate(Employee employee){
        return "Employee "+ employee.getName() + " is in position "+ employee.getPosition();
    }
}