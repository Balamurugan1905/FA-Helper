import React, { useEffect, useState } from 'react'
import { deleteStudent, listStudent } from '../services/StudentService'
import { useNavigate } from 'react-router-dom'

const ListStudentComponent = () => {

const [student, setStudent] = useState([])

const navigator = useNavigate();

useEffect(() => {
    getAllStudent();
},[]);

    function getAllStudent() {
        listStudent().then((response) => {
            setStudent(response.data);
        }).catch(error => {
            console.error(error);
        })
    }
    
    function addStudent() {
        navigator('/add-student')
    }

    function updateStudent(id) {
        navigator(`/update-students/${id}`)
    }

    function removeStudent(id) {
        console.log(id);
        deleteStudent(id).then((response) =>{
            getAllStudent();
        }).catch(error => {
            console.error(error);
        })
    }

  return (
    <div className='container'>
        <h2>List of Students</h2>
        <button className='btn btn-primary mb-2' onClick={addStudent}>Add Student</button>
        <table className='table table-striped table-border'>
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Student Name</th>
                    <th>Student Age</th>
                    <th>Student Email</th>
                    <th>Action</th>
                </tr>
            </thead>

            <tbody>
            {
                student.map(student =>
                    <tr key={student.id}>
                        <td>{student.id}</td>
                        <td>{student.name}</td>
                        <td>{student.age}</td>
                        <td>{student.email}</td>
                        <td>
                            <button className='btn btn-info' onClick={() => updateStudent(student.id)}>Update</button>
                            <button className='btn btn-danger' onClick={() => removeStudent(student.id)}
                                style={{marginLeft:'10px'}}
                                >Delete</button>

                        </td>
                    </tr>
                )
            }
            </tbody>
        </table>
    </div>
  )
}

export default ListStudentComponent