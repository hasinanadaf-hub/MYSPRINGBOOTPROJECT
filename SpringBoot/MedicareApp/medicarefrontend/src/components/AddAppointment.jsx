import React, { useEffect, useState } from "react";
import AppointmentServices from "../services/AppointmentServices";
import PatientServices from "../services/PatientService"
import DoctorServices from "../services/DoctorService"

function AddAppointment() {

    const [patients, setPatients] = useState([]);
    const [doctors, setDoctors] = useState([]);

    const [data, setData] = useState({
        appointmentdate: "",
        timeslot: "",
        reason: "",
        status: "BOOKED",
        paymentstatus: "PENDING",
        paymentmode: "",
        billamount: "",

        patient: {
            id: ""
        },

        doctor: {
            id: ""
        }
    });


    // Load Patient and Doctor List
    useEffect(() => {
        loadPatients();
        loadDoctors();
    }, []);


    // Get all patients
    const loadPatients = async () => {

        try {

            const response =
                await PatientServices.getAllPatients();

            console.log("Patient List:", response.data);

            setPatients(response.data);

        } catch (error) {

            console.log("Patient Error:", error);

        }
    };


    // Get all doctors
    const loadDoctors = async () => {

        try {

            const response =
                await DoctorServices.getAllDoctors();

            console.log("Doctor List:", response.data);

            setDoctors(response.data);

        } catch (error) {

            console.log("Doctor Error:", error);

        }
    };


    // Normal fields
    const handleChange = (e) => {

        const { name, value } = e.target;

        setData({
            ...data,
            [name]: value
        });
    };


    // Patient selection
    const handlePatientChange = (e) => {

        setData({
            ...data,
            patient: {
                id: Number(e.target.value)
            }
        });
    };


    // Doctor selection
    const handleDoctorChange = (e) => {

        setData({
            ...data,
            doctor: {
                id: Number(e.target.value)
            }
        });
    };


    // Submit appointment
    const handleSubmit = async (e) => {

        e.preventDefault();

        console.log("Appointment Data:", data);

        try {

            const response =
                await AppointmentServices.addAppointment(data);

            console.log("Saved Appointment:", response.data);

            alert("Appointment Added Successfully!");

            // Reset form
            setData({
                appointmentdate: "",
                timeslot: "",
                reason: "",
                status: "BOOKED",
                paymentstatus: "PENDING",
                paymentmode: "",
                billamount: "",

                patient: {
                    id: ""
                },

                doctor: {
                    id: ""
                }
            });

        } catch (error) {

            console.log("Appointment Error:", error);

            if (error.response) {
                console.log(
                    "Backend Error:",
                    error.response.data
                );
            }

            alert("Error while adding appointment");
        }
    };


    return (

        <div className="container mt-4">

            <div className="card shadow">

                <div className="card-header bg-primary text-white">

                    <h3 className="mb-0">
                        Add Appointment
                    </h3>

                </div>


                <div className="card-body">

                    <form onSubmit={handleSubmit}>

                        <div className="row">


                            {/* Patient */}

                            <div className="col-md-6 mb-3">

                                <label className="form-label">
                                    Select Patient
                                </label>

                                <select
                                    className="form-select"
                                    value={data.patient.id}
                                    onChange={handlePatientChange}
                                    required
                                >

                                    <option value="">
                                        -- Select Patient --
                                    </option>

                                    {patients.map((patient) => (

                                        <option
                                            key={patient.id}
                                            value={patient.id}
                                        >

                                            {patient.firstname}{" "}
                                            {patient.lastname}

                                        </option>

                                    ))}

                                </select>

                            </div>


                            {/* Doctor */}

                            <div className="col-md-6 mb-3">

                                <label className="form-label">
                                    Select Doctor
                                </label>

                                <select
                                    className="form-select"
                                    value={data.doctor.id}
                                    onChange={handleDoctorChange}
                                    required
                                >

                                    <option value="">
                                        -- Select Doctor --
                                    </option>

                                    {doctors.map((doctor) => (

                                        <option
                                            key={doctor.id}
                                            value={doctor.id}
                                        >

                                            {doctor.name}{" "}
                                            -{" "}
                                            {doctor.specialization}

                                        </option>

                                    ))}

                                </select>

                            </div>


                            {/* Appointment Date */}

                            <div className="col-md-6 mb-3">

                                <label className="form-label">
                                    Appointment Date
                                </label>

                                <input
                                    type="date"
                                    name="appointmentdate"
                                    className="form-control"
                                    value={data.appointmentdate}
                                    onChange={handleChange}
                                    required
                                />

                            </div>


                            {/* Time Slot */}

                            <div className="col-md-6 mb-3">

                                <label className="form-label">
                                    Time Slot
                                </label>

                                <input
                                    type="time"
                                    name="timeslot"
                                    className="form-control"
                                    value={data.timeslot}
                                    onChange={handleChange}
                                    required
                                />

                            </div>


                            {/* Reason */}

                            <div className="col-md-12 mb-3">

                                <label className="form-label">
                                    Reason
                                </label>

                                <textarea
                                    name="reason"
                                    className="form-control"
                                    rows="3"
                                    placeholder="Enter appointment reason"
                                    value={data.reason}
                                    onChange={handleChange}
                                    required
                                />

                            </div>


                            {/* Status */}

                            <div className="col-md-6 mb-3">

                                <label className="form-label">
                                    Status
                                </label>

                                <select
                                    name="status"
                                    className="form-select"
                                    value={data.status}
                                    onChange={handleChange}
                                >

                                    <option value="BOOKED">
                                        BOOKED
                                    </option>

                                    <option value="CONFIRMED">
                                        CONFIRMED
                                    </option>

                                    <option value="CANCELLED">
                                        CANCELLED
                                    </option>

                                    <option value="COMPLETED">
                                        COMPLETED
                                    </option>

                                </select>

                            </div>


                            {/* Payment Status */}

                            <div className="col-md-6 mb-3">

                                <label className="form-label">
                                    Payment Status
                                </label>

                                <select
                                    name="paymentstatus"
                                    className="form-select"
                                    value={data.paymentstatus}
                                    onChange={handleChange}
                                >

                                    <option value="PENDING">
                                        PENDING
                                    </option>

                                    <option value="PAID">
                                        PAID
                                    </option>

                                </select>

                            </div>


                            {/* Payment Mode */}

                            <div className="col-md-6 mb-3">

                                <label className="form-label">
                                    Payment Mode
                                </label>

                                <select
                                    name="paymentmode"
                                    className="form-select"
                                    value={data.paymentmode}
                                    onChange={handleChange}
                                >

                                    <option value="">
                                        -- Select Payment Mode --
                                    </option>

                                    <option value="CASH">
                                        CASH
                                    </option>

                                    <option value="CARD">
                                        CARD
                                    </option>

                                    <option value="UPI">
                                        UPI
                                    </option>

                                </select>

                            </div>


                            {/* Bill Amount */}

                            <div className="col-md-6 mb-3">

                                <label className="form-label">
                                    Bill Amount
                                </label>

                                <input
                                    type="number"
                                    name="billamount"
                                    className="form-control"
                                    placeholder="Enter bill amount"
                                    value={data.billamount}
                                    onChange={handleChange}
                                />

                            </div>

                        </div>


                        {/* Buttons */}

                        <button
                            type="submit"
                            className="btn btn-primary"
                        >
                            Book Appointment
                        </button>

                        <button
                            type="reset"
                            className="btn btn-secondary ms-2"
                            onClick={() => setData({
                                appointmentdate: "",
                                timeslot: "",
                                reason: "",
                                status: "BOOKED",
                                paymentstatus: "PENDING",
                                paymentmode: "",
                                billamount: "",
                                patient: {
                                    id: ""
                                },
                                doctor: {
                                    id: ""
                                }
                            })}
                        >
                            Reset
                        </button>

                    </form>

                </div>

            </div>

        </div>
    );
}

export default AddAppointment;