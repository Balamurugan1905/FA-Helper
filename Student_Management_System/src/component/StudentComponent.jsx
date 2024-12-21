import React, { useEffect } from 'react'
import { useState } from 'react'
import { createStudent, getStudent, updateStudent } from '../services/StudentService'
import { useNavigate, useParams } from 'react-router-dom';

const StudentComponent = () => {
  const[name,setName] = useState("")
  const[age,setAge] = useState("")
  const[email,setEmail] = useState("")

  const{id} = useParams();
  const[error,setError] = useState({
    name : '',
    age : '',
    email : ''
  })

  const navigator = useNavigate();

  useEffect(()=>{
    if(id) {
      getStudent(id).then((response) => {
        setName(response.data.name);
        setAge(response.data.age);
        setEmail(response.data.email);
      }).catch(error => {
        console.error(error);
      }
    )
    }
  },[id])

  function saveorupdateStudent(e) {
    e.preventDefault();

    if(validateForm()) {
      const student = {age,email,name}
      console.log(student);

      if(id) {
        updateStudent(id,student).then((response) => {
          console.log(response.data);
          navigator('/students')
        }).catch(error => {
            console.error(error);
        })
      } else {
        createStudent(student).then((response) => {
          console.log(response.data);
          navigator('/students')
        }).catch(error => {
          console.error(error);
        })
      }
    }
  }

  function validateForm() {
    let valid = true;

    const errorCopy = {... error}

    if(name.trim())  {
      errorCopy.name = '';
    }else {
      errorCopy.name = 'Student Name is Required';
      valid = false;
    }

    if(String(age).trim())  {
      errorCopy.age = '';
    }else {
      errorCopy.age = 'Student Age is Required';
      valid = false;
    }

    if(email.trim())  {
      errorCopy.email = '';
    }else {
      errorCopy.email = 'Student Email is Required';
      valid = false;
    }

    setError(errorCopy);
    return valid;
  }

  function pageTitle() {
    if(id) {
      return <h2 className='text-center'>Update Student</h2>
    } else {
      return <h2 className='text-center'>Add Student</h2>
    }
  }

  return (
    <div>
      <div className='container'>
        <br /><br />
        <div className='row'>
          <div className='card col-md-6 offset-md-3 offset md-3'>
            
            {
              pageTitle()
            }
            <div className='card-body'>
              <form>
                <div className='form-grup nb-2'>
                  <label className='form-label'>Student Name :</label>
                  <input 
                    type="text" 
                    placeholder='Enter Student Name' 
                    name='name' 
                    value={name} 
                    className={`form-control ${error.name ? 'is-invalid':''}`}
                    onChange={(e) => setName(e.target.value)} />

                    {error.name && <div className='invalid-feedback'> {error.name}</div>}
                </div>

                <div className='form-grup nb-2'>
                  <label className='form-label'>Age :</label>
                  <input 
                  type="text" 
                  placeholder='Enter Student Age' 
                  name='age' 
                  value={age} 
                  className={`form-control ${error.age ? 'is-invalid':''}`} 
                  onChange={(e) => setAge(e.target.value)}/>
                  {error.age && <div className='invalid-feedback'> {error.age}</div>}
                </div>

                <div className='form-grup nb-2'>
                  <label className='form-label'>Email :</label>
                  <input 
                  type="text" 
                  placeholder='Enter Student Email' 
                  name='email' 
                  value={email} 
                  className={`form-control ${error.email ? 'is-invalid':''}`}
                  onChange={(e) => setEmail(e.target.value)}/>
                  {error.email && <div className='invalid-feedback'> {error.email}</div>}
                </div>
                <button className='btn btn-success' onClick={saveorupdateStudent}>Submit</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default StudentComponent