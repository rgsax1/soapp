import axios from "axios";

const USER_REST_API_BASE_URL = 'http://localhost:8080/api/v1/users';

export const listUsers = ()=> axios.get(USER_REST_API_BASE_URL);

export const createUser = (user) => axios.post(USER_REST_API_BASE_URL, user);

export const getUser = (userId) => axios.get(USER_REST_API_BASE_URL + '/' + userId);

export const updateUser = (userId, user) => axios.put(USER_REST_API_BASE_URL + '/' +userId, user);

export const deleteUser = (userId) => axios.delete(USER_REST_API_BASE_URL + '/' + userId);

