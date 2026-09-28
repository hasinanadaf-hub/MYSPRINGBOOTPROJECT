import React from 'react'
import AppointmentList from './components/AppointmentList'
import AddAppointment from './components/AddAppointment'
import { BrowserRouter, Route,  Routes } from 'react-router-dom'

import Navbar from './components/Navbar'
import Home from './pages/Home'
import DoctorList from './components/DoctorList'
import Login from './components/Login'

function App() {
  return (
    <BrowserRouter>
      <Navbar/>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/appointments/add" element={<AddAppointment/>}/>
        <Route path="/appointments" element={<AppointmentList/>}/>
        <Route path="/doctors" element={<DoctorList/>}/>
        <Route path="/login" element={<Login/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
