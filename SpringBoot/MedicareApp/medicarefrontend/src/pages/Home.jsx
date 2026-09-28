import React from 'react';
import "../pages/Home.css";

function Home() {
  return (
    <div className="Home">

      {/* Hero / Main Container */}
      <div className="Home-container">

        <h2 className="main-title">
          Medicare Management System
        </h2>

        <h3>
          React + Spring Boot Full Stack Project
        </h3>

        <p className="description">
          Manage Doctors, Patients, Appointments, Billing and Notifications
          through one integrated healthcare system.
        </p>


        {/* Features */}
        <div className="features">

          {/* Doctor Management */}
          <div className="feature-card doctor-card">
            <h2>
              Doctor<br />
              Management
            </h2>

            <p>
              Add, Update, Delete and View Doctors.
            </p>
          </div>


          {/* Appointment Booking */}
          <div className="feature-card doctor-card">
            <h2>
              Appointment<br />
              Booking
            </h2>

            <p>
              Book appointments with available Doctors.
            </p>
          </div>


          {/* Payment System */}
          <div className="feature-card doctor-card">
            <h2>
              Payment System
            </h2>

            <p>
              Manage Billing and Payment Status Efficiently.
            </p>
          </div>


          {/* Patient Management */}
          <div className="feature-card doctor-card">
            <h2>
              Patient Management
            </h2>

            <p>
              Manage patient details and medical records.
            </p>
          </div>


          {/* Notifications */}
          <div className="feature-card doctor-card">
            <h2>
              Notifications
            </h2>

            <p>
              Manage appointment and payment notifications.
            </p>
          </div>

        </div>


        {/* Button */}
        <button className="home-btn">
          Explore System
        </button>

      </div>

    </div>
  );
}

export default Home;