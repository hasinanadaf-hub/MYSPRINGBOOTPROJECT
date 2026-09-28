import axios from "axios";

const BASE_URL = "http://localhost:8080/api/v1";

class DoctorServices {

    getAllDoctors() {
        return axios.get(`${BASE_URL}/getAlldoctors`);
    }

    getDoctorById(id) {
        return axios.get(
            `${BASE_URL}/getDoctorById/${id}`
        );
    }

    saveDoctor(doctor) {
        return axios.post(
            `${BASE_URL}/savedoctor`,
            doctor
        );
    }

    deleteDoctor(id) {
        return axios.delete(
            `${BASE_URL}/deleteDoctor/${id}`
        );
    }

    updateDoctor(id, doctor) {
        return axios.put(
            `${BASE_URL}/updateDoctor/${id}`,
            doctor
        );
    }
}

export default new DoctorServices();