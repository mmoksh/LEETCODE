/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> employeesMap = new HashMap<>();
        for (Employee employee: employees) {
            employeesMap.put(employee.id, employee);
        }
        return rec(employeesMap, id);
    }
    
    public int rec(HashMap<Integer, Employee> employeesMap, int id) {
        Employee employee = employeesMap.get(id);
        int importance = employee.importance;
        for (int subordinate: employee.subordinates) {
            importance += rec(employeesMap, subordinate);
        }
        return importance;
    }
}
