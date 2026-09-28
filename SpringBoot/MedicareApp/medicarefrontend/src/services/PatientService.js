import axios from "axios";

const BASE_URL = "http://localhost:8080/api/v1";

class PatientServices {

    // Get All Patients
    getAllPatients() {
        return axios.get(`${BASE_URL}/getallPatient`);
    }


    // Get Patient By ID
    getPatientById(id) {
        return axios.get(`${BASE_URL}/getPatientById/${id}`);
    }


    // Save Patient
    savePatient(patient) {
        return axios.post(
            `${BASE_URL}/savePatient`,
            patient
        );
    }


    // Delete Patient
    deletePatient(id) {
        return axios.delete(
            `${BASE_URL}/deletePatient/${id}`
        );
    }


    // Update Patient
    updatePatient(id, patient) {
        return axios.put(
            `${BASE_URL}/updatePatient/${id}`,
            patient
        );
    }


    // Get Patients By Blood Group
    getPatientsByBloodGroup(bloodGroup) {
        return axios.get(
            `${BASE_URL}/getPatientByBloodGroup/${bloodGroup}`
        );
    }
}

export default new PatientServices();