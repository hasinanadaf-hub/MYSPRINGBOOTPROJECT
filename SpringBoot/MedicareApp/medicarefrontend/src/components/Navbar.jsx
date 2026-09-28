import React from 'react'
import { Link } from 'react-router-dom'
import '../components/Navbar.css';
function Navbar() {
  return (
    <nav className="navbar">
        <div className='logo'>
            MEDICARE <span>+</span>
        </div>
        <ul className='nav-links'>
            <li>
            <Link to="/">Home </Link>
            </li>
            <li>
                <Link to="/doctors">Doctors</Link>
            </li>
            <li>
                <Link to="/appointments">Appoinments</Link>
            </li>
            <li>
                <Link to="/appointments/add">Book Appointments</Link>
            </li>
            <li>
                <Link to="/login">Login</Link>
            </li>
        </ul>
    </nav>
  )
}

export default Navbar
