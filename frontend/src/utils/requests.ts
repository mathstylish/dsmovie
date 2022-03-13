const HOST = "localhost";
const PORT = 8080;
const LOCALHOST = `http://${HOST}:${PORT}`;
export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? LOCALHOST;
