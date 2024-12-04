import axios from 'axios';

export const getAuthToken = () => {
    return window.localStorage.getItem('auth_token');
};

export const setAuthHeader = (token) => {
    if (token !== null) {
      window.localStorage.setItem("auth_token", token);
    } else {
      window.localStorage.removeItem("auth_token");
    }
};

// Use the environment variable for the base URL
axios.defaults.baseURL = process.env.REACT_APP_BACKEND_URL;
axios.defaults.headers.post['Content-Type'] = 'application/json';

export const request = (method, url, data) => {
    let headers = {};
    if (getAuthToken() !== null && getAuthToken() !== "null") {
        headers = {'Authorization': `Bearer ${getAuthToken()}`};
    }

    return axios({
        method: method,
        url: url,
        headers: headers,
        data: data
    });
};






// import axios from 'axios';


// export const getAuthToken = () => {
//     return window.localStorage.getItem('auth_token');
// };

// export const setAuthHeader = (token) => {
//     if (token !== null) {
//       window.localStorage.setItem("auth_token", token);
//     } else {
//       window.localStorage.removeItem("auth_token");
//     }
// };

// axios.defaults.baseURL = 'http://localhost:8080';
// axios.defaults.headers.post['Content-Type'] = 'application/json';

// export const request = (method, url, data) => {

//     let headers = {};
//     if (getAuthToken() !== null && getAuthToken() !== "null") {
//         headers = {'Authorization': `Bearer ${getAuthToken()}`};
//     }

//     return axios({
//         method: method,
//         url: url,
//         headers: headers,
//         data: data});
// };