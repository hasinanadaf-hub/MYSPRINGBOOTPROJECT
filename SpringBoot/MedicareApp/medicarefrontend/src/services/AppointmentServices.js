import axios from "axios";

const  url ="http://localhost:8080/api/appointment";

class AppointmentService
{
    getAllAppointments()
    {
      return  axios.get(url+"/getappointments")
    }
    addAppointment(data)
    {
        return axios.post(url+"/addappointment",data)
    }
}

export default new AppointmentService();