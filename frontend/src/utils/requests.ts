const HOST = "localhost" || "127.0.0.1";
const PORT = 8080;
const LOCALHOST = `http://${HOST}:${PORT}`;
export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? LOCALHOST;
