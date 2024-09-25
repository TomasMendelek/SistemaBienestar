"use client";  // Marcar el componente como Client Component

import { useEffect, useState } from 'react';
import { getActivities } from '@/app/services/api';

// Definir el tipo de actividad
interface Activity {
  id: string;
  nombre: string;
  descripcion: string;
  duracion: number;
}

export default function Explore() {
  const [activities, setActivities] = useState<Activity[]>([]);

  useEffect(() => {
    getActivities().then(setActivities);
  }, []);

  return (
    <div className="min-h-screen p-8">
      <h1 className="text-4xl font-bold mb-6">Explorar Actividades</h1>
      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
        {activities.map((activity) => (
          <div key={activity.id} className="p-4 border rounded shadow">
            <h2 className="text-xl font-semibold">{activity.nombre}</h2>
            <p>{activity.descripcion}</p>
          </div>
        ))}
      </div>
    </div>
  );
}
