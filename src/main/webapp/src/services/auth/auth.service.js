import axios from "axios";

const API_URL = "http://localhost:8080/api/auth/";

const register = (username, email, password) => {
    return axios.post(API_URL + "signup", {
        username,
        email,
        password,
    });
};

const login = async (username, password) => {
    return axios
        .post(API_URL + "login", {
            username,
            password,
        })
        .then((response) => {
            if (response.data.accessToken) {
                localStorage.setItem("user", JSON.stringify(response.data));
            }
            return response.data;
        });
};

const logout = () => {
    localStorage.removeItem("user");
};

const getCurrentUser = () => {
    console.log("Logging user")
    console.log(localStorage.getItem("user"))
    return JSON.parse(localStorage.getItem("user"));
};

const auth_service = {
    register,
    login,
    logout,
    getCurrentUser,
}

export default auth_service;