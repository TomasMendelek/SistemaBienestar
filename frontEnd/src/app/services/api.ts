import axios from 'axios';

const API_URL = 'https://bienestar-production.up.railway.app/api';

// Obtener todas las actividades
export const getActivities = async () => {
  const response = await axios.get(`${API_URL}/actividades`);
  return response.data;   
};

// Obtener detalles de una actividad
export const getActivityById = async (id: string) => {
  const response = await axios.get(`${API_URL}/actividades/${id}`);
  return response.data;
};

// Crear una reservación
export const makeReservation = async (actividadId: string, fechaHora: string) => {
  const response = await axios.post(`${API_URL}/reservas`, {
    actividadId,
    fechaHora,
  });
  return response.data;
};

// Obtener el progreso del usuario
export const getUserProgress = async () => {
  const response = await axios.get(`${API_URL}/usuarios/progreso`);
  return response.data;
};
