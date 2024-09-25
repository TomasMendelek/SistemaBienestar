"use client";

import { useEffect, useState } from 'react';
import { useParams } from 'next/navigation';
import { getActivityById } from '@/app/services/api';

// Define el tipo de actividad
interface Activity {
  id: string;
  nombre: string;
  descripcion: string;
  duracion: number;
}

export default function ActivityDetails() {
  const params = useParams();  // Obtiene los parámetros de la URL
  let id = params.id;

  // Asegurarse de que 'id' sea siempre un string
  if (Array.isArray(id)) {
    id = id[0];  // Si 'id' es un array, toma el primer elemento
  }

  const [activity, setActivity] = useState<Activity | null>(null);

  useEffect(() => {
    if (id) {
      getActivityById(id).then(setActivity);
    }
  }, [id]);

  if (!activity) return <div>Cargando actividad...</div>;

  return (
    <div className="min-h-screen p-8">
      <h1 className="text-4xl font-bold">{activity.nombre}</h1>
      <p className="mt-4">{activity.descripcion}</p>
      <p className="mt-2"><strong>Duración:</strong> {activity.duracion} minutos</p>
    </div>
  );
}
