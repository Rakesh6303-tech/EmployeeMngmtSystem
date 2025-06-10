import React, { useEffect, useState } from 'react';
import { deleteEmployee, listEmployees } from '../service/EmployeeService'; // This must match the named export
import { useNavigate } from 'react-router-dom';
import "../style/Listemployee.css";
const ListEmployeeComponent = () => {
    const [employees, setEmployees] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const navigator = useNavigate();

    useEffect(() => {
        getAllEmployees();
    }, []);

    function getAllEmployees(){
        listEmployees()
            .then((response) => {
                setEmployees(response.data);
                setLoading(false);
            })
            .catch((error) => {
                console.error(error);
                setError('Failed to fetch employees.');
                setLoading(false);
            });
    }

    function addNewEmployee()
    {
        navigator('/add-employee')
    }
    function updateEmployee(id)
    {
        navigator(`/edit-employee/${id}`)
    }
    function removeEmployee(id){
        console.log(id);

        // If user once click on delte btn then particular emp deleted and navigate to emples page
        deleteEmployee(id).then((response) =>{
            getAllEmployees();

        }).catch(error =>{
            console.error(error);
        })
    }
    return (
        <div className='container'>
            <h2 className='text-center'>List of Employees</h2>
            <button className='btn btn-primary mb-2' onClick={addNewEmployee}>Add Employee</button>
            {error && <p className="text-danger">{error}</p>}
            {loading ? (
                <p>Loading...</p>
            ) : (
                <table className='table table-striped table-bordered'>
                    <thead>
                        <tr>
                            <th>Employee Id</th>
                            <th>Employee First Name</th>
                            <th>Employee Last Name</th>
                            <th>Employee Email Id</th>
                            <th>Actions</th>

                        </tr>
                    </thead>
                    <tbody>
                        {employees.map((employee) => (
                            <tr key={employee.id}>
                                <td>{employee.id}</td>
                                <td>{employee.firstName}</td>
                                <td>{employee.lastName}</td>
                                <td>{employee.email}</td>
                                <td>
                                    <button className='btn btn-info' onClick={() =>updateEmployee(employee.id)}>Update</button>
                                    <button className='btn btn-danger'onClick={() => removeEmployee(employee.id)}
                                        style={{marginLeft:'10px'}}
                                        >Delete</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
        </div>
    );
};

export default ListEmployeeComponent;
