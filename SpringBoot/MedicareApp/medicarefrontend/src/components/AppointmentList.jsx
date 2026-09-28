import React, { useState, useEffect } from 'react';
import AppointmentServices from '../services/AppointmentServices';
import "../components/ListDisplay.css";

function AppointmentList() {

    const [appointmentlist, setAppointmentList] = useState([]);

    useEffect(() => {

        AppointmentServices.getAllAppointments()
            .then((res) => {

                console.log("Complete Response:", res);
                console.log("Response Data:", res.data);

                // If API directly returns an array
                if (Array.isArray(res.data)) {
                    setAppointmentList(res.data);
                }

                // If API returns { data: [...] }
                else if (Array.isArray(res.data.data)) {
                    setAppointmentList(res.data.data);
                }

                // If API returns { appointments: [...] }
                else if (Array.isArray(res.data.appointments)) {
                    setAppointmentList(res.data.appointments);
                }

                else {
                    console.error("Unexpected API response:", res.data);
                    setAppointmentList([]);
                }
            })
            .catch((err) => {
                console.error("Error fetching appointments:", err);
                setAppointmentList([]);
            });

    }, []);

    return (
        <div className="container">

            <div className="table-card">

                <h2>Appointment Details</h2>

                <table>

                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Patient</th>
                            <th>Doctor</th>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Status</th>
                            <th>Payment</th>
                            <th>Bill</th>
                        </tr>
                    </thead>

                    <tbody>

                        {appointmentlist.length > 0 ? (

                            appointmentlist.map((a) => (

                                <tr key={a.id}>

                                    <td>{a.id}</td>

                                    <td>
                                        {a.user?.name || "N/A"}
                                    </td>

                                    <td>
                                        {a.doctor?.name || "N/A"}
                                    </td>

                                    <td>
                                        {a.appointmentDate || a.appointmentdate || "N/A"}
                                    </td>

                                    <td>
                                        {a.timeSlot || a.timeslot || "N/A"}
                                    </td>

                                    <td>
                                        {a.status || "N/A"}
                                    </td>

                                    <td>
                                        {a.paymentStatus || a.paymentstatus || "N/A"}
                                    </td>

                                    <td>
                                        {a.billamount || "N/A"}
                                    </td>

                                </tr>

                            ))

                        ) : (

                            <tr>
                                <td colSpan="8">
                                    No appointments found
                                </td>
                            </tr>

                        )}

                    </tbody>

                </table>

            </div>

        </div>
    );
}

export default AppointmentList;
