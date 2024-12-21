import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ListStudentComponent from './component/ListStudentComponent'
import FooterComponent from './component/FooterComponent'
import HeaderofComponent from './component/HeaderofComponent'
import {BrowserRouter, Route, Routes } from 'react-router-dom'
import StudentComponent from './component/StudentComponent'

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderofComponent/>
        <Routes>

           {/* //http://localhost:7013 */}
           <Route path='/' element={<ListStudentComponent/>}></Route>

           {/* //http://localhost:7013/Students */}
           <Route path='/students' element= {<ListStudentComponent/>}></Route>

           {/* //http://localhost:7013/add-student */}
           <Route path='/add-student' element={<StudentComponent/>}></Route>

           {/* //http://localhost:7013/update-student/1 */}
           <Route path='/update-students/:id' element={<StudentComponent/>}></Route>

        </Routes>
        <FooterComponent/>
      </BrowserRouter>
    </>
  )
}

export default App
